

async function cargarPublishers(){

    const response = await fetch('/publishers');

    const publishers = await response.json();

    const lista = document.getElementById('listaPublishers');

    lista.innerHTML = '';

    publishers.forEach(publisher => {
        const li = document.createElement('li');

        li.innerHTML = `
            ${publisher.id} - ${publisher.nombre}

            <button onclick="eliminarPublisher(${publisher.id})">
                Eliminar
            </button>
        
        `;

        lista.appendChild(li);

    })

}        

async function agregarPublisher(){
    
    const publisher = {
        sede: document.getElementById('publisher-sede').value,
        nombre: document.getElementById('publisher-nombre').value,
        sitioWeb: document.getElementById('publisher-sitioWeb').value,
    };

    await fetch('/publishers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(publisher)
    });

    cargarPublishers();
}

async function eliminarPublisher(id){

    await fetch(`/publishers/${id}`, {
        method: 'DELETE'
    });

    cargarPublishers();
}