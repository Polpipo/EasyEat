let restaurantes = document.querySelector(".restaurantes");
let restaurante = document.querySelector(".restaurante");
let nombreUser = document.querySelector("#nombreUser");

if (localStorage.getItem('nUserLocal') !== null) {
    let usuarioParaWeb = localStorage.getItem('nUserLocal');
    localStorage.removeItem('nUserLocal');
    sessionStorage.setItem('nombreUsuario', usuarioParaWeb);
} 
 
if (sessionStorage.length > 1) {
    document.getElementById("iniciarSesionGeneral").style.display = "none";
    document.getElementById("btnRegistrar").style.display = "none";
    nombreUser.insertAdjacentHTML("beforeend", 'Bienvenid@ ' + sessionStorage.getItem('nombreUsuario'));
}else{
    document.getElementById("nombreUser").style.display = "none";
}



fetch("http://localhost:8081/restaurantes")
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(rest => {
            let url = "landingPage/imagenes/logosRestaurantes/";
            url += rest.url;

            let dispoImg;

            if (rest.nMesas < 11 && rest.nMesas > 0) {
                dispoImg = "landingPage/public/playground_assets/disponibilidadMedia.png";
            }else if (rest.nMesas < 1) {
                dispoImg = "landingPage/public/playground_assets/noDisponible.png";
            }else{
                dispoImg = "landingPage/public/playground_assets/disponible.png";
            }

            let markupRestaurantes = `
            <div class="restaurante" >
                <p class="numeroMesas">Mesas disponibles: ${rest.nMesas}</p>
                <img src="${dispoImg}" class="disponibilidad">
                <img src="${url}" class="logoRestaurante">
                <h1 class="nombreRestaurante">${rest.nRestaurante}</h1>
                <img class="ubicacion" src="landingPage/public/playground_assets/ubicacion.svg">
                <p class="direccionRestaurante">${rest.direccion}</p>
                <p class="horarioRestaurante">Horario: <b>${rest.horario}</b></p>
                <p class="telefonoRestaurante">Telefono: <b>${rest.telefono}</b></p>
                <button type="submit" class="reservar" onclick="reservando(${rest.nRestaurante})" id="${rest.nRestaurante}" name="${url}">RESERVAR<button>
            <div>
            `;

            restaurantes.insertAdjacentHTML("beforeend", markupRestaurantes);
            });
        })
    .catch(error => console.log(error));


    function reservando(element){
        localStorage.clear;
        localStorage.setItem ('nombre', element.id);
        localStorage.setItem('imagenLogo', element.name);
        window.location.replace("http://127.0.0.1:5500/menuPage/menuPage.html");
    }

    function redirigirRegistro(){
        window.location.replace("http://127.0.0.1:5500/registerPage/registerPage.html");
    }

