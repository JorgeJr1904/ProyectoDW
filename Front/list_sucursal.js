document.addEventListener("DOMContentLoaded", function() {

  // URL de la API consumir api y llenar un array
const apiUrlGetEmp = 'http://206.189.200.204:8080/api/v1/branch';

// Iniciar la solicitud usando fetch
fetch(apiUrlGetEmp)
  .then(response => response.json()) // Convertir la respuesta a JSON
  .then(data_em => {
    // Aquí `data` contendrá los datos de la API en formato JSON
    // Si los datos están en un array, ahora se almacenan en la constante data_emp
     //adicional creamos constante tabla_emp para direccionar los datos
    const data_emp = data_em
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
      window.location.href = "./branch_details.html?id="+data_emp.id;
    });
    //document.getElementById("timest").value = date_new;
    // Si los datos están anidados dentro de un objeto, puedes acceder a ellos así
    // const miArray = data.resultados; // Por ejemplo
    // Ahora puedes trabajar con `miArray`
    console.log(data_emp);
  })
  
  .catch(error => {
    console.error("Error al cargar los detalles del producto: ", error);
});
});

});

$(document).ready(function() {
  $('#telefono').inputmask('9999-9999');
});

$(document).ready(function() {
  $('#tel_pac').inputmask('9999-9999');
});
$(document).ready(function() {
  $('#dpi_pac').inputmask('9999999999999');
});
$(document).ready(function() {
  $('#dpi_emp').inputmask('9999999999999');
});

$(document).ready(function() {
  $('#fechanac').inputmask('99/99/9999', { 'placeholder': 'DD/MM/YYYY' });
});


document.getElementById('generos').addEventListener('change', function() {
  var valorSeleccionado = this.value;
  document.getElementById('gene').value = valorSeleccionado;
});