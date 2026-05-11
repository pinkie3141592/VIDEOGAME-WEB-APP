async function iniciarSesion(){

    const datos = {
        nombre: document.getElementById('loginNombre').value,
        password: document.getElementById('loginPassword').value
    };

    const response = await fetch('/login', {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(datos)

    });

    if(!response.ok){
        alert("Error al iniciar sesión");
        return;
    }

    const usuario = await response.json();

    if(usuario == null){
        alert("Usuario o contraseña incorrectos");
        return;
    }

    alert(`Bienvenido ${usuario.nombre}`);

    if(usuario.rol == "ADMIN"){
        alert("Modo administrador activado");
        window.location.href = "menuAdministrador.html";
    }

    if(usuario.rol == "USUARIO"){
        window.location.href = "menuUsuario.html";
    }

    localStorage.setItem("usuario", JSON.stringify(usuario));

    
}