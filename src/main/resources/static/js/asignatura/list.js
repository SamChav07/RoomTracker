document.addEventListener('DOMContentLoaded', () => {
    cargarAsignaturas();
});

let equipoIdToDescripcion = new Map();

/**
 * Carga la lista de asignaturas y equipos desde la API
 */
async function cargarAsignaturas() {
    try {
        // Primero cargamos los equipos
        const equiposResponse = await fetch('/equipos');
        if (!equiposResponse.ok) {
            throw new Error(`Error al cargar equipos: ${equiposResponse.status} ${equiposResponse.statusText}`);
        }
        const equipos = await equiposResponse.json();

        // Guardamos las descripciones en un Map id => descripcion
        equipos.forEach(equipo => {
            equipoIdToDescripcion.set(equipo.id, equipo.descripcion);
        });

        // Luego cargamos las asignaturas
        const asignaturasResponse = await fetch('/asignaturas');
        if (!asignaturasResponse.ok) {
            throw new Error(`Error al cargar asignaturas: ${asignaturasResponse.status} ${asignaturasResponse.statusText}`);
        }
        const asignaturas = await asignaturasResponse.json();

        renderizarTabla(asignaturas);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar las asignaturas. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de asignaturas
 * @param {Array} asignaturas
 */
function renderizarTabla(asignaturas) {
    const tbody = document.getElementById('tabla-asignaturas-body');
    tbody.innerHTML = "";

    if (asignaturas.length === 0) {
        mostrarError("No hay asignaturas disponibles.");
        return;
    }

    asignaturas.forEach(asignatura => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        const equiposNecesarios = asignatura.equipoIds?.length
            ? asignatura.equipoIds.map(id => equipoIdToDescripcion.get(id) || `ID ${id}`).join(', ')
            : '-';

        fila.innerHTML = `
            <td class="py-3 px-2">${asignatura.codigo || '-'}</td>
            <td class="py-3 px-2">${asignatura.nombre || '-'}</td>
            <td class="py-3 px-2">${asignatura.capacidadSugerida ?? '-'}</td>
            <td class="py-3 px-2">${equiposNecesarios}</td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-asignaturas-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="4" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}
