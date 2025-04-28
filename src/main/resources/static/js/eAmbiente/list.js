document.addEventListener('DOMContentLoaded', () => {
    cargarEquipos();
});

/**
 * Carga la lista de equipos desde la API y los muestra en la tabla
 */
async function cargarEquipos() {
    try {
        const response = await fetch('/equipos');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los equipos: ${response.status} ${response.statusText}`);
        }

        const equipos = await response.json(); // Asegúrate de usar equipos aquí
        renderizarTabla(equipos); // Pasa equipos a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los equipos. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de equipos en el DOM
 * @param {Array} equipos - Lista de equipos
 */
function renderizarTabla(equipos) {
    const tbody = document.getElementById('tabla-equipos-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (equipos.length === 0) {
        mostrarError("No hay equipos disponibles.");
        return;
    }

    equipos.forEach(equipo => {  // Asegúrate de usar 'equipo' en lugar de 'equipos'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${equipo.codigo || '-'}</td> <!-- Muestra el código del equipo -->
            <td class="py-3 px-2">${equipo.descripcion || '-'}</td> <!-- Muestra la descripción del equipo -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-equipos-body');  // Asegúrate de usar 'tabla-equipos-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="2" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}