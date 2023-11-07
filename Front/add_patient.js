document.addEventListener("DOMContentLoaded", function() {




$(document).ready(function() {
  $('#telefono').inputmask('99999999');
});

$(document).ready(function() {
  $('#tel_pac').inputmask('99999999');
});
$(document).ready(function() {
  $('#dpi_pac').inputmask('9999999999999');
});
$(document).ready(function() {
  $('#dpi_emp').inputmask('9999999999999');
});

$(document).ready(function() {
  $('#dpi_emple').inputmask('9999999999999');
});

});
//$(document).ready(function() {
  //$('#fechanac').inputmask('99/99/9999', { 'placeholder': 'DD/MM/YYYY' });
//});


    function add_patient(){

      const dpi_emp = document.getElementById("dpi_emple").value;
      const name_emple = document.getElementById("name_emple").value;
      const last_emp = document.getElementById("apellido_emple").value;
      const telef = document.getElementById("telefono").value;
      const email1 = document.getElementById("mail").value;
      const direcc = document.getElementById("dire").value;
      const blood_emp = document.getElementById("blo").value;
      const gen_emp = document.getElementById("gene").value;
      const room_pac = document.getElementById("roompac").value;  


    const Emp_DataIns = {
        id: dpi_emp,
        name: name_emple,
        lastname: last_emp,
        tel: telef,
        address: direcc,
        email: email1,
        blood: blood_emp,
        birthday: "2000-10-10",
        sex: gen_emp,
        roomId: room_pac
        };
    
        fetch('http://206.189.200.204:8080/api/v1/patient/post', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(Emp_DataIns)
        })
        .then(respuesta => respuesta.json())
        .then(respuestaJSON => {
          console.log('Respuesta de la API:', respuestaJSON);
          updatenow()
        })
      
        .catch(error => {
          alert('Ocurrió un error al cargar los datos de la API: ' + error.message);
        });

      }

      function updatenow(){
        location.reload()
}