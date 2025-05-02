document.addEventListener('DOMContentLoaded', () => {
    cargarCarreras();
});

/**
 * Carga la lista de carreras desde la API y los muestra en la tabla
 */
async function cargarCarreras() {
    try {
        const response = await fetch('/carreras');

        if (!response.ok) {
            throw new Error(`Error al cargar las carreras: ${response.status} ${response.statusText}`);
        }

        const carreras = await response.json(); // Asegúrate de usar carreras aquí
        renderizarTabla(carreras); // Pasa carreras a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar las carreras. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de carreras en el DOM
 * @param {Array} carreras - Lista de carreras
 */
function renderizarTabla(carreras) {
    const tbody = document.getElementById('tabla-carreras-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (carreras.length === 0) {
        mostrarError("No hay carreras disponibles.");
        return;
    }

    carreras.forEach(carrera => {  // Asegúrate de usar 'carrera' en lugar de 'profesor'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${carrera.codigo || '-'}</td> <!-- Muestra el código de la carrera -->
            <td class="py-3 px-2">${carrera.nombre || '-'}</td> <!-- Muestra el nombre de la carrera -->
            <td class="py-3 px-2">${carrera.facultad?.codigo || '-'}</td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-carreras-body');  // Asegúrate de usar 'tabla-carreras-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="2" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}
