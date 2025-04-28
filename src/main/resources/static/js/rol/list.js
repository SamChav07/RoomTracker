document.addEventListener('DOMContentLoaded', cargarRoles);

async function cargarRoles() {
    try {
        const response = await fetch('/api/roles');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los roles: ${response.status} ${response.statusText}`);
        }

        const roles = await response.json();
        renderizarTabla(roles);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los roles. Intenta más tarde.");
    }
}

function renderizarTabla(roles) {
    const tbody = document.getElementById('tabla-roles-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (roles.length === 0) {
        mostrarError("No hay roles académicos disponibles.");
        return;
    }

    roles.forEach(rol => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        fila.innerHTML = `
            <td class="py-3 px-2 text-center">${rol.nombre || '-'}</td> <!-- Muestra el nombre del rol -->
        `;

        tbody.appendChild(fila);
    });
}

function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-roles-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="3" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}