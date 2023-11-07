function insertarUsuario() {
    const data = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
        idRole: document.getElementById("idRole").value,
        branchId: document.getElementById("branchId").value
    };

    fetch("http://206.189.200.204:8080/api/v1/user/post", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            alert("Usuario insertado con éxito");
        } else {
            alert("Error al insertar el usuario");
        }
    })
    .catch(error => {
        console.error("Error:", error);
    });
}