document.addEventListener("DOMContentLoaded", function() {
   
});

function asig_employ(){

  const dpi_employ_let = document.getElementById("dpi_employ").value;
  const nom_employ_let = document.getElementById("nom_employ").value;
  const ape_employ_let = document.getElementById("ape_employ").value;
  const tel_employ_let = document.getElementById("tel_employ").value;
  const dire_employ_let = document.getElementById("dire_employ").value;
  const mail_employ_let = document.getElementById("mail_employ").value;
  const blo_employ_let = document.getElementById("blo_employ").value;
  const gene_employ_let = document.getElementById("gene_employ").value;
  const puesto_employ_let = document.getElementById("puesto_employ").value;
  const emp_sucur_employ_let = document.getElementById("emp_sucur_employ").value;
}

function nuevoempleado(){

  const dpi_employ_let = document.getElementById("dpi_employ").value;
  const nom_employ_let = document.getElementById("nom_employ").value;
  const ape_employ_let = document.getElementById("ape_employ").value;
  const tel_employ_let = document.getElementById("tel_employ").value;
  const dire_employ_let = document.getElementById("dire_employ").value;
  const mail_employ_let = document.getElementById("mail_employ").value;
  const blo_employ_let = document.getElementById("blo_employ").value;
  const gene_employ_let = document.getElementById("gene_employ").value;
  const puesto_employ_let = document.getElementById("puesto_employ").value;
  const emp_sucur_employ_let = document.getElementById("emp_sucur_employ").value;

  
    const employDataIns = {
    id: dpi_employ_let,
    name: nom_employ_let,
    lastname: ape_employ_let,
    tel: tel_employ_let,
    address: dire_employ_let,
    email: mail_employ_let,
    blood: blo_employ_let,
    birthday: "2000-10-10",
    sex: gene_employ_let,
    jobTitleId: puesto_employ_let,
    branchId: emp_sucur_employ_let
    };

    fetch('http://206.189.200.204:8080/api/v1/employee/post', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(employDataIns)
  })
  .then(respuesta => respuesta.json())
  .then(respuestaJSON => {
    console.log('Respuesta de la API:', respuestaJSON);
  })

  .catch(error => console.error('Error al enviar la solicitud:', error));

}

function insert_employ(){
  asig_employ();
  nuevoempleado();

}