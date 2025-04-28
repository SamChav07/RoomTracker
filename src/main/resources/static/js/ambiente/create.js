document.addEventListener("DOMContentLoaded", () => {
    cargarEquipos();
});

// Cargar los equipos y llenar el <select>
async function cargarEquipos() {
    try {
        const response = await fetch("/equipos");

        if (!response.ok) {
            throw new Error(`Error al cargar los equipos: ${response.status} ${response.statusText}`);
        }

        const equipos = await response.json();
        const selectEquipo = document.getElementById("equipo");

        selectEquipo.innerHTML = ''; // Limpiar el select primero

        equipos.forEach(equipo => {
            const option = document.createElement("option");
            option.value = equipo.id;
            option.textContent = equipo.descripcion;
            selectEquipo.appendChild(option);
        });

    } catch (error) {
        console.error(error);
        alert("❌ Error al cargar los equipos");
    }
}

// Guardar el ambiente cuando envías el formulario
document.getElementById('formularioAmbiente').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar recarga de página

    try {
        const codigo = document.getElementById('codigo').value.trim();
        const capacidad = parseInt(document.getElementById('capacidad').value.trim()) || null;
        const estado = document.getElementById('estado').value.trim();
        const tipoAmbiente = document.getElementById('tipo_ambiente').value.trim();
        const accesible = document.getElementById('accesible').checked;
        const equipoIdSeleccionado = parseInt(document.getElementById('equipo').value);

        // Validación básica
        if (!codigo || !estado || !tipoAmbiente || isNaN(capacidad)) {
            alert('❗ Por favor completa todos los campos obligatorios');
            return;
        }

        const data = {
            codigo: codigo,
            capacidad: capacidad,
            estado: estado,
            tipoAmbiente: tipoAmbiente,
            accesible: accesible,
            equipoIds: [equipoIdSeleccionado] // Lo enviamos como array
        };

        console.log('Datos que se enviarán:', data);

        const response = await fetch('/ambientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('✅ Ambiente creado exitosamente');
            window.location.href = '/listar/ambientes'; // Redirigir después de crear
        } else {
            const errorData = await response.json();
            alert('❌ Error al crear el ambiente: ' + (errorData.message || 'Error desconocido'));
        }

    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});