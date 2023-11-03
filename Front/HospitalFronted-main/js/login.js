document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const data = {
        username: username,
        password: password
    };

    
    fetch("http://206.189.200.204:8080/api/v1/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la solicitud');
        }
        return response.json();
    })
    .then(data => {
        if (data.token) {
            localStorage.setItem("token", data.token);
            window.location.href = "index.html";
        } else {

            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'Correo o contraseña incorrectos'
            });
        }
    })
    .catch(error => {
        console.error(error);
        document.getElementById("error").textContent = "Error en la solicitud";
    });
});