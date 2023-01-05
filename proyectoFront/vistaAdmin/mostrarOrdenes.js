//filtrar por columna
function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }       
    }
  }

  let tabla = document.querySelector(".myTable");

  //recibir parametros de la API
  fetch('http://localhost:8081/getOrders')
    .then(res => {
        return res.json();
    })
    .then(data => {
        data.forEach(orden => {
            let markupOrden = `
            <tr>
              <td>${orden.idOrder}</td>
              <td>${orden.orderDate}</td>
              <td>${orden.pagado}</td>
              <td><button type="submit" class="btn btn-secondary" onclick="verPedido(${orden.idOrder})"">Ver Pedido</button></td>
            </tr>
            `;
            tabla.insertAdjacentHTML("beforeend", markupOrden);
        });
    })
    .catch(error => console.log(error));
    
    //ver pedido
    function verPedido(element){
      localStorage.clear;
      localStorage.setItem ('orderId', element);
      window.open("http://127.0.0.1:5500/vistaadmin/mostrarPedidos.html", '_blank').focus();
  }
