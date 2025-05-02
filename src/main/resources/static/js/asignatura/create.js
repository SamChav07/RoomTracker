document.addEventListener("DOMContentLoaded", () => {
    cargarEquipos(); // Cargar los equipos cuando la página se haya cargado
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
            checkbox.name = 'equiposNecesarios'; // Nombre para agrupar
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

document.getElementById('formularioAsignatura').addEventListener('submit', async function(event) {
    event.preventDefault();

    const codigo = document.getElementById('codigo').value.trim();
    const nombre = document.getElementById('nombre').value.trim();
    const capacidadSugerida = parseInt(document.getElementById('capacidadSugerida').value.trim()) || null;

    // Obtener los IDs de los checkboxes seleccionados
    const checkboxes = document.querySelectorAll('input[name="equiposNecesarios"]:checked');
    const equiposNecesariosIds = Array.from(checkboxes).map(cb => parseInt(cb.value));

    const data = {
        codigo,
        nombre,
        capacidadSugerida,
        equiposNecesariosIds // Este campo ahora es un array, como espera el backend
    };

    try {
        const response = await fetch("/asignaturas", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('✅ Asignatura creada exitosamente');
            window.location.href = '/listar/asignatura';
        } else {
            const errorData = await response.json();
            alert('❌ Error al crear la asignatura: ' + (errorData.message || 'Error desconocido'));
        }
    } catch (error) {
        console.error("❌ Error en el envío:", error);
        alert("❌ Error al enviar los datos");
    }
});