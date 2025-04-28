document.getElementById('formularioPeriodoAcademico').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    // Capturar los valores del formulario
    const data = {
        codigo: document.getElementById('codigo').value.trim(),
        descripcion: document.getElementById('descripcion').value.trim(),
        fechaInicio: document.getElementById('fechaInicio').value,
        fechaFin: document.getElementById('fechaFin').value,
        semanasTotales: parseInt(document.getElementById('semanasTotales').value),
        tiposemestre: document.getElementById('tiposemestre').value
    };

    try {
        const response = await fetch('/periodos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            // Si la respuesta es exitosa, muestra un mensaje de éxito y redirige
            alert('✅ Periodo académico creado exitosamente');
            window.location.href = '/listar/pAcademico'; // Redirige a la lista de periodos académicos
        } else {
            // Si la respuesta no es exitosa, muestra el error
            const errorData = await response.json();
            alert('❌ Error al crear el periodo académico: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});