document.addEventListener('DOMContentLoaded', () => {
    cargarProfesores();
});

/**
 * Carga la lista de profesores académicos desde la API y los muestra en la tabla
 */
async function cargarProfesores() {
    try {
        const response = await fetch('/api/profesores');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los profesores: ${response.status} ${response.statusText}`);
        }

        const profesores = await response.json(); // Asegúrate de usar profesores aquí
        renderizarTabla(profesores); // Pasa profesores a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los profesores. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de profesores académicos en el DOM
 * @param {Array} profesores - Lista de profesores académicos
 */
function renderizarTabla(profesores) {
    const tbody = document.getElementById('tabla-profesores-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (profesores.length === 0) {
        mostrarError("No hay profesores académicos disponibles.");
        return;
    }

    profesores.forEach(profesor => {  // Asegúrate de usar 'profesor' en lugar de 'profesores'
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2">${profesor.nombre || '-'}</td> <!-- Muestra el nombre del profesor -->
            <td class="py-3 px-2">${profesor.necesitaAccesibilidad ? 'Sí' : 'No'}</td> <!-- Accesibilidad -->
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla si algo falla
 * @param {String} mensaje - Texto del error
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-profesores-body');  // Asegúrate de usar 'tabla-profesores-body'
    tbody.innerHTML = `
        <tr>
            <td colspan="3" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}