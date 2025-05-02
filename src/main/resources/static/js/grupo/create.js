document.addEventListener("DOMContentLoaded", () => {
    cargarProfesores(); // Llenar select con profesores al cargar
});

async function cargarProfesores() {
    try {
        const response = await fetch("/profesores");

        if (!response.ok) {
            throw new Error(`Error al cargar los profesores: ${response.status} ${response.statusText}`);
        }

        const profesores = await response.json();
        const selectProfesor = document.getElementById("profesorId");

        // Limpiar opciones anteriores
        selectProfesor.innerHTML = '<option value="">Seleccione un profesor</option>';

        // Agregar cada profesor al select
        profesores.forEach(profesor => {
            const option = document.createElement("option");
            option.value = profesor.id;
            option.textContent = profesor.nombre; // Asegúrate de que el JSON tenga "id" y "nombre"
            selectProfesor.appendChild(option);
        });
    } catch (error) {
        console.error(error);
        alert("❌ Error al cargar los profesores");
    }
}

document.getElementById("grupoForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const codigo = document.getElementById("codigo").value.trim();
    const numeroEstudiantes = parseInt(document.getElementById("numeroEstudiantes").value);
    const numeroGrupo = parseInt(document.getElementById("numeroGrupo").value);
    const profesorId = parseInt(document.getElementById("profesorId").value);

    if (!codigo || !numeroEstudiantes || !numeroGrupo || !profesorId) {
        alert("⚠️ Todos los campos son obligatorios");
        return;
    }

    const data = {
        codigo,
        numeroEstudiantes,
        numeroGrupo,
        profesorId
    };

    try {
        const response = await fetch("/grupos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert("✅ Grupo registrado exitosamente");
            window.location.href = "/listar/grupo"; // Ajusta esta ruta si es diferente
        } else {
            const errorData = await response.json();
            alert("❌ Error al registrar el grupo: " + (errorData.message || "Error desconocido"));
        }
    } catch (error) {
        console.error("❌ Error en el envío:", error);
        alert("❌ Error al enviar los datos del grupo");
    }
});