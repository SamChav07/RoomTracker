document.addEventListener('DOMContentLoaded', () => {
    cargarFacultades();
});

/**
 * Carga la lista de facultades desde la API y los muestra en la tabla
 */
async function cargarFacultades() {
    try {
        const response = await fetch('/facultades');

        if (!response.ok) {
            throw new Error(`Error al cargar las facultades: ${response.status} ${response.statusText}`);
        }

        const facultades = await response.json(); // Asegúrate de usar facultades aquí
        renderizarTabla(facultades); // Pasa facultades a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los facultades. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de facultades en el DOM
 * @param {Array} facultades - Lista de facultades
 */
function renderizarTabla(facultades) {
    const tbody = document.getElementById('tabla-facultades-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (facultades.length === 0) {
        mostrarError("No hay facultades disponibles.");
        return;
    }

    facultades.forEach(facultad => {  // Asegúrate de usar 'equipo' en lugar de 'facultades'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${facultad.codigo || '-'}</td> <!-- Muestra el código del equipo -->
            <td class="py-3 px-2">${facultad.nombre || '-'}</td> <!-- Muestra la descripción del equipo -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-facultades-body');  // Asegúrate de usar 'tabla-facultades-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="2" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}