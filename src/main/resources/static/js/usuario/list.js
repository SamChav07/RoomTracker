document.addEventListener('DOMContentLoaded', cargarusuarios);

async function cargarusuarios() {
    try {
        const response = await fetch('/usuarios');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los usuarios: ${response.status} ${response.statusText}`);
        }

        const usuarios = await response.json();
        renderizarTabla(usuarios);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los usuarios. Intenta más tarde.");
    }
}

function renderizarTabla(usuarios) {
    const tbody = document.getElementById('tabla-usuarios-body');
    tbody.innerHTML = ""; // Limpiar cualquier contenido previo

    if (usuarios.length === 0) {
        mostrarError("No hay usuarios disponibles.");
        return;
    }

    usuarios.forEach(usuario => {
        const fila = document.createElement('tr');
        fila.className = 'bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group';

        // Renderiza los datos de los usuarios
        fila.innerHTML = `
            <td class="py-3 px-4 text-center">${usuario.nombre || '-'}</td>
            <td class="py-3 px-4 text-center">${usuario.email || '-'}</td>
            <td class="py-3 px-4 text-center">${usuario.roles ? usuario.roles.map(role => role.nombre).join(', ') : '-'}</td>
        `;

        tbody.appendChild(fila);
    });
}

function mostrarError(mensaje) {
    const tbody = document.getElementById('tabla-usuarios-body');
    tbody.innerHTML = `
        <tr>
            <td colspan="3" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}