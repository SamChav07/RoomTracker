document.addEventListener("DOMContentLoaded", () => {
    cargarDatosIniciales();
    configurarFechaActual();
    configurarFormulario();
});

async function cargarDatosIniciales() {
    await Promise.all([
        cargarSelect("/plantillas", "plantillaId", p => ({
            value: p.id,
            text: `[${p.id}]: ${p.grupo?.profesor?.nombre || 'Sin profesor'}`,
            objeto: p
        })),
        cargarSelect("/ambientes", "ambienteId", a => ({
            value: a.id,
            text: `[${a.codigo}]: ${a.tipoAmbiente}`,
            objeto: a
        }), true),
        cargarSelect("/bloques", "nuevoTimeSlotId", t => ({
            value: t.id,
            text: `${t.horaInicio?.slice(0, 5)} - ${t.horaFin?.slice(0, 5)}`,
            objeto: t
        }), true),
        cargarSelect("/grupos", "grupoId", g => ({
            value: g.id,
            text: `[${g.codigo}]: ${g.profesor?.nombre || 'Sin profesor'}`,
            objeto: g
        }))
    ]);
}

async function cargarSelect(url, selectId, mapFn, incluirOpcionVacia = false) {
    try {
        const response = await fetch(url);
        if (!response.ok) throw new Error(`Error HTTP ${response.status}`);
        const data = await response.json();

        const select = document.getElementById(selectId);
        if (!select) return console.warn(`⚠️ No se encontró el select con id "${selectId}"`);

        select.innerHTML = incluirOpcionVacia ? "<option value=''>-- Seleccionar --</option>" : "";

        data.forEach(item => {
            const option = document.createElement("option");
            const mapped = mapFn(item);
            option.value = mapped.value;
            option.textContent = mapped.text;
            option.dataset.objeto = JSON.stringify(mapped.objeto);
            select.appendChild(option);
        });

        console.log(`✅ ${selectId} cargado con ${data.length} opciones`);
    } catch (error) {
        console.error(`❌ Error al cargar ${selectId}:`, error);
        alert(`❌ Error al cargar ${selectId}`);
    }
}

function configurarFechaActual() {
    const inputFecha = document.getElementById('fecha');
    if (inputFecha) inputFecha.valueAsDate = new Date();
}

function configurarFormulario() {
    const form = document.getElementById('formularioExcepcionReserva');
    if (!form) return console.error("❌ No se encontró el formulario");

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const getValue = id => document.getElementById(id)?.value;
        const parseValue = id => parseInt(getValue(id)) || null;

        const excepcionData = {
            plantillaId: parseValue("plantillaId"),
            fecha: getValue("fecha"),
            tipo: getValue("tipo"),
            grupoId: parseValue("grupoId"),
            ambienteId: parseValue("ambienteId"),
            nuevoTimeSlotId: parseValue("nuevoTimeSlotId")
        };

        if (!excepcionData.plantillaId || !excepcionData.fecha || !excepcionData.tipo || !excepcionData.grupoId) {
            alert("❗ Por favor completa todos los campos obligatorios");
            return;
        }

        try {
            const response = await fetch('/excepciones', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(excepcionData)
            });

            if (!response.ok) {
                const errorData = await response.json();
                throw new Error('❌ Error al crear excepción: ' + (errorData.message || 'Error desconocido'));
            }

            alert("✅ Excepción creada correctamente");
            window.location.href = '/listar/excepcionReserva';

        } catch (error) {
            console.error("❌", error);
            alert(error.message);
        }
    });
}