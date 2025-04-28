document.addEventListener('DOMContentLoaded', () => {
    cargarRoles(); // Cargar roles al cargar la página
});

async function cargarRoles() {
    try {
        const response = await fetch('/roles');
        
        if (!response.ok) {
            throw new Error(`Error al cargar los roles: ${response.status} ${response.statusText}`);
        }

        const roles = await response.json();

        const selectRoles = document.getElementById('roles');
        selectRoles.innerHTML = '';

        roles.forEach(rol => {
            const option = document.createElement('option');
            option.value = rol.id;
            option.textContent = rol.nombre;
            selectRoles.appendChild(option);
        });
    } catch (error) {
        console.error('Error al cargar los roles:', error);
        alert('❌ No se pudieron cargar los roles. Intenta más tarde.');
    }
}

document.getElementById('formularioUsuario').addEventListener('submit', async function(event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const rolIds = Array.from(document.getElementById('roles').selectedOptions).map(option => parseInt(option.value));

    if (!nombre || !email || !password || rolIds.length === 0) {
        alert('❗ Por favor completa todos los campos obligatorios');
        return;
    }

    const usuarioData = {
        nombre: nombre,
        email: email,
        password: password,
        rolIds: rolIds
    };

    try {
        // 1. Crear el usuario
        const crearUsuarioResponse = await fetch('/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuarioData)
        });

        if (!crearUsuarioResponse.ok) {
            const errorData = await crearUsuarioResponse.json();
            alert('❌ Error al crear el usuario: ' + (errorData.message || 'Error desconocido'));
            return;
        }

        // 2. Buscar el usuario recién creado
        const buscarUsuarioResponse = await fetch(`/usuarios/buscar?email=${encodeURIComponent(email)}`);
        
        if (!buscarUsuarioResponse.ok) {
            throw new Error('Error al buscar el usuario creado');
        }

        const usuario = await buscarUsuarioResponse.json();

        if (!usuario || !usuario.id) {
            throw new Error('Usuario creado no encontrado o sin ID');
        }

        // 3. Registrar el usuario como operador de logística
        const operadorData = {
            usuarioId: usuario.id // Asumiendo que en el backend esperas un campo 'usuarioId'
        };

        const crearOperadorResponse = await fetch('/api/operadores-logistica', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(operadorData)
        });

        if (crearOperadorResponse.ok) {
            alert('✅ Usuario y operador creados exitosamente');
            window.location.href = '/listar/usuario';
        } else {
            const errorOperador = await crearOperadorResponse.json();
            alert('⚠️ Usuario creado pero error al asignar como operador: ' + (errorOperador.message || 'Error desconocido'));
        }

    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});