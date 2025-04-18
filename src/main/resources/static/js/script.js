const sidebar = document.querySelector('.sidebar');
const mainContent = document.querySelector('.main-content');
const menuEspacio = document.querySelector('.menu-espacio');

sidebar.addEventListener('mouseenter', () => {
    mainContent.classList.add('ml-64');
});

sidebar.addEventListener('mouseleave', () => {
    mainContent.classList.remove('ml-64');
});

menuEspacio.addEventListener('mouseenter', () => {
    menuEspacio.classList.remove('items-center');
});

menuEspacio.addEventListener('mouseleave', () => {
    menuEspacio.classList.add('items-center');
});