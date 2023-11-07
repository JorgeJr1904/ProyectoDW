function insertarRol() {
    const data = {
        roleName: document.getElementById("roleName").value
    };

    fetch("http://206.189.200.204:8080/api/v1/role/post", {
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
                title: 'Datos insertados correctamente',
                showConfirmButton: false,
                timer: 1500
            });
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Error al insertar el rol',
                text: 'Hubo un problema al insertar el rol.',
                showConfirmButton: true
            });
        }
    })
    .catch(error => {
        console.error("Error:", error);
        Swal.fire({
            icon: 'error',
            title: 'Error al insertar el rol',
            text: 'Hubo un problema al insertar el rol.',
            showConfirmButton: true
        });
    });
}