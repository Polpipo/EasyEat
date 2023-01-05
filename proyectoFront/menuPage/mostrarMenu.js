let nombre = localStorage.getItem('nombre');
let platos = document.querySelector(".platos");
let respuesta;

let urlPag = "http://localhost:8081/menu/" + nombre + "/2";





document.onload = cargarLogoRest();

function cargarLogoRest(){
    let logoRestaurante = document.querySelector(".menu-logo-restaurante");
    let urlImg = localStorage.getItem('imagenLogo');
    urlImg = "../" + urlImg;
    let urlRestaurante = `<div><img src="${urlImg}" class="imagenesLogo"></div>`;
    logoRestaurante.insertAdjacentHTML("beforeend", urlRestaurante);

    let nombreRestaurante = document.querySelector(".menu-nombre-restaurante");
    let markupNombreRestaurante = `<p class="nombreRestaurante">${nombre}</p>`;
    logoRestaurante.insertAdjacentHTML("beforeend", markupNombreRestaurante);
}

if (sessionStorage.length > 1) {
    nombreUser.insertAdjacentHTML("beforeend",sessionStorage.getItem('nombreUsuario'));
}

let primerosPlatos = document.querySelector(".menu-primeros-platos1");
let segundosPlatos = document.querySelector(".menu-segundos-platos1");
let postres = document.querySelector(".menu-postres1");
let bebidas = document.querySelector(".menu-bebidas1");

fetch(urlPag)
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(plato => {
            let url = "./imagenes/imagenesMenu/";
            url += plato.url;
            let markupPlatos = `
            <div class="platos">
            <img src= "${url}" class="imagenesMenu">
            <h1 class="nombrePlatos">${plato.nPlato}</h1>
            <p class="precioPlatos">${plato.precioComida}€</p></br>
            <input type="number" class="cantidadPlatos" name="${plato.nPlato}${plato.idRestaurante}" min="0" max="20" value="0">
            <div>
            `;
            
            if(plato.tComida == "entrante"){
                primerosPlatos.insertAdjacentHTML("beforeend", markupPlatos);
            }else if(plato.tComida == "primer plato"){
                segundosPlatos.insertAdjacentHTML("beforeend", markupPlatos);
            }else if(plato.tComida == "postre"){
                postres.insertAdjacentHTML("beforeend", markupPlatos);
            }else{
                bebidas.insertAdjacentHTML("beforeend", markupPlatos);
            }
        });
    })
    .catch(error => console.log(error));

    const formEl = document.querySelector('.form');

    formEl.addEventListener('submit', event => {
        event.preventDefault();

        const formData = new FormData(formEl);

        const datosForm = new URLSearchParams(formData);

        fetch('http://localhost:8081/menu/registrar' , {
            method: 'POST',
            body: datosForm
        }).then(response => response.json())
        .then(data => {
            testOrder(data);
        })
        .catch(error => console.log(error));
        
    });
    ;
    
    function testOrder(elemento){
        if (elemento > 0 ) {
            //ALGUN CAMPO COMPLETADO
            Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Orden creada con el nº ' + elemento,
                showConfirmButton: true,
              })
        }else{
            //TODOS LOS CAMPOS VACÍOS
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Debes seleccionar algún plato',
                showConfirmButton: false,
                timer: 2000
              })
        }

        formEl.reset();
    }