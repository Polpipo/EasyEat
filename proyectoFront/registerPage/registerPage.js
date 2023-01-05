const formEl = document.querySelector('#formRegistro');

                formEl.addEventListener("submit", event => {
                  event.preventDefault();

                  const dataForm = new FormData(formEl);

                  const datosForm = new URLSearchParams(dataForm);

                  fetch('http://localhost:8081/usuario/registrar' , {
                    method: 'POST',
                    body: datosForm
                  }).then(response => response.json())
                  .then(data => {
                    enviarDatos(data, dataForm);
                  })
                  .catch(error => console.log(error));
                });

                let nombreUsuarioGuardar;

                function enviarDatos(elemento, parametros){
                  if (elemento > 0 ) {
                      //TODOS LOS CAMPOS COMPLETADOS
                      let timerInterval
                      Swal.fire({
                        title: 'Creando usuario',
                        timer: 1500,
                        timerProgressBar: true,
                        didOpen: () => {
                          Swal.showLoading()
                          timerInterval = setInterval(() => {
                          }, 100)
                        },
                        willClose: () => {
                          clearInterval(timerInterval)
                        }
                      }).then((result) => {
                        var i = 1;
                        for (const value of parametros.values()) {
                          if (i == 2) {
                            nombreUsuarioGuardar = value;
                          }
                          i++;
                        }
                        if (result.dismiss === Swal.DismissReason.timer) {
                            //sessionStorage.removeItem('nombreUsuario');
                            localStorage.setItem('nUserLocal', nombreUsuarioGuardar);
                            redirect();
                        }
                      }) 
                  }else{
                      //ALGÚN CAMPO VACÍO
                      Swal.fire({
                          position: 'center',
                          icon: 'error',
                          title: 'Debes completar todos los campos',
                          showConfirmButton: false,
                          timer: 2000
                        })
                  }
                }

function redirect(){
    window.location.replace("http://127.0.0.1:5500/index.html");
}