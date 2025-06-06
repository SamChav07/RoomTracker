document.addEventListener('DOMContentLoaded', () => {
    cargarExcepciones();
});

/**
 * Carga la lista de excepciones desde la API y las muestra en la tabla
 */
async function cargarExcepciones() {
    try {
        const response = await fetch('/excepciones'); // Ajusta si tu endpoint tiene otro path

        if (!response.ok) {
            throw new Error(`Error al cargar las excepciones: ${response.status} ${response.statusText}`);
        }

        const excepciones = await response.json();
        renderizarTabla(excepciones);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar las excepciones. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de excepciones en el DOM
 * @param {Array} excepciones - Lista de excepciones
 */
function renderizarTabla(excepciones) {
    const tbody = document.getElementById('tabla-excepciones-body');
    tbody.innerHTML = "";

    if (!excepciones || excepciones.length === 0) {
        mostrarError("No hay excepciones registradas.");
        return;
    }

    excepciones.forEach(ex => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${ex.tipo || '-'}</td>
            <td class="py-3 px-2">${ex.fecha || '-'}</td>
            <td class="py-3 px-2">${ex.plantilla?.grupo?.codigo || '-'}</td>
            <td class="py-3 px-2">${ex.nuevoAmbiente?.codigo || '-'}</td>
            <td class="py-3 px-2">${ex.nuevoTimeSlot?.horaInicio || '-'} - ${ex.nuevoTimeSlot?.horaFin || '-'}</td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-excepciones-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="5" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}