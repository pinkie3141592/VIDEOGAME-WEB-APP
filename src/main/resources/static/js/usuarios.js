async function cargarUsuarios(){

    const response = await fetch('/usuarios');
    const usuarios = await response.json();
    const lista = document.getElementById('listaUsuarios');

    lista.innerHTML = '';

    usuarios.forEach(usuario => {
        const li = document.createElement('li');

        li.innerHTML = `
            ${usuario.id} - ${usuario.nombre}

            <button onclick="eliminarUsuario(${usuario.id})">
                Eliminar
            </button>
        
        `;

        lista.appendChild(li);

    })

}


async function agregarUsuario(){
    
    const usuario = {
        nombre: document.getElementById('nombre').value,
        correo: document.getElementById('correo').value,
        pais: document.getElementById('pais').value,
        fechaCreacion: document.getElementById('fechaCreacion').value,
        password: document.getElementById('password').value,
    };

    await fetch('/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    });

    cargarUsuarios();
}

async function eliminarUsuario(id){

    await fetch(`/usuarios/${id}`, {
        method: 'DELETE'
    });

    cargarUsuarios();

}