document.addEventListener("DOMContentLoaded", function() {
    // Recupera el ID del producto de la URL
    const urlParams = new URLSearchParams(window.location.search);
    const employId = urlParams.get("id");
    document.getElementById("idPatient").value = employId; 
    //document.getElementById("productForm").style.display = "none";
    //document.getElementById("cancelButton").style.display = "none";
    //document.getElementById("newprod_deta").style.display = "none";
    //document.getElementById("imgpt").style.display = "none";

});

