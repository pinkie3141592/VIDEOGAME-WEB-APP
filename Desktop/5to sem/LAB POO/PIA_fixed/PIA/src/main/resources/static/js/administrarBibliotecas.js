let usuarioActual = null;

async function cargarJuegosSelector(){
    const response = await fetch('/juegos');

    if(!response.ok){
        alert("Error al cargar juegos");
        return;
    }
    
    const juegos = await response.json();
    const selector = document.getElementById('selectorJuego');

    selector.innerHTML = '<option value="">Selecciona un juego</option>';

    juegos.forEach(juego => {
        const option = document.createElement('option');
        option.value = juego.id;
        option.textContent = juego.titulo;
        selector.appendChild(option);
    });
}

async function mostrarJuegoSeleccionado(){
    const id = document.getElementById('selectorJuego').value;

    if(id == ""){
        document.getElementById('infoJuego').innerHTML = "";
        return;
    }

    const response = await fetch(`/juegos/${id}`);

    if(!response.ok){
        alert("Error al buscar juego");
        return;
    }

    const juego = await response.json();

    document.getElementById('infoJuego').innerHTML = `
        <h2>${juego.titulo}</h2>
        <p><strong>Precio:</strong> $${juego.precio}</p>
        <p>${juego.descripcion}</p>
    `;
}

async function buscarUsuarioPorCorreo(){
    const correo = document.getElementById('correoUsuario').value.trim();

    if(correo == ""){
        alert("Ingresa el correo del usuario");
        return null;
    }

    const responseUsuario = await fetch(`/usuarios/correo/${encodeURIComponent(correo)}`);

    if(!responseUsuario.ok){
        alert("Usuario no encontrado");
        return null;
    }

    const usuario = await responseUsuario.json();

    if(usuario == null || usuario.id == null){
        alert("Usuario no encontrado");
        return null;
    }

    usuarioActual = usuario;
    return usuario;
}

async function cargarBibliotecaUsuario(){
    const usuario = await buscarUsuarioPorCorreo();

    if(usuario == null){
        return;
    }

    const response = await fetch(`/biblioteca/usuario/${usuario.id}`);

    if(!response.ok){
        alert("Error al cargar la biblioteca del usuario");
        return;
    }

    const juegos = await response.json();
    const lista = document.getElementById('listaBibliotecaUsuario');

    lista.innerHTML = "";

    if(juegos.length == 0){
        lista.innerHTML = `<li>Este usuario todavía no tiene juegos en su biblioteca.</li>`;
        return;
    }

    juegos.forEach(juego => {
        const li = document.createElement('li');
        li.innerHTML = `
            <h3>${juego.titulo}</h3>
            <p>${juego.descripcion}</p>
            <p><strong>Precio:</strong> $${juego.precio}</p>
            <button onclick="eliminarJuegoUsuario(${juego.id})">Quitar de la biblioteca</button>
        `;
        lista.appendChild(li);
    });
}

async function agregarJuegoUsuario(){
    const usuario = await buscarUsuarioPorCorreo();
    const juegoId = document.getElementById('selectorJuego').value;

    if(usuario == null){
        return;
    }

    if(juegoId == ""){
        alert("Selecciona un juego");
        return;
    }

    const biblioteca = {
        id: {
            usuariosId: usuario.id,
            juegosId: parseInt(juegoId)
        }
    };

    const responseBiblioteca = await fetch('/biblioteca', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(biblioteca)
    });

    if(!responseBiblioteca.ok){
        alert("Error al agregar juego");
        return;
    }

    alert("Juego agregado correctamente");
    cargarBibliotecaUsuario();
}

async function eliminarJuegoUsuario(juegoId){
    if(usuarioActual == null){
        usuarioActual = await buscarUsuarioPorCorreo();
    }

    if(usuarioActual == null){
        return;
    }

    const response = await fetch(`/biblioteca/${juegoId}/${usuarioActual.id}`, {
        method: 'DELETE'
    });

    if(!response.ok){
        alert("Error al quitar juego");
        return;
    }

    alert("Juego eliminado de la biblioteca");
    cargarBibliotecaUsuario();
}

window.onload = function(){
    cargarJuegosSelector();
}
