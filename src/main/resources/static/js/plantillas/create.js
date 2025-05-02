document.addEventListener("DOMContentLoaded", () => {
    const cargarOpciones = async (url, selectId, labelExtractor) => {
        try {
            const response = await fetch(url);
            if (!response.ok) throw new Error(`Error ${response.status}: ${response.statusText}`);
            const data = await response.json();
            const select = document.getElementById(selectId);
            data.forEach(item => {
                const option = document.createElement("option");
                option.value = item.id;
                option.textContent = labelExtractor(item);
                select.appendChild(option);
            });
        } catch (error) {
            console.error(`Error cargando ${selectId}:`, error);
            alert(`❌ No se pudo cargar ${selectId}. Verifica tu conexión.`);
        }
    };

    // Cargar opciones en los selects
    cargarOpciones("/periodos", "periodo", p => p.descripcion);
    cargarOpciones("/ambientes", "ambiente", a => a.codigo);
    cargarOpciones("/bloques", "horario", h => `${h.horaInicio} - ${h.horaFin}`);
    cargarOpciones("/grupos", "grupo", g => `Grupo ${g.numeroGrupo} - ${g.profesor.nombre}`);

    // Manejo del formulario
    const form = document.getElementById("formularioPlantillaReserva");

    form.addEventListener("submit", async (e) => {
        e.preventDefault();

        // Obtener valores del formulario
        const periodoId = document.getElementById("periodo").value;
        const diaSemana = document.getElementById("diaSemana").value;
        const ambienteId = document.getElementById("ambiente").value;
        const timeSlotId = document.getElementById("horario").value;
        const grupoId = document.getElementById("grupo").value;

        // Validación
        if (!periodoId || !diaSemana || !ambienteId || !timeSlotId || !grupoId) {
            alert("⚠️ Por favor, completa todos los campos antes de enviar.");
            return;
        }

        // Construcción del DTO como espera el mapper
        const plantillaReservaDTO = {
            periodoId: Number(periodoId),
            diaSemana: diaSemana,
            ambienteId: Number(ambienteId),
            timeSlotId: Number(timeSlotId),
            grupoId: Number(grupoId)
        };

        const submitBtn = form.querySelector("button[type='submit']");
        submitBtn.disabled = true;

        try {
            const response = await fetch("/plantillas", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(plantillaReservaDTO)
            });

            if (response.ok) {
                alert("✅ Plantilla de reserva creada correctamente.");
                form.reset();
            } else {
                const errorText = await response.text();
                console.error("❌ Error del servidor:", errorText);
                alert("❌ Error al crear la plantilla. Revisa los datos.");
            }
        } catch (error) {
            console.error("❌ Error de red o inesperado:", error);
            alert("❌ No se pudo conectar con el servidor.");
        } finally {
            submitBtn.disabled = false;
        }
    });
});