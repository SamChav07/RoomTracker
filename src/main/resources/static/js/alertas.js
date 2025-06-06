function showNotification(type, message) {
    // Eliminar notificaciones previas
    document.querySelectorAll('.notification').forEach(n => n.remove());

    const notification = document.createElement('div');
    notification.className = `notification ${type}`;
    notification.textContent = message;
    document.body.appendChild(notification);

    // Animación de entrada
    requestAnimationFrame(() => {
        notification.classList.add('show');
    });

    // Auto-eliminación
    setTimeout(() => {
        notification.classList.remove('show');
        notification.addEventListener('transitionend', () => {
            notification.remove();
        }, { once: true });
    }, 5000);
}