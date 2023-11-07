document.addEventListener("DOMContentLoaded", function() {
    // Recupera el ID del producto de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get("id");
    document.getElementById("productForm").style.display = "none";
    document.getElementById("cancelButton").style.display = "none";
    document.getElementById("newprod_deta").style.display = "none";
    document.getElementById("imgpt").style.display = "none";

    if (productId) {
        // Realiza una solicitud GET a la API para obtener los detalles del producto por ID
        fetch(`http://206.189.200.204:8080/api/v1/medicine/${productId}`)
            .then(response => response.json())
            .then(product => {
                // Actualiza los elementos HTML con los detalles del producto
                document.getElementById("productImage").src = product.imagePath;
                document.getElementById("productName").textContent = product.name;
                document.getElementById("productCode").textContent = product.code;
                document.getElementById("productDescription").textContent = product.description;
                document.getElementById("productPrice").textContent = `Q${product.price.toFixed(2)}`;
                document.getElementById("productQuantity").textContent = `${product.quantity} unidades`;
                document.getElementById("branchId").textContent = product.branchId;
                document.getElementById("imgpt").textContent = product.imagePath;


                // Después de cargar los detalles del producto, habilita el botón de "Editar"
                document.getElementById("editButton").removeAttribute("disabled");
            })
            .catch(error => {
                console.error("Error al cargar los detalles del producto: ", error);
            });
    }

   
});


function mostrarTabla() {
    document.getElementById("productForm").style.display = "none";
    document.getElementById("productImage").style.display = "inline";
    document.getElementById("editButton").style.display = "inline";
    document.getElementById("saveButton").style.display = "none";
    document.getElementById("productTable").style.display = "table";
    document.getElementById("cancelButton").style.display = "none";
    document.getElementById("deleteProduct").style.display = "inline";
    document.getElementById("newproduct").style.display = "none";
    document.getElementById("newprod_deta").style.display = "none";

}

function update(){
    location.reload()
}
function getvar(){
    const productNamef = document.getElementById("productName").value;
    const productCodef = document.getElementById("productCode").value;
    const productDescriptionf = document.getElementById("productDescription").value;
    const productPricef = document.getElementById("productPrice").value;
    const productQuantityf = document.getElementById("productQuantity").value;
    const branchIdf = document.getElementById("branchId").value;
    
}

function mostrarFormulario() {
    document.getElementById("productForm").style.display = "none";
    document.getElementById("cancelButton").style.display = "none";
    document.getElementById("productForm").style.display = "block";
    document.getElementById("productImage").style.display = "none";
    document.getElementById("editButton").style.display = "none";
    document.getElementById("saveButton").style.display = "inline";
    document.getElementById("productTable").style.display = "none";
    document.getElementById("cancelButton").style.display = "inline";
    document.getElementById("deleteProduct").style.display = "none";
    document.getElementById("newprod_deta").style.display = "inline";



}
function asigvar(){
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get("id");

    if (productId) {
        // Realiza una solicitud GET a la API para obtener los detalles del producto por ID
        fetch(`http://206.189.200.204:8080/api/v1/medicine/${productId}`)
            .then(response => response.json())
            .then(product => {
                // Actualiza los elementos HTML con los detalles del producto
                document.getElementById("productName2").value = product.name;
                document.getElementById("productCode2").value = product.code;
                document.getElementById("productDescription2").value = product.description;
                document.getElementById("productPrice2").value = product.price;
                document.getElementById("productQuantity2").value = product.quantity;
                document.getElementById("branchId2").value = product.branchId;
                document.getElementById("imgpt2").value = product.imagePath;


                // Después de cargar los detalles del producto, habilita el botón de "Editar"
                document.getElementById("editButton").removeAttribute("disabled");
            })
            .catch(error => {
                console.error("Error al cargar los detalles del producto: ", error);
            });
    }

}

function joinfun(){
    mostrarFormulario();
    asigvar();
}

function limpiarform(){
    const camposTexto = document.querySelectorAll('input[type="text"], textarea');
  camposTexto.forEach(campo => {
    campo.value = '';
  });
}

function nuevoproducto() {
limpiarform();
const productDataIns = {
    code: productCode,
    name: productName,
    description: productDescription,
    price: productPrice,
    quantity: productQuantity,
    imagePath: imgpt,
    branchId: branchId
};

fetch(`http://206.189.200.204:8080/api/v1/medicine/post`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(productDataIns)
  })
  .then(respuesta => respuesta.json())
  .then(respuestaJSON => {
    console.log('Respuesta de la API:', respuestaJSON);
  })
  .catch(error => console.error('Error al enviar la solicitud:', error));

}

function guardarCambios() {
    // Aquí puedes implementar la lógica para guardar los cambios y luego mostrar la tabla nuevamente.
    // Por ejemplo, puedes enviar una solicitud al servidor para actualizar los datos.
    // Recupera el ID del producto de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get("id");
    if (productId) {
        // Recuperar los valores del formulario
        const productName = document.getElementById("productName2").value;
        const productCode = document.getElementById("productCode2").value;
        const productDescription = document.getElementById("productDescription2").value;
        const productPrice = document.getElementById("productPrice2").value;
        const productQuantity = document.getElementById("productQuantity2").value;
        const branchId = document.getElementById("branchId2").value;
        const imgpt = document.getElementById("imgpt2").value;
        // Crear un objeto con los valores del formulario
        const productData = {
            id: productId,
            code: productCode,
            name: productName,
            description: productDescription,
            price: productPrice,
            quantity: productQuantity,
            imagePath: imgpt,
            branchId: branchId
        };

        fetch(`http://206.189.200.204:8080/api/v1/medicine/update/${productId}`, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(productData)
          })
          .then(respuesta => respuesta.json())
          .then(respuestaJSON => {
            console.log('Respuesta de la API:', respuestaJSON);
            update();
          })
          .catch(error => console.error('Error al enviar la solicitud:', error));

    }
    // Después de guardar los cambios, muestra la tabla y oculta el formulario.
    mostrarTabla();
}

function deleteItem(){
    const urlParams = new URLSearchParams(window.location.search);
    const productId = urlParams.get("id");
    const idEliminar = productId; 

fetch(`http://206.189.200.204:8080/api/v1/medicine/delete/${idEliminar}`, {
  method: 'DELETE',
  headers: {
    'Content-Type': 'application/json'
  }
})
.then(respuesta => {
  if (!respuesta.ok) {
    throw new Error('No se pudo eliminar el elemento');
  }
  return respuesta.json();
})
.then(respuestaJSON => {
  console.log('Elemento eliminado:', respuestaJSON);
  gotomain()
})
.catch(error => console.error('Error al enviar la solicitud:', error));

}

function gotomain(enlace) {
    window.location.href = './list_products.html';
  }

  function gosharp(){
    window.location.href = "#";
  }