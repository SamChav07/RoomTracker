document.addEventListener("DOMContentLoaded", () => {
    cargarAmbientes();
});

/**
 * Carga la lista de ambientes desde la API y los muestra en la tabla
 */
async function cargarAmbientes() {
    try {
        const response = await fetch("/ambientes");

        if (!response.ok) {
            throw new Error(
                `Error al cargar los ambientes: ${response.status} ${response.statusText}`
            );
        }

        const ambientes = await response.json();
        renderizarTabla(ambientes);
    } catch (error) {
        console.error(error);
        mostrarError("No se pudieron cargar los ambientes. Intenta más tarde.");
    }
}

/**
 * Renderiza la tabla de ambientes en el DOM
 * @param {Array} ambientes - Lista de ambientes
 */
function renderizarTabla(ambientes) {
    const tbody = document.getElementById("tabla-ambientes-body");
    tbody.innerHTML = "";

    if (ambientes.length === 0) {
        mostrarError("No hay ambientes disponibles.");
        return;
    }

    ambientes.forEach((ambiente) => {
        const fila = document.createElement("tr");
        fila.className =
            "bg-white rounded-lg shadow-sm hover:shadow-md transition-all duration-200 group";

        fila.innerHTML = `
            <td class="py-3 px-2">${ambiente.codigo || "-"}</td>
            <td class="py-3 px-2">${ambiente.capacidad ?? "-"}</td>
            <td class="py-3 px-2">${ambiente.estado || "-"}</td>
            <td class="py-3 px-2">${ambiente.tipoAmbiente || "-"}</td>
            <td class="py-3 px-2">${ambiente.accesible ? "Sí" : "No"}</td>
            <td class="py-3 px-2">
                ${Array.isArray(ambiente.equiposAmbiente)
            ? ambiente.equiposAmbiente.map(e => e.descripcion || "-").join(", ")
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
    const tbody = document.getElementById("tabla-ambientes-body");
    tbody.innerHTML = `
        <tr>
            <td colspan="6" class="text-center text-red-600 py-6">${mensaje}</td>
        </tr>
    `;
}