// product_list.js
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("productForms").style.display = "none";
    document.getElementById("cancelButton").style.display = "none";

    fetch("http://206.189.200.204:8080/api/v1/medicine")
    .then(response => response.json())
    .then(data => {
        // Luego de obtener los datos, recorre la lista de productos y crea tarjetas para cada uno
        const cardsContainer = document.querySelector(".cards_container");
    //var cardsContainer = document.getElementById('.cards_container');
     
    // por cada dato recibido de la api hara una card
//elimina cards actuales 



        data.forEach(product => {

            //crea cartas de contenido

            const productCard = document.createElement("div");
            productCard.className = "product_card";
            productCard.innerHTML = `
                <a href="product_details.html?id=${product.id}" class="product_card">
                <img src="${product.imagePath}" alt="${product.name}">
                <div class="product_info">
                    <div>
                        <p>Q${product.price.toFixed(2)}</p>
                        <p>${product.name}</p>
                    </div>
                    <figure>
                        <img src="./icons/bt_add_to_cart.svg" alt="">
                    </figure>
                </div>
            `;
            cardsContainer.appendChild(productCard);
        });
    })
    .catch(error => {
        console.error("Error al cargar los productos: ", error);
    });
});


    document.getElementById('actualizarCards').addEventListener('click', function() {
        const search_var = document.getElementById("busqueda1").value;
        document.getElementById("clean_search").style.display = "inline";
    // Realizar una solicitud GET a la API para obtener los datos
    fetch("http://206.189.200.204:8080/api/v1/medicine/search/"+search_var)
        .then(response => response.json())
        .then(data => {
            // Luego de obtener los datos, recorre la lista de productos y crea tarjetas para cada uno
            const cardsContainer = document.querySelector(".cards_container");
        //var cardsContainer = document.getElementById('.cards_container');
         
        // por cada dato recibido de la api hara una card
    //elimina cards actuales 

    while (cardsContainer.firstChild) {
        cardsContainer.removeChild(cardsContainer.firstChild);
    }

            data.forEach(product => {

                //crea cartas de contenido

                const productCard = document.createElement("div");
                productCard.className = "product_card";
                productCard.innerHTML = `
                    <a href="product_details.html?id=${product.id}" class="product_card">
                    <img src="${product.imagePath}" alt="${product.name}">
                    <div class="product_info">
                        <div>
                            <p>Q${product.price.toFixed(2)}</p>
                            <p>${product.name}</p>
                        </div>
                        <figure>
                            <img src="./icons/bt_add_to_cart.svg" alt="">
                        </figure>
                    </div>
                `;
                cardsContainer.appendChild(productCard);
            });
        })
        .catch(error => {
            console.error("Error al cargar los productos: ", error);
        });
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
    
function var_filter_search(){
    var search_var = document.getElementById("busqueda1").value;
    document.getElementById('searchby').addEventListener('click', function() {
        window.location.href = 'list_search.html';
    });

}

    function nuevoproducto(){
        const productName = document.getElementById("productName2").value;
        const productCode = document.getElementById("productCode2").value;
        const productDescription = document.getElementById("productDescription2").value;
        const productPrice = document.getElementById("productPrice2").value;
        const productQuantity = document.getElementById("productQuantity2").value;
        const branchId = document.getElementById("branchId2").value;
        const imgpt = document.getElementById("imgpt2").value;
        
    const productDataIns = {
        code: productCode2,
        name: productName2,
        description: productDescription2,
        price: productPrice2,
        quantity: productQuantity2,
        imagePath: imgpt2,
        branchId: branchId2
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
    
    function limpiarform(){
        const camposTexto = document.querySelectorAll('input[type="text"], textarea');
      camposTexto.forEach(campo => {
        campo.value = '';
      });
    }