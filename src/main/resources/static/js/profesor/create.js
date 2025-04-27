document.getElementById('formularioProfesor').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        nombre: document.getElementById('nombre').value,
        necesitaAccesibilidad: document.getElementById('necesitaAccesibilidad').value === 'true' // Convierte el valor en booleano
    };

    try {
        const response = await fetch('/api/profesores', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Profesor creado exitosamente');
            window.location.href = '/listar/profesor'; // Redirige a la lista de profesores
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el profesor: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});