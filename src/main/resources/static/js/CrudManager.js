// static/js/CrudManager.js
import FormBuilder from './crud/FormBuilder.js';

class CrudManager {
    constructor(rootId) {
        this.root = document.getElementById(rootId);           // <div data-entity="AmbienteDto">
        this.dto  = this.root.dataset.entity;                  // "AmbienteDto"
        this.init();
    }
    async init() {
        const meta = await (await fetch(`/metadata/${this.dto}`)).json();
        this.meta = meta;
        this.renderLayout();           // crea tabs, formulario y tabla vacíos
        this.formBuilder = new FormBuilder('crudForm', meta.fields);
        this.formBuilder.render();
        this.bindEvents();
        this.loadList();
    }
    bindEvents() {
        document.getElementById('crudForm')
            .addEventListener('submit', e => this.create(e));
    }
    async create(e) {
        e.preventDefault();
        const data = this.formBuilder.readValues();
        await fetch(this.meta.baseUrl, {
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body:JSON.stringify(data)
        });
        this.loadList();
    }
    async loadList() {
        const items = await (await fetch(this.meta.baseUrl)).json();
        this.renderTable(items);
    }
    /* renderLayout() & renderTable()…
       usan meta.fields para armar <thead> y filas automáticamente */
}

document.addEventListener('DOMContentLoaded', () => {
    new CrudManager('crud-root');   // sólo UNA instancia por página
});
