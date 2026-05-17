async function iniciarSesion(){

    const datos = {
        correo: document.getElementById("loginCorreo").value,
        password: document.getElementById("loginPassword").value
    };

    console.log("Mandando:", datos);

    const response = await fetch("/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(datos)
    });

    console.log("Status:", response.status);

    if(!response.ok){
        const error = await response.text();
        console.log("Error:", error);
        alert("Error al iniciar sesión");
        return;
    }

    const usuario = await response.json();

    console.log("Usuario recibido:", usuario);

    if(usuario == null || usuario.id == null){
        alert("Correo o contraseña incorrectos");
        return;
    }

    localStorage.setItem("usuario", JSON.stringify(usuario));

    if(usuario.rol == "ADMIN"){
        window.location.href = "menuAdministrador.html";
    }

    if(usuario.rol == "USUARIO"){
        window.location.href = "menuUsuario.html";
    }
}