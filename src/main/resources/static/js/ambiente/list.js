// script.js

document.addEventListener('DOMContentLoaded', () => {
    cargarAmbientes();
});

/**
 * Carga la lista de ambientes desde la API y los muestra en la tabla
 */
async function cargarAmbientes() {
    try {
        const response = await fetch('/ambientes');
        
        if (!response.ok) {
            throw new Error(`Error al cargar ambientes: ${response.status} ${response.statusText}`);
        }

        const ambientes = await response.json();
        renderizarTabla(ambientes);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los ambientes. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de ambientes en el DOM
 * @param {Array} ambientes - Lista de ambientes
 */
function renderizarTabla(ambientes) {
    const tbody = document.getElementById('tabla-ambientes-body');
    tbody.innerHTML = "";

    ambientes.forEach(ambiente => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${ambiente.codigo || '-'}</td>
            <td class="py-3 px-2">${ambiente.capacidad ?? '-'}</td>
            <td class="py-3 px-2">${ambiente.estado || '-'}</td>
            <td class="py-3 px-2">${ambiente.tipoambiente || '-'}</td>
            <td class="py-3 px-2">${ambiente.accesible || '-'}</td>
            <td class="py-3 px-2">${ambiente.equipoIds || '-'}</td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-ambientes-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="4" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}