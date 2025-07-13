// src/main/resources/static/js/crud/BaseEntity.js
export default class BaseEntity {
    /**
     * @param {Object} config
     * @param {string} config.entityName    — nombre legible (“Ambiente”)
     * @param {string} config.baseUrl       — ruta base de la API ("/ambientes")
     * @param {string} config.formId        — id del formulario
     * @param {string} config.tableBodyId   — id del tbody donde pintar la lista
     * @param {Function} config.readForm    — fn(formElement) ⇒ objeto a enviar
     * @param {Function} config.renderRow   — fn(tbodyElement, item) ⇒ void
     */
    constructor({ entityName, baseUrl, formId, tableBodyId, readForm, renderRow }) {
        this.entityName  = entityName;
        this.baseUrl     = baseUrl;
        this.formId      = formId;
        this.tableBodyId = tableBodyId;
        this.readForm    = readForm;
        this.renderRow   = renderRow;

        document.addEventListener("DOMContentLoaded", () => {
            this._initCreate();
            this._initList();
        });
    }

    async _fetchJson(url, options = {}) {
        const resp = await fetch(url, options);
        if (!resp.ok) throw new Error(await resp.text());
        return resp.json();
    }

    _initCreate() {
        const form = document.getElementById(this.formId);
        if (!form) return;
        form.addEventListener("submit", async e => {
            e.preventDefault();
            try {
                const data = this.readForm(form);
                await this._fetchJson(this.baseUrl, {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(data)
                });
                alert(`${this.entityName} creado con éxito`);
                window.location.href = this._listRoute();
            } catch (err) {
                alert(`Error al crear ${this.entityName}: ${err.message}`);
            }
        });
    }

    _initList() {
        const tbody = document.getElementById(this.tableBodyId);
        if (!tbody) return;
        this._fetchJson(this.baseUrl)
            .then(items => {
                tbody.innerHTML = "";
                items.forEach(item => this.renderRow(tbody, item));
            })
            .catch(() => {
                tbody.innerHTML = `<tr><td colspan="100%" class="text-red-600">No se pudieron cargar los ${this.entityName.toLowerCase()}s.</td></tr>`;
            });
    }

    _listRoute() {
        // Convención: "/listar/entidad"
        return `/listar/${this.baseUrl.replace(/^\//, "")}`;
    }
}
