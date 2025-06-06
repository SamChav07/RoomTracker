document.addEventListener('DOMContentLoaded', () => {
    cargarCoordinadores();
});

/**
 * Carga la lista de coordinadores desde la API y los muestra en la tabla
 */
async function cargarCoordinadores() {
    try {
        const response = await fetch('/coordinadores');

        if (!response.ok) {
            throw new Error(`Error al cargar los coordinadores: ${response.status} ${response.statusText}`);
        }

        const coordinadores = await response.json(); // Asegúrate de usar coordinadores aquí
        renderizarTabla(coordinadores); // Pasa coordinadores a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los coordinadores. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de coordinadores en el DOM
 * @param {Array} coordinadores - Lista de coordinadores
 */
function renderizarTabla(coordinadores) {
    const tbody = document.getElementById('tabla-coordinadores-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (coordinadores.length === 0) {
        mostrarError("No hay coordinadores disponibles.");
        return;
    }

    coordinadores.forEach(coordinador => {  // Asegúrate de usar 'coordinador' en lugar de 'coordinadores'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        // Accedemos a las propiedades de los objetos anidados correctamente
        fila.innerHTML = `
            <td class="py-3 px-2">${coordinador.usuario?.nombre || '-'}</td> <!-- Muestra el nombre del coordinador -->
            <td class="py-3 px-2">${coordinador.carreraCoordinada?.nombre || '-'}</td> <!-- Carrera -->
            <td class="py-3 px-2">${coordinador.usuario?.id || '-'}</td> <!-- ID de usuario -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-coordinadores-body');  // Asegúrate de usar 'tabla-coordinadores-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="3" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}