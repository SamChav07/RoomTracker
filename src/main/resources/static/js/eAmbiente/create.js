document.getElementById('formularioEquipoAmbiente').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        codigo: document.getElementById('codigo').value,
        descripcion: document.getElementById('descripcion').value
    };

    try {
        const response = await fetch('/api/equipos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Equipo creado exitosamente');
            window.location.href = '/listar/eAmbiente'; // Redirige a la lista de equipos
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el equipo: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});