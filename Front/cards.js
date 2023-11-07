document.getElementById('actualizarCards').addEventListener('click', function() {
    var miCardContainer = document.getElementById('miCardContainer');

    // Elimina el contenido actual del card_container
    while (miCardContainer.firstChild) {
        miCardContainer.removeChild(miCardContainer.firstChild);
    }

    // Agrega nuevo contenido al card_container
    var nuevasCards = [
        crearCard("Nueva Card 1"),
        crearCard("Nueva Card 2"),
        crearCard("Nueva Card 3")
    ];

    nuevasCards.forEach(function(card) {
        miCardContainer.appendChild(card);
    });
});

function crearCard(contenido) {
    var card = document.createElement('div');
    card.classList.add('card');
    card.textContent = contenido;
    return card;
}
