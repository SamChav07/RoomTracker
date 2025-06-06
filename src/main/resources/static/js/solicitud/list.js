document.addEventListener('DOMContentLoaded', () => {
    cargarSolicitudes();
});

/**
 * Carga la lista de solicitudes desde la API y las muestra en la tabla
 */
async function cargarSolicitudes() {
    try {
        const response = await fetch('/solicitudes');

        if (!response.ok) {
            throw new Error(`Error al cargar las solicitudes: ${response.status} ${response.statusText}`);
        }

        const solicitudes = await response.json();
        renderizarTabla(solicitudes);  // Pasa solicitudes a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar las solicitudes. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de solicitudes en el DOM
 * @param {Array} solicitudes - Lista de solicitudes
 */
function renderizarTabla(solicitudes) {
    const tbody = document.getElementById('tabla-solicitudes-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (!solicitudes || solicitudes.length === 0) {
        mostrarError("No hay solicitudes disponibles.");
        return;
    }

    solicitudes.forEach(solicitud => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        // Acceder correctamente a las propiedades anidadas con valores predeterminados en caso de ser undefined o null
        fila.innerHTML = `
            <td class="py-3 px-2">${solicitud.coordinador?.carreraCoordinada?.facultad?.codigo || '-'}</td> <!-- Nombre del coordinador -->
            <td class="py-3 px-2">${solicitud.coordinador?.usuario?.nombre || '-'}</td> <!-- Nombre del coordinador -->
            <td class="py-3 px-2">${solicitud.periodo?.descripcion || '-'}</td> <!-- Descripción del periodo -->
            <td class="py-3 px-2">${solicitud.estado || '-'}</td> <!-- Estado de la solicitud -->
            <td class="py-3 px-2">${new Date(solicitud.fechaSolicitud).toLocaleString() || '-'}</td> <!-- Fecha de solicitud -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-solicitudes-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="6" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}