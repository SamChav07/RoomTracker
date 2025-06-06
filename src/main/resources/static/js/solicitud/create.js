document.addEventListener("DOMContentLoaded", () => {
    cargarCoordinadores();
    cargarPeriodos();
    cargarBloquesHorario();
    cargarGrupos();
});

async function cargarCoordinadores() {
    try {
        const response = await fetch("/coordinadores");
        const data = await response.json();

        const select = document.getElementById("coordinador");
        select.innerHTML = "";

        data.forEach(c => {
            const option = document.createElement("option");
            option.value = c.id;
            option.textContent = c.usuario?.nombre || "Sin nombre";  // ACCESO CORRECTO
            option.dataset.objeto = JSON.stringify(c);
            select.appendChild(option);
        });
    } catch (error) {
        console.error("❌ Error al cargar coordinadores:", error);
        alert("❌ Error al cargar coordinadores");
    }
}

async function cargarPeriodos() {
    try {
        const response = await fetch("/periodos");
        const data = await response.json();

        const select = document.getElementById("periodo");
        select.innerHTML = ""; // Limpia opciones anteriores

        data.forEach(p => {
            const option = document.createElement("option");
            option.value = p.codigo;
            option.textContent = p.descripcion;
            option.dataset.objeto = JSON.stringify(p);
            select.appendChild(option);
        });
    } catch (error) {
        console.error("❌ Error al cargar periodos:", error);
        alert("❌ Error al cargar periodos");
    }
}

async function cargarBloquesHorario() {
    try {
        const response = await fetch("/bloques");
        const data = await response.json();

        // Selecciona todos los selects de tipo bloqueInicioId dentro de items
        const selectores = document.querySelectorAll("select[name='bloqueInicioId']");
        selectores.forEach(select => {
            select.innerHTML = ""; // Limpia anteriores

            data.forEach(b => {
                const option = document.createElement("option");
                option.value = b.id; // usa el ID como valor

                // Asegúrate que las horas estén en el formato correcto
                const horaInicio = b.horaInicio?.slice(0, 5); // por ejemplo "07:00"
                const horaFin = b.horaFin?.slice(0, 5);       // por ejemplo "10:00"

                option.textContent = `${horaInicio} - ${horaFin}`; // muestra "7:00 - 10:00"
                option.dataset.objeto = JSON.stringify(b);
                select.appendChild(option);
            });
        });
    } catch (error) {
        console.error("❌ Error al cargar los bloques horarios:", error);
        alert("❌ Error al cargar bloques");
    }
}

async function cargarGrupos() {
    try {
        const response = await fetch("/grupos");
        const data = await response.json();

        const selectores = document.querySelectorAll("select[name='grupoId']");
        selectores.forEach(select => {
            select.innerHTML = "";

            data.forEach(g => {
                const option = document.createElement("option");
                option.value = g.id;
                option.textContent = g.nombre || `Grupo ${g.id}`;
                option.dataset.objeto = JSON.stringify(g);
                select.appendChild(option);
            });
        });
    } catch (error) {
        console.error("❌ Error al cargar grupos:", error);
        alert("❌ Error al cargar grupos");
    }
}

document.getElementById('formularioSolicitudCompleta').addEventListener('submit', async function (event) {
    event.preventDefault();

    const coordinadorSelect = document.getElementById('coordinador');
    const periodoSelect = document.getElementById('periodo');

    const coordinadorId = parseInt(coordinadorSelect.value);
    const periodoAcademicoId = parseInt(periodoSelect.value);

    if (!coordinadorId || !periodoAcademicoId) {
        alert('❗ Por favor selecciona un coordinador y un periodo académico');
        return;
    }

    // ✅ Enviamos solo IDs como indica el DTO
    const solicitudData = {
        coordinadorId,
        periodoAcademicoId
    };

    try {
        const solicitudResponse = await fetch('/solicitudes', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(solicitudData)
        });

        if (!solicitudResponse.ok) {
            throw new Error('Error al crear la solicitud');
        }

        const solicitudCreada = await solicitudResponse.json();
        console.log("✅ Solicitud creada:", solicitudCreada);

        const items = [];
        const itemElements = document.querySelectorAll("#contenedor-items .item");

        for (const item of itemElements) {
            const diasSemana = Array.from(item.querySelectorAll("input[name='diasSemana']:checked")).map(cb => cb.value);

            const bloqueInicioId = parseInt(item.querySelector("select[name='bloqueInicioId']").value);
            const grupoId = parseInt(item.querySelector("select[name='grupoId']").value);
            const duracionBloques = parseInt(item.querySelector("input[name='duracionBloques']").value);
            const numeroGrupos = parseInt(item.querySelector("input[name='numeroGrupos']").value);
            const observaciones = item.querySelector("input[name='observaciones']").value.trim();

            // ✅ Enviamos solo los campos esperados por el DTO
            items.push({
                solicitudId: solicitudCreada.id,
                diasSemana,
                bloqueInicioId,
                duracionBloques,
                grupoId,
                numeroGrupos,
                observaciones
            });
        }

        if (items.length === 0) {
            alert("❗ Debes agregar al menos un bloque de solicitud");
            return;
        }

        // Cambiar el cuerpo del POST para enviar un solo objeto en vez de un array
        const item = items[0];  // Tomamos solo el primer objeto
        const itemsResponse = await fetch('/solicitud-items', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)  // Enviamos el primer objeto en lugar de un array
        });

        if (!itemsResponse.ok) {
            const errorData = await itemsResponse.json();
            throw new Error('❌ Error al crear los items: ' + (errorData.message || 'Error desconocido'));
        }

        alert("✅ Solicitud y bloque enviados correctamente");
        window.location.href = '/listar/solicitud';

    } catch (error) {
        console.error("❌ Error:", error);
        alert("❌ " + error.message);
    }
});