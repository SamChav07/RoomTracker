document.addEventListener("DOMContentLoaded", () => {
    cargarAsignaturas();
});

async function cargarAsignaturas() {
    try {
        const response = await fetch("/asignaturas");

        if (!response.ok) {
            throw new Error(
                `Error al cargar las asignaturas: ${response.status} ${response.statusText}`
            );
        }

        const asignaturas = await response.json(); // Asegúrate de usar asignaturas aquí
        renderizarTabla(asignaturas); // Pasa asignaturas a la función de renderizado
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar las asignaturas. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de asignaturas
 * @param {Array} asignaturas
 */
function renderizarTabla(asignaturas) {
    const tbody = document.getElementById("tabla-asignaturas-body");
    tbody.innerHTML = "";

    if (asignaturas.length === 0) {
        mostrarError("No hay asignaturas disponibles.");
        return;
    }

    asignaturas.forEach((asignatura) => {
        const fila = document.createElement("tr");
        fila.className =
            "bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group";

        fila.innerHTML = `
            <td class="py-3 px-2">${asignatura.codigo || "-"}</td>
            <td class="py-3 px-2">${asignatura.nombre || "-"}</td>
            <td class="py-3 px-2">${asignatura.capacidadSugerida ?? "-"}</td>
            <td class="py-3 px-2">
                ${Array.isArray(asignatura.equiposNecesarios)
                        ? asignatura.equiposNecesarios.map(e => e.descripcion || "-").join(", ")
                        : "-"
                    }
            </td>
        `;

        tbody.appendChild(fila);
    });
}

/**
 * Muestra un mensaje de error en la tabla
 */
function mostrarError(mensaje) {
    const tbody = document.getElementById("tabla-asignaturas-body");
    tbody.innerHTML = `
        <tr>
            <td colspan="4" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}
