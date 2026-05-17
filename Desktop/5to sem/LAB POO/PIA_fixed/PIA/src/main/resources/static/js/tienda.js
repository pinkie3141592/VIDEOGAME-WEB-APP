function verDetalleJuego(id){
    window.location.href = `detalleJuego.html?id=${id}`;
}

async function cargarTodosJuegos(){

    const response = await fetch('/juegos');

    if(!response.ok){
        alert("Error al cargar juegos");
        return;
    }

    const juegos = await response.json();

    const contenedor = document.getElementById("listaJuegos");

    contenedor.innerHTML = "";

    if(juegos.length == 0){

        contenedor.innerHTML = "<p>No hay juegos en existencia</p>";

        return;
    }

    juegos.forEach(juego => {

        contenedor.innerHTML += `

            <div class="cardJuego" onclick="verDetalleJuego(${juego.id})">

                <h2>${juego.titulo}</h2>

                <p>${juego.descripcion}</p>

                <p>Precio: $${juego.precio}</p>

                <p>Clasificación: ${juego.clasificacion}</p>

            </div>

        `;
    });
}

cargarTodosJuegos();

