document.addEventListener('DOMContentLoaded', () => {
    cargarBloquesHorario();
});

/**
 * Carga la lista de bloques horarios desde la API y los muestra en la tabla
 */
async function cargarBloquesHorario() {
    try {
        const response = await fetch('/bloques');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los bloques horarios: ${response.status} ${response.statusText}`);
        }

        const bloquesHorario = await response.json(); // Asegúrate de usar bloquesHorario aquí
        renderizarTabla(bloquesHorario); // Pasa bloquesHorario a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los bloques horarios. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de bloques horarios en el DOM
 * @param {Array} bloquesHorario - Lista de bloques horarios
 */
function renderizarTabla(bloquesHorario) {
    const tbody = document.getElementById('tabla-bloquesHorario-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (bloquesHorario.length === 0) {
        mostrarError("No hay bloques horarios disponibles.");
        return;
    }

    bloquesHorario.forEach(bloque => {  // Asegúrate de usar 'bloque' en lugar de 'bloquesHorario'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${bloque.dia || '-'}</td> <!-- Muestra el día -->
            <td class="py-3 px-2">${bloque.horaInicio || '-'}</td> <!-- Muestra la hora de inicio -->
            <td class="py-3 px-2">${bloque.horaFin || '-'}</td> <!-- Muestra la hora de fin -->
            <td class="py-3 px-2">${bloque.duracionMin || '-'}</td> <!-- Muestra la duración en minutos -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-bloquesHorario-body');  // Asegúrate de usar 'tabla-bloquesHorario-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="4" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}