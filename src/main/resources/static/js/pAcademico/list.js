document.addEventListener('DOMContentLoaded', () => {
    cargarPeriodos();
});

/**
 * Carga la lista de periodos académicos desde la API y los muestra en la tabla
 */
async function cargarPeriodos() {
    try {
        const response = await fetch('/periodos');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los periodos: ${response.status} ${response.statusText}`);
        }

        const periodos = await response.json(); // Asegúrate de usar periodos aquí
        renderizarTabla(periodos); // Pasa periodos a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los periodos. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de periodos académicos en el DOM
 * @param {Array} periodos - Lista de periodos académicos
 */
function renderizarTabla(periodos) {
    const tbody = document.getElementById('tabla-pAcademicos-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (periodos.length === 0) {
        mostrarError("No hay periodos académicos disponibles.");
        return;
    }

    periodos.forEach(periodo => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${periodo.codigo || '-'}</td>
            <td class="py-3 px-2">${periodo.fechaInicio || '-'}</td>
            <td class="py-3 px-2">${periodo.fechaFin || '-'}</td>
            <td class="py-3 px-2">${periodo.semanasTotales || '-'}</td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-pAcademicos-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="4" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}