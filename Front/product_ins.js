// product_list.js
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("productForms").style.display = "block";
    document.getElementById("cancelButton").style.display = "inline";
    // Realizar una solicitud GET a la API para obtener los datos
});
    function mostrarform() {
            document.getElementById("productForms").style.display = "inline";
            document.getElementById("cancelButton").style.display = "none";
            document.getElementById("productForms").style.display = "block";
            document.getElementById("productImage").style.display = "none";
            document.getElementById("editButton").style.display = "none";
            document.getElementById("saveButtons").style.display = "inline";
            document.getElementById("saveButton").style.display = "inline";
            document.getElementById("productTable").style.display = "none";
            document.getElementById("cancelButton").style.display = "inline";
            document.getElementById("deleteProduct").style.display = "none";
        }

    function insertProduct(){
        const productName = document.getElementById("productName2").value;
        const productCode = document.getElementById("productCode2").value;
        const productDescription = document.getElementById("productDescription2").value;
        const productPrice = document.getElementById("productPrice2").value;
        const productQuantity = document.getElementById("productQuantity2").value;
        const branchId = document.getElementById("branchId2").value;
        const imgpt = document.getElementById("imgpt2").value;

        const productDataIns = {
        code: productCode,
        name: productName,
        description: productDescription,
        price: productPrice,
        quantity: productQuantity,
        imagePath: imgpt,
        branchId: branchId
        };

        fetch('http://206.189.200.204:8080/api/v1/medicine/post', {
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
      limpiarform();
    }
    
    function limpiarform(){
        const camposTexto = document.querySelectorAll('input[type="text"], textarea');
      camposTexto.forEach(campo => {
        campo.value = '';
      });
    }
