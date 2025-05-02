document.addEventListener("DOMContentLoaded", () => {
    cargarEquipos();
});

// Función para cargar los equipos desde un endpoint y llenar los checkboxes
async function cargarEquipos() {
    try {
        const response = await fetch("/equipos");

        if (!response.ok) {
            throw new Error(`Error al cargar los equipos: ${response.status} ${response.statusText}`);
        }

        const equipos = await response.json();
        const contenedorEquipos = document.getElementById("equipos-container");

        // Limpiar primero el contenedor por si ya tenía datos
        contenedorEquipos.innerHTML = '';

        // Crear un checkbox por cada equipo
        equipos.forEach(equipo => {
            const div = document.createElement('div');
            div.classList.add('flex', 'items-center', 'mb-2');

            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.id = `equipo-${equipo.id}`; // ID único del checkbox
            checkbox.name = 'equiposAmbientes'; // Nombre para agrupar
            checkbox.value = equipo.id; // Valor enviado

            checkbox.classList.add('form-checkbox', 'h-5', 'w-5', 'text-blue-600', 'focus:ring-blue-500');

            const label = document.createElement('label');
            label.setAttribute('for', `equipo-${equipo.id}`);
            label.classList.add('ml-2', 'text-sm', 'text-gray-700');
            label.textContent = equipo.descripcion;

            div.appendChild(checkbox);
            div.appendChild(label);
            contenedorEquipos.appendChild(div);
        });
    } catch (error) {
        console.error(error);
        alert("❌ Error al cargar los equipos");
    }
}

document.getElementById('formularioAmbiente').addEventListener('submit', async function(event) {
    event.preventDefault(); // Evitar recarga de página

    const codigo = document.getElementById('codigo').value.trim();
    const capacidad = parseInt(document.getElementById('capacidad').value.trim()) || null;
    const estado = document.getElementById('estado').value.trim();
    const tipoAmbiente = document.getElementById('tipo_ambiente').value.trim();
    const accesible = document.getElementById('accesible').checked;

    // Obtener los IDs de los checkboxes seleccionados
    const checkboxes = document.querySelectorAll('input[name="equiposAmbientes"]:checked');
    const equiposAmbienteIds = Array.from(checkboxes).map(cb => parseInt(cb.value));

    // Validación básica
    if (!codigo || !estado || !tipoAmbiente || isNaN(capacidad)) {
        alert('❗ Por favor completa todos los campos obligatorios');
        return;
    }

    const data = {
        codigo,
        capacidad,
        estado,
        tipoAmbiente,
        accesible,
        equiposAmbienteIds // Correctamente enviado como arreglo
    };

    try {
        const response = await fetch('/ambientes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showNotification('success', '✅ Ambiente creado exitosamente');
            setTimeout(() => {
                window.location.href = '/listar/ambiente';
            }, 1500); // Redirige después de 1.5 segundos
        } else {
            const errorData = await response.json();
            showNotification('error', `❌ Error: ${errorData.message || 'Error desconocido'}`);
        }
    } catch (error) {
        console.error('❌ Error en la solicitud:', error);
        showNotification('error', `❌ Error: ${error.message}`);
    }
});