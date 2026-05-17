async function cargarBiblioteca(){

    const usuario = JSON.parse(localStorage.getItem("usuario"));

    if(usuario == null){
        alert("Debes iniciar sesión");
        window.location.href = "login.html";
        return;
    }

    const response = await fetch(`/biblioteca/usuario/${usuario.id}`);

    if(!response.ok){
        alert("Error al cargar biblioteca");
        return;
    }

    const juegos = await response.json();

    const contenedor = document.getElementById("listaBiblioteca");

    contenedor.innerHTML = "";

    if(juegos.length == 0){
        contenedor.innerHTML = "<p>No tienes juegos en tu biblioteca</p>";
        return;
    }

    juegos.forEach(juego => {
        contenedor.innerHTML += `
            <div class="cardJuego">
                <h2>${juego.titulo}</h2>
                <p>${juego.descripcion}</p>
                <p>Precio: $${juego.precio}</p>
                <p>Clasificación: ${juego.clasificacion}</p>
            </div>
        `;
    });
}

cargarBiblioteca();
