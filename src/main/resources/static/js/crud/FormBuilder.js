// static/js/crud/FormBuilder.js
export default class FormBuilder {
    /**
     * @param {string} formId  – id del <form>
     * @param {Array<Object>} fields – metadatos de cada campo
     */
    constructor(formId, fields) {
        this.form   = document.getElementById(formId);
        if (!this.form) {
            throw new Error(`No se encontró el formulario con id “${formId}”.`);
        }
        // omite “id” y los readOnly
        this.fields = fields.filter(f => f.name !== 'id' && !f.readOnly);
    }

    /* -------------------------------------------------------------------- */
    /*  Renderiza los controles                                             */
    /* -------------------------------------------------------------------- */
    async render() {
        this.form.innerHTML = '';                                  // limpio
        for (const field of this.fields) {
            const wrapper = document.createElement('div');
            wrapper.className = 'mb-4';

            // checkbox / boolean: label a la derecha; resto, arriba
            if (field.type !== 'boolean' && field.type !== 'checkbox') {
                wrapper.appendChild(this._makeLabel(field));
            }

            const inputEl = await this._makeInput(field);
            wrapper.appendChild(inputEl);

            if (field.type === 'boolean' || field.type === 'checkbox') {
                wrapper.appendChild(this._makeLabel(field, 'ml-2 text-sm text-gray-700'));
                wrapper.classList.add('flex', 'items-center');
            }

            this.form.appendChild(wrapper);
        }
    }

    /* -------------------------------------------------------------------- */
    /*  Devuelve un objeto con los valores del formulario                   */
    /* -------------------------------------------------------------------- */
    readValues() {
        const out = {};
        for (const f of this.fields) {
            const el = this.form.elements[f.name];
            if (!el) continue;

            switch (f.type) {
                case 'boolean':
                case 'checkbox':
                    out[f.name] = el.checked;
                    break;
                case 'int':
                case 'long':
                case 'double':
                    out[f.name] = el.value === '' ? null : Number(el.value);
                    break;
                case 'fk':
                    out[f.name] = f.multiple
                        ? Array.from(el.selectedOptions).map(o => Number(o.value))
                        : (el.value === '' ? null : Number(el.value));
                    break;
                default:        // string, enum, date…
                    out[f.name] = el.value;
            }
        }
        return out;
    }

    /* ========= HELPERS ================================================== */

    _makeLabel(field, extra = '') {
        const lbl = document.createElement('label');
        lbl.htmlFor     = field.name;
        lbl.textContent = field.label || field.name;
        lbl.className   = `block text-sm font-medium text-gray-700 ${extra}`;
        return lbl;
    }

    async _makeInput(field) {
        let el;

        switch (field.type) {
            case 'enum':
                el = this._selectFromArray(field.enumValues);
                break;

            case 'fk':
                el = document.createElement('select');
                if (field.multiple) el.multiple = true;
                await this._populateFromEndpoint(el, field);
                break;

            case 'boolean':
            case 'checkbox':
                el = document.createElement('input');
                el.type = 'checkbox';
                break;

            case 'int':
            case 'long':
                el = document.createElement('input');
                el.type = 'number'; el.step = '1';
                break;

            case 'double':
                el = document.createElement('input');
                el.type = 'number'; el.step = 'any';
                break;

            case 'date':
                el = document.createElement('input');
                el.type = 'date';
                break;

            default: // string
                el = document.createElement('input');
                el.type = 'text';
        }

        el.name = el.id = field.name;
        if (field.required) el.required = true;

        // Tailwind – apariencia uniforme para inputs y selects
        if (el.tagName === 'INPUT' || el.tagName === 'SELECT') {
            el.className =
                'mt-1 block w-full border border-gray-300 rounded-md p-2 ' +
                'focus:outline-none focus:ring focus:ring-blue-500';
        }
        return el;
    }

    _selectFromArray(arr = []) {
        const sel = document.createElement('select');
        arr.forEach(v => {
            const opt = document.createElement('option');
            opt.value = v; opt.textContent = v;
            sel.appendChild(opt);
        });
        return sel;
    }

    async _populateFromEndpoint(selectEl, field) {
        selectEl.innerHTML = '<option value="">Cargando…</option>';
        try {
            const resp = await fetch(field.fkUrl);
            const items = await resp.json();
            selectEl.innerHTML = '';
            items.forEach(it => {
                const opt = document.createElement('option');
                const labelKey = field.fkLabel ?? 'descripcion';
                const valueKey = field.fkValue ?? 'id';
                opt.value = it[valueKey];
                opt.textContent = it[labelKey] ?? it[valueKey];
                selectEl.appendChild(opt);
            });
        } catch {
            selectEl.innerHTML = '<option value="">(error)</option>';
        }
    }
}

