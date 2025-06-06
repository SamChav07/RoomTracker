document.addEventListener("DOMContentLoaded", () => {
    cargarGrupos(); // Cargar datos al cargar la página
});

async function cargarGrupos() {
    try {
        const response = await fetch("/grupos");

        if (!response.ok) {
            throw new Error(`Error al cargar los grupos: ${response.status} ${response.statusText}`);
        }

        const grupos = await response.json();
        const tbody = document.getElementById("tabla-grupos-body");

        tbody.innerHTML = ''; // Limpiar contenido anterior

        grupos.forEach(grupo => {
            const tr = document.createElement("tr");
            tr.classList.add("bg-white", "shadow", "rounded");

            tr.innerHTML = `
                <td class="py-2 px-4">${grupo.codigo}</td>
                <td class="py-2 px-4">${grupo.numeroEstudiantes}</td>
                <td class="py-2 px-4">${grupo.numeroGrupo}</td>
                <td class="py-2 px-4">${grupo.profesor?.nombre || "Desconocido"}</td>
            `;

            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error("❌ Error al cargar los grupos:", error);
        alert("❌ No se pudo cargar la lista de grupos");
    }
}