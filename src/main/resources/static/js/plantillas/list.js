document.addEventListener("DOMContentLoaded", () => {
    cargarPlantillas(); // Ejecutar al cargar la página
});

async function cargarPlantillas() {
    const endpoint = "/plantillas";
    const tbody = document.getElementById("tabla-plantillas-body");
    const thead = document.getElementById("tabla-plantillas-head");

    try {
        const response = await fetch(endpoint);

        if (!response.ok) {
            throw new Error(`Error al obtener las plantillas: ${response.status} ${response.statusText}`);
        }

        const plantillas = await response.json();

        // Limpiar contenido anterior
        tbody.innerHTML = '';
        thead.innerHTML = '';

        if (plantillas.length === 0) {
            tbody.innerHTML = "<tr><td colspan='7' class='text-center py-4'>⚠️ No hay plantillas disponibles.</td></tr>";
            return;
        }

        // Crear encabezado de tabla
        thead.innerHTML = `
            <tr class="bg-gray-100">
                <th class="py-2 px-4">ID</th>
                <th class="py-2 px-4">Periodo</th>
                <th class="py-2 px-4">Día</th>
                <th class="py-2 px-4">Ambiente</th>
                <th class="py-2 px-4">Horario</th>
                <th class="py-2 px-4">Grupo</th>
                <th class="py-2 px-4">Profesor</th>
            </tr>
        `;

        // Crear filas con datos
        plantillas.forEach(plantilla => {
            const tr = document.createElement("tr");
            tr.classList.add("bg-white", "hover:bg-gray-50");

            tr.innerHTML = `
                <td class="py-2 px-4">${plantilla.id}</td>
                <td class="py-2 px-4">${plantilla.periodo?.descripcion || "-"}</td>
                <td class="py-2 px-4">${plantilla.diaSemana || "-"}</td>
                <td class="py-2 px-4">${plantilla.ambiente?.codigo || "-"}</td>
                <td class="py-2 px-4">${plantilla.timeSlot?.horaInicio || "-"} - ${plantilla.timeSlot?.horaFin || "-"}</td>
                <td class="py-2 px-4">${plantilla.grupo?.codigo || "-"}</td>
                <td class="py-2 px-4">${plantilla.grupo?.profesor?.nombre || "-"}</td>
            `;

            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("❌ Error al cargar las plantillas:", error);
        alert("❌ No se pudo cargar las plantillas. Verifica tu conexión.");
        tbody.innerHTML = "<tr><td colspan='7' class='text-center py-4'>❌ Error al cargar las plantillas.</td></tr>";
    }
}