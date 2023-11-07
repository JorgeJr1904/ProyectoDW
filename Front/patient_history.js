document.addEventListener("DOMContentLoaded", function() {
  const urlParams = new URLSearchParams(window.location.search);
  const employId = urlParams.get("id");

  // URL de la API consumir api y llenar un array
const apiUrlGetEmp = 'http://206.189.200.204:8080/api/v1/patientHistory/history/'+employId;

// Iniciar la solicitud usando fetch
fetch(apiUrlGetEmp)
  .then(response => response.json()) // Convertir la respuesta a JSON
  .then(data_em => {
    // Aquí `data` contendrá los datos de la API en formato JSON
    // Si los datos están en un array, ahora se almacenan en la constante data_emp
     //adicional creamos constante tabla_emp para direccionar los datos
    
    
     //const data_emp = data_em
    const tabla_emp = document.getElementById('tabla_emp');
    data_em.forEach(data_emp => {

      const fila = document.createElement('tr');

      //var timeapi = data_emp.birthday;

      //const date_op = {day: 'numeric', month: 'numeric',  year: 'numeric'};
  
      //var date_new = new Date(timeapi).toLocaleString(undefined, date_op);
  
      for (const key in data_emp){
        const celda = document.createElement('td');
        celda.innerText = data_emp[key]
        fila.appendChild(celda);
      }

      tabla_emp.appendChild(fila);

    fila.addEventListener('click', function() {
      window.location.href = "./patientHistory_details.html?id="+data_emp.id;
    });
    //document.getElementById("timest").value = date_new;
    // Si los datos están anidados dentro de un objeto, puedes acceder a ellos así
    // const miArray = data.resultados; // Por ejemplo
    // Ahora puedes trabajar con `miArray`
    console.log(data_emp)
  })
  .catch(error => {
    //console.error('Error al obtener los datos:', error);
    alert('Ocurrió un error al cargar los datos de la API: ' + error.message);
  });
 
});

});


// Obtener el botón por su ID
var boton = document.getElementById("add_Patient");

// Asignar un evento de clic al botón
boton.addEventListener("click", function() {
  const urlParams2 = new URLSearchParams(window.location.search);
  const id_pac = urlParams2.get("id");
    // Redirigir a la página de Google
    window.location.href = "./add_patientHistory.html?id="+id_pac;
});