document.addEventListener('DOMContentLoaded', () => {
    cargarRoles(); // Cargar roles al cargar la página
});

async function cargarRoles() {
    try {
        const response = await fetch('/api/roles');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los roles: ${response.status} ${response.statusText}`);
        }

        const roles = await response.json(); // Suponiendo que la respuesta es un array de roles

        const selectRoles = document.getElementById('roles');
        selectRoles.innerHTML = ''; // Limpiar el <select>

        roles.forEach(rol => {
            const option = document.createElement('option');
            option.value = rol.id; // Asumimos que el rol tiene un id
            option.textContent = rol.nombre; // Asumimos que el rol tiene un nombre
            selectRoles.appendChild(option);
        });
    } catch (error) {
        console.error('Error al cargar los roles:', error);
        alert('❌ No se pudieron cargar los roles. Intenta más tarde.');
    }
}

document.getElementById('formularioUsuario').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        nombre: document.getElementById('nombre').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        rolIds: Array.from(document.getElementById('roles').selectedOptions).map(option => parseInt(option.value)) // Asegurarse de convertir a entero
    };

    // Validación básica
    if (!data.nombre || !data.email || !data.password || data.rolIds.length === 0) {
        alert('❗ Por favor completa todos los campos obligatorios');
        return;
    }

    try {
        const response = await fetch('/api/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Usuario creado exitosamente');
            window.location.href = '/listar/usuario'; // Redirige a la lista de usuarios
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el usuario: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});