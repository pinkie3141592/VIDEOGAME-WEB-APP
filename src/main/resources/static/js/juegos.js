async function cargarJuegos(){

    const response = await fetch('/juegos');

    const juegos = await response.json();

    const lista = document.getElementById('listaJuegos');

    lista.innerHTML = '';

    juegos.forEach(juego => {
        const li = document.createElement('li');

        li.innerHTML = `
            ${juego.id} - ${juego.titulo}

            <button onclick="eliminarJuego(${juego.id})">
                Eliminar
            </button>
        
        `;

        lista.appendChild(li);

    })

}

async function agregarJuego(){
    
    const juego = {
        id: document.getElementById('juego-id').value,
        titulo: document.getElementById('titulo').value,
        precio: document.getElementById('precio').value,
        fechaSalida: document.getElementById('fechaSalida').value,
        descripcion: document.getElementById('descripcion').value,
    };

    await fetch('/juegos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(juego)
    });

    cargarJuegos();
}


async function eliminarJuego(id){

    await fetch(`/juegos/${id}`, {
        method: 'DELETE'
    });

    cargarJuegos();

}