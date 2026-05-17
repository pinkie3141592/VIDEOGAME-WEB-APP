async function obtenerUsuarioPorCorreo(correo){

    const response = await fetch(`/usuarios/correo/${correo}`);

    if(!response.ok){
        return null;
    }

    const usuario = await response.json();

    return usuario;
}