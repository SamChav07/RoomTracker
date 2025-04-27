document.getElementById('formularioBloqueHorario').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        dia: document.getElementById('dia').value,
        horaInicio: document.getElementById('horaInicio').value,
        horaFin: document.getElementById('horaFin').value,
        duracionMin: document.getElementById('duracionMin').value
    };

    try {
        const response = await fetch('/api/bloques', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Bloque horario creado exitosamente');
            window.location.href = '/listar/bHorario'; // Redirige a la lista de bloques horarios
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el bloque horario: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});
