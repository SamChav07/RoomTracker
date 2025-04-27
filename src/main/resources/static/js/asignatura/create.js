document.addEventListener("DOMContentLoaded", () => {
    cargarEquipos();
});

// Cargar los equipos y llenar el <select>
async function cargarEquipos() {
    try {
        const response = await fetch("/api/equipos");

        if (!response.ok) {
            throw new Error(`Error al cargar los equipos: ${response.status} ${response.statusText}`);
        }

        const equipos = await response.json();
        const selectEquipo = document.getElementById("equiposNecesarios");

        // Limpiar primero el select por si ya tenía datos
        selectEquipo.innerHTML = '';

        // Añadir opción por cada equipo
        equipos.forEach(equipo => {
            const option = document.createElement("option");
            option.value = equipo.id;  // Esto será enviado
            option.textContent = equipo.descripcion;
            selectEquipo.appendChild(option);
        });

    } catch (error) {
        console.error(error);
        alert("❌ Error al cargar los equipos");
    }
}

// Guardar la asignatura cuando envías el formulario
document.getElementById('formularioAsignatura').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar que se recargue la página

    try {
        const codigo = document.getElementById('codigo').value.trim();
        const nombre = document.getElementById('nombre').value.trim();
        const capacidadSugerida = parseInt(document.getElementById('capacidadSugerida').value.trim()) || null;

        const selectEquipos = document.getElementById('equiposNecesarios');
        const equipoIds = Array.from(selectEquipos.selectedOptions).map(option => parseInt(option.value));

        // Validación básica
        if (!codigo || !nombre) {
            alert('❗ Por favor completa todos los campos obligatorios');
            return;
        }

        const data = {
            codigo: codigo,
            nombre: nombre,
            capacidadSugerida: capacidadSugerida,
            equipoIds: equipoIds.length > 0 ? equipoIds : []  // Siempre mandar array
        };

        console.log('Datos que se enviarán:', data);  // <-- útil para debug

        const response = await fetch('/api/asignaturas', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('✅ Asignatura creada exitosamente');
            window.location.href = '/listar/asignatura'; // Redirigir a la lista
        } else {
            const errorData = await response.json();
            alert('❌ Error al crear la asignatura: ' + (errorData.message || 'Error desconocido'));
        }

    } catch (error) {
        console.error('Error:', error);
        alert('❌ Error en la solicitud: ' + error.message);
    }
});