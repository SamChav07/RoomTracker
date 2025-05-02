document.getElementById('formularioRoles').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        nombre: document.getElementById('nombre').value
    };

    // Validación básica
    if (!data.nombre) {
        alert('❗ Por favor completa todos los campos obligatorios');
        return;
    }

    try {
        const response = await fetch('/roles', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Rol académico creado exitosamente');
            window.location.href = '/all/roles'; // Redirige a la lista de roles
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el rol: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});