function insertarSala() {
    const data = {
     roomCode: document.getElementById("roomCode").value,
      maxPatient: document.getElementById("maxPatient").value,
      description: document.getElementById("description").value,
      idBranch: document.getElementById("idBranch").value
    };

    fetch("http://206.189.200.204:8080/api/v1/room/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            Swal.fire({
                icon: 'success',
                title: 'Sala insertada con éxito',
                showConfirmButton: false,
                timer: 1500
            });
            const camposTexto = document.querySelectorAll('input[type="text"], textarea');
            camposTexto.forEach(campo => {
              campo.value = '';
          });
          const camposnumber = document.querySelectorAll('input[type="number"], textarea');
          camposnumber.forEach(campo => {
            campo.value = '';
        });
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Error al insertar la sala',
                text: 'Hubo un problema al insertar la sala.',
                showConfirmButton: true
            });
        }
    })
    .catch(error => {
        console.error("Error:", error);
        Swal.fire({
            icon: 'error',
            title: 'Error al insertar la sala',
            text: 'Hubo un problema al insertar la sala.',
            showConfirmButton: true
        });
    });
}