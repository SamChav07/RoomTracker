document.addEventListener('DOMContentLoaded', () => {
    cargarEquipos();
});

/**
 * Carga los equipos desde la API y los muestra en el formulario
 */
async function cargarEquipos() {
    try {
        const response = await fetch('/api/equipos');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los equipos: ${response.status} ${response.statusText}`);
        }

        const equipos = await response.json();
        const selectEquipo = document.getElementById('equipo');

        // Añadir las opciones de equipos al select
        equipos.forEach(equipo => {
            const option = document.createElement('option');
            option.value = equipo.id; // Suponiendo que el campo 'id' existe en los datos del equipo
            option.textContent = equipo.codigo || 'Equipo desconocido'; // Asumiendo que 'nombre' es uno de los campos del equipo
            option.textContent = equipo.descripcion || ' - '; // Asumiendo que 'nombre' es uno de los campos del equipo
            selectEquipo.appendChild(option);
        });
    } catch (error) {
        console.error(error);
        alert('❌ Error al cargar los equipos');
    }
}

/**
 * Maneja el envío del formulario para crear un ambiente
 */
document.getElementById('formularioAmbiente').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        codigo: document.getElementById('codigo').value,
        capacidad: parseInt(document.getElementById('capacidad').value),
        estado: document.getElementById('estado').value,
        tipoAmbiente: document.getElementById('tipo_ambiente').value,
        accesible: document.getElementById('accesible').checked,
        equipoIds: [parseInt(document.getElementById('equipo').value)] // Obtener el id del equipo seleccionado
    };

    try {
        const response = await fetch('/api/ambientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Ambiente creado exitosamente');
            window.location.href = '/listar/ambiente'; // Redirige a la lista de ambientes
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el ambiente: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});