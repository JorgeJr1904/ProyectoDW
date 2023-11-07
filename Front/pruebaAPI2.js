
document.addEventListener("DOMContentLoaded", function() {




fetch('http://206.189.200.204:8080/api/v1/patient/456789123456')
  .then(response => response.json())
  .then(data1 => {
    // Hacer la segunda solicitud a la API 2
    fetch('http://206.189.200.204:8080/api/v1/employee/2070832820116')
      .then(response => response.json())
      .then(data2 => {
        const tabla_emp = document.getElementById('tabla_emp');
        // Combinar los resultados de ambas APIs
        const resultadoCombinado = {
          datosDeApi1: data1,
          datosDeApi2: data2
        };
const obtenervalor = resultadoCombinado.datosDeApi2.email;
        document.getElementById("dpi_emp").value = obtenervalor;


        // Ahora puedes usar 'resultadoCombinado' como desees
        console.log(resultadoCombinado);

      })
      .catch(error => console.error('Error al obtener datos de la API 2:', error));
  })
  .catch(error => console.error('Error al obtener datos de la API 1:', error));

});