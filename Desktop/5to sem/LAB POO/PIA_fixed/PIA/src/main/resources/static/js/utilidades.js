async function cargarJuegosSelector(){
    
    const response = await fetch(`/juegos`);

    const juegos = await response.json();

    const selector = document.getElementById('selectorJuego');

    juegos.forEach(juego => {

        const option = document.createElement('option');

        option.value = juego.id;
        option.textContent = juego.titulo;

        selector.appendChild(option);
    });
}

async function mostrarJuegoSeleccionado(){

    const id = document.getElementById('selectorJuego').value;
    
    if(id == "") 
        return;

    const response = await fetch(`/juegos/${id}`);
    const juego = await response.json();

    document.getElementById('infoJuego').innerHTML = `
        <h2>${juego.titulo}</h2>
        <p>Precio: $${juego.precio}</p>
        <p>${juego.descripcion}</p>
    `;
}
