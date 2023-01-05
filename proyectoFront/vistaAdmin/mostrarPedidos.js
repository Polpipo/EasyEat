let tabla = document.querySelector(".myTable");
let idOrder = localStorage.getItem("orderId");

let url = 'http://localhost:8081/getPedidos/' + idOrder;

//recibir parametros de la API
fetch(url)
  .then(res => {
      return res.json();
  })
  .then(data => {
      data.forEach(pedido => {
          let markupPedido = `
          <tr>
            <td>${pedido.nComida}</td>
            <td>${pedido.cantidadPlato}</td>
          </tr>
          `;
          tabla.insertAdjacentHTML("beforeend", markupPedido);
      });
  })
  .catch(error => console.log(error));