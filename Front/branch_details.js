document.addEventListener("DOMContentLoaded", function() {
    // Recupera el ID del producto de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const employId = urlParams.get("id");
    //document.getElementById("productForm").style.display = "none";
    //document.getElementById("cancelButton").style.display = "none";
    //document.getElementById("newprod_deta").style.display = "none";
    //document.getElementById("imgpt").style.display = "none";

    if (employId) {
        // Realiza una solicitud GET a la API para obtener los detalles del producto por ID
        fetch(`http://206.189.200.204:8080/api/v1/branch/${employId}`)

            .then(response => response.json())
            .then(empleado => {
              //const timeapi = empleado.birthday;

              //const date_op = {day: 'numeric', month: 'numeric',  year: 'numeric'};
  
              //var date_new = new Date(timeapi).toLocaleString(undefined, date_op);
                
              // Actualiza los elementos HTML con los detalles del producto
                document.getElementById("dpi_emp").value = empleado.id;
                document.getElementById("telef").value = empleado.code;
                document.getElementById("direcc").value = empleado.branchName;
                document.getElementById("email1").value = empleado.address;
                document.getElementById("blood_emp").value = empleado.tel;


             


                // Después de cargar los detalles del producto, habilita el botón de "Editar"
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

function save_mod_emple_input(){
  const urlParams = new URLSearchParams(window.location.search);
  const empid = urlParams.get("id");
  if (empid) {
      // Recuperar los valores del formulario

      const dpi_emp = document.getElementById("dpi_emp").value;
      const telef = document.getElementById("telef").value;
      const direcc = document.getElementById("direcc").value;
      const email1 = document.getElementById("email1").value;
      const blood_emp = document.getElementById("blood_emp").value;


//"2023-13-01", fecha json
      // Crear un objeto con los valores del formulario
      const JSON_EMP = {
        id: dpi_emp,
        roomCode: telef,
        maxPatient: direcc,
        description: email1,
        idBranch: blood_emp
        };

      fetch(`http://206.189.200.204:8080/api/v1/room/update/${empid}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(JSON_EMP)
        })
        .then(respuesta => respuesta.json())
        .then(respuestaJSON => {
          console.log('Respuesta de la API:', respuestaJSON);
//        update();
        })
        .catch(error => console.error('Error al enviar la solicitud:', error));
       

  }
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

function deleteEmploy(){
  const urlParams = new URLSearchParams(window.location.search);
  const empId = urlParams.get("id");
  const employ_del = empId; 

fetch(`http://206.189.200.204:8080/api/v1/room/delete/${employ_del}`, {
method: 'DELETE',
headers: {
  'Content-Type': 'application/json'
}
})
.then(respuesta => {
if (!respuesta.ok) {
  throw new Error('El elemento tiene llave foranea o no hay conexión');
}
return respuesta.json();
})
.then(respuestaJSON => {
console.log('Elemento eliminado:', respuestaJSON);
goto_list_bed()
})
.catch(error => {
  alert('Fallo en la eliminación: ' + error.message);

});

}

function goto_list_employ(enlace) {
  window.location.href = './list_employees.html';
}

function goto_list_patient(enlace) {
  window.location.href = './patient_list.html';
}

function goto_list_bed(enlace) {
  window.location.href = './bedrooms.html';
}

function gotomain(enlace) {
    window.location.href = './list_products.html';
  }

  function gosharp(){
    window.location.href = "#";
  }


  function add_emple() {

    const dpi_emp = document.getElementById("dpi_emp").value;
      const name_emp = document.getElementById("name_emple").value;
      const last_emp = document.getElementById("apellido_emple").value;
      const telef = document.getElementById("telefono").value;
      const email1 = document.getElementById("mail").value;
      const direcc = document.getElementById("dire").value;
      const blood_emp = document.getElementById("blo").value;
      const gen_emp = document.getElementById("gene").value;
      const job_emp = document.getElementById("puesto").value;  
      const branch = document.getElementById("emp_sucur").value;  


  const EmpDataIns = {
      id: dpi_emp,
      name: name_emp,
      lastname: last_emp,
      tel: telef,
      address: direcc,
      email: email1,
      blood: blood_emp,
      birthday: "2023-13-01",
      sex: gen_emp,
      jobTitleId: job_emp,
      branchId: branch
      };
  
  fetch('http://206.189.200.204:8080/api/v1/employee/post', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(EmpDataIns)
    })
    .then(respuesta => respuesta.json())
    .then(respuestaJSON => {
      console.log('Respuesta de la API:', respuestaJSON);
    })
    .catch(error => {
      alert("Fallo al guardar el registro: " + error.message)
    });
  }

  function mod_emple_input(){
    var add_emple_but = document.getElementById('add_emple_but');
    var save_mod_emp = document.getElementById('save_mod_emp');
    var mod_emp_bot = document.getElementById('mod_emp_bot');
   
  const dpi_emp = document.getElementById('dpi_emp');
  const telef = document.getElementById('telef');
  const direcc = document.getElementById('direcc');
  const email1 = document.getElementById('email1');
  const blood_emp = document.getElementById('blood_emp');


  alert("Ya puede modificar los campos");

// Habilita el input
dpi_emp.disabled = false;
dpi_emp.style.backgroundColor = 'lightblue';
dpi_emp.style.border = '2px solid red';

telef.disabled = false;
telef.style.backgroundColor = 'lightblue';
telef.style.border = '2px solid red';

direcc.disabled = false;
direcc.style.backgroundColor = 'lightblue';
direcc.style.border = '2px solid red';

email1.disabled = false;
email1.style.backgroundColor = 'lightblue';
email1.style.border = '2px solid red';

blood_emp.disabled = false;
blood_emp.style.backgroundColor = 'lightblue';
blood_emp.style.border = '2px solid red';


add_emple_but.style.display = 'none';
save_mod_emp.style.display = 'inline';
mod_emp_bot.style.display = 'none';

}