document.addEventListener("DOMContentLoaded", () => {
    cargarCarreras(); // Cargar las carreras cuando el DOM esté listo
});

// Función para cargar las carreras disponibles desde el servidor
async function cargarCarreras() {
    try {
        const response = await fetch("/carreras");
        if (!response.ok) {
            throw new Error('Error al cargar las carreras');
        }

        const carreras = await response.json();
        const selectCarrera = document.getElementById('carrera');
        selectCarrera.innerHTML = ''; // Limpiar las opciones previas

        // Crear una opción por cada carrera disponible
        carreras.forEach(carrera => {
            const option = document.createElement('option');
            option.value = carrera.id; // Usamos el ID de la carrera
            option.textContent = carrera.nombre; // Nombre visible en el dropdown
            selectCarrera.appendChild(option);
        });
    } catch (error) {
        console.error('Error al cargar carreras:', error);
    }
}

// Función para obtener el ID del usuario según el nombre
async function obtenerUsuarioIdPorNombre(nombre) {
    try {
        const response = await fetch(`/usuarios?nombre=${encodeURIComponent(nombre)}`);
        if (!response.ok) {
            throw new Error('No se encontró el usuario');
        }

        const usuarios = await response.json();
        const usuario = usuarios.find(u => u.nombre.toLowerCase() === nombre.toLowerCase());

        return usuario ? usuario.id : null; // Retorna el ID si se encuentra
    } catch (error) {
        console.error('Error al obtener usuario:', error);
        return null;
    }
}

// Evento de submit del formulario
document.getElementById('coordinadorForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar recarga de página

    const nombre = document.getElementById('nombre').value.trim();
    const carreraId = parseInt(document.getElementById('carrera').value);

    // Validación básica
    if (!nombre || !carreraId) {
        alert('Por favor, completa todos los campos');
        return;
    }

    // Obtener el usuarioId por el nombre
    const usuarioId = await obtenerUsuarioIdPorNombre(nombre);

    if (!usuarioId) {
        alert('No se encontró un usuario con ese nombre');
        return;
    }

    // Datos a enviar
    const data = {
        usuarioId,
        carreraId
    };

    try {
        const response = await fetch('/coordinadores', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('✅ Coordinador registrado exitosamente');
            window.location.href = '/listar/coordinador'; // Redirigir al listado de coordinadores
        } else {
            const errorData = await response.json();
            alert('Error al registrar el coordinador: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
        alert('Error en la solicitud');
    }
});