document.addEventListener('DOMContentLoaded', async () => {
    const facultadSelect = document.getElementById('facultad');

    try {
        const response = await fetch('/facultades');
        if (!response.ok) {
            throw new Error('No se pudieron obtener las facultades');
        }

        const facultades = await response.json();
        facultades.forEach(facultad => {
            const option = document.createElement('option');
            option.value = facultad.id;
            option.textContent = `[${facultad.codigo}]: ${facultad.nombre}`;
            facultadSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Error al cargar facultades:', error);
        alert('❌ No se pudieron cargar las facultades');
    }
});

document.getElementById('formularioCarrera').addEventListener('submit', async function(event) {
    event.preventDefault();

    const data = {
        codigo: document.getElementById('codigo').value.trim(),
        nombre: document.getElementById('nombre').value.trim(),
        facultadId: parseInt(document.getElementById('facultad').value)
    };

    if (!data.codigo || !data.nombre || isNaN(data.facultadId)) {
        alert('❗ Por favor completa todos los campos obligatorios');
        return;
    }

    try {
        const response = await fetch('/carreras', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('✅ Carrera creada exitosamente');
            window.location.href = '/listar/carrera';
        } else {
            const errorData = await response.json();
            alert('❌ Error al crear la carrera: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});