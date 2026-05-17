async function cargarDetalleJuego(){

    const params = new URLSearchParams(window.location.search);
    const juegoId = params.get("id");

    const responseJuego = await fetch(`/juegos/${juegoId}`);
    const juego = await responseJuego.json();

    document.getElementById("infoJuego").innerHTML = `
        <div class="cardJuego">
            <h1>${juego.titulo}</h1>
            <p>${juego.descripcion}</p>
            <p>Precio: $${juego.precio}</p>
            <p>Clasificación: ${juego.clasificacion}</p>
        </div>
    `;

    const responseReviews = await fetch("/reviews");
    const reviews = await responseReviews.json();

    const reviewsJuego = reviews.filter(review => review.juegosId == juegoId);

    const contenedor = document.getElementById("listaResenas");
    contenedor.innerHTML = "";

    if(reviewsJuego.length == 0){
        contenedor.innerHTML = "<p>Este juego todavía no tiene reseñas.</p>";
        return;
    }

    reviewsJuego.forEach(review => {
        contenedor.innerHTML += `
            <div class="cardReview">
                <h3>Calificación: ${review.calificacion}/5</h3>
                <p>${review.contenido}</p>
            </div>
        `;
    });
}

cargarDetalleJuego();