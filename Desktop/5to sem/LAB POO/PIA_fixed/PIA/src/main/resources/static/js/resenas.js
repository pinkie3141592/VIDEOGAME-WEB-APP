async function guardarResena(){

    const juegoId = document.getElementById("selectorJuego").value;
    const contenido = document.getElementById("textoResena").value.trim();
    const calificacion = document.getElementById("calificacion").value;
    const usuario = JSON.parse(localStorage.getItem("usuario"));

    if(usuario == null){
        alert("Debes iniciar sesión");
        return;
    }

    if(juegoId == ""){
        alert("Selecciona un juego");
        return;
    }

    if(calificacion == ""){
        alert("Selecciona una calificación");
        return;
    }

    if(contenido == ""){
        alert("Escribe una reseña");
        return;
    }

    const datos = {
        contenido: contenido,
        usuariosId: usuario.id,
        juegosId: parseInt(juegoId),
        calificacion: parseInt(calificacion)
    };

    console.log("Mandando reseña:", datos);

    const response = await fetch("/reviews", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(datos)
    });

    if(!response.ok){
        const error = await response.text();
        console.log("Error backend:", error);
        alert("Error al guardar reseña");
        return;
    }

    alert("Reseña publicada");
}

async function cargarResenas() {
    
    const juegoId = document.getElementById("selectorJuego").value;

    const contenedor = document.getElementById("listaResenas");

    contenedor.innerHTML = "";

    if(juegoId=""){
        return;
    }

    const response = await fetch("/reviews");

    if(!response.ok){
        alert("Error al cargar reseñas");
        return;
    }

    const reviews = await response.json();

    const reviewsJuego = reviews.filter( review => review.juegosId == juegoId);

    if(reviewsJuego.lenght == 0){
        contenedor.innerHTML = "<p>No hay reseñas todavía</p>";
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

async function cargarResenasAdmin() {
    
    const juegoId = document.getElementById("selectorJuego").value;

    const contenedor = document.getElementById("listaResenas");

    contenedor.innerHTML = "";

    if(juegoId == ""){
        return;
    }

    const response = await fetch("/reviews");

    if(!response.ok){
        alert("Error al cargar reseñas");
        return;
    }

    const reviews = await response.json();

    const reviewsJuego = reviews.filter( review => review.juegosId == juegoId);

    if(reviewsJuego.length == 0){
        contenedor.innerHTML = "<p>No hay reseñas todavía</p>";
        return;
    }

    reviewsJuego.forEach(review => {

        contenedor.innerHTML += `

            <div class="cardReview">
                <h3>Calificación: ${review.calificacion}/5</h3>
                <p>${review.contenido}</p>

                <button onclick="eliminarResena(${review.id})">
                    Eliminar
                </button>
            </div>

        `;
    });

}

async function eliminarResena(id){

    const response = await fetch(`/reviews/${id}`, {
        method: "DELETE"
    });

    if(!response.ok){
        alert("Error al eliminar reseña");
        return;
    }

    alert("Reseña eliminada");

    cargarResenas();
}

function seleccionarCalificacion(valor, boton){

    document.getElementById("calificacion").value = valor;

    const botones = document.querySelectorAll(".btnCalificacion");

    botones.forEach(btn => {
        btn.classList.remove("calificacionSeleccionada");
    });

    boton.classList.add("calificacionSeleccionada");
}

window.onload = function() {
    cargarJuegosSelector();
}