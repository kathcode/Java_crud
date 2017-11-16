
function validacionLogin() {

    var user = $("#usuario").val();
    var pass = $("#password").val();

    $(".text-error").each(function () {
        $(this).css('display', 'none');
    });

    if (user == "" || user == " ")
    {
        $("#text-errorUser").css('display', 'block');
        return false;
    }

    if (pass == "" || pass == " ")
    {
        $("#text-errorPass").css('display', 'block');
        return false;
    }

    return true;

}

function validacionUsuario() {

    var tUsuario = $("#TipoUsuario").val();
    var idUsuario = $("#Identificacion").val();
    var nombre = $("#Nombre").val();
    var apell = $("#Apellidos").val();
    var telefono = $("#Telefono").val();
    var direccion = $("#Direccion").val();
    var email = $("#Email").val();
    var genero = $("#Genero").val();
    var usuario = $("#Usuario").val();
    var pass = $("#Password").val();
    var cpass = $("#CPassword").val();
    
    $("#text-error").css("display", "none");
    

    if (tUsuario == "" || tUsuario == " "){
        $("#text-error").text("*Por favor, seleccione un tipo de usuario.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (idUsuario == "" || idUsuario == " "){
        $("#text-error").text("*Por favor, ingrese una identificación.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (nombre == "" || nombre == " "){
        $("#text-error").text("*Por favor, ingrese un nombre.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (apell == "" || apell == " "){
        $("#text-error").text("*Por favor, ingrese unos apellidos.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (telefono == "" || telefono == " "){
        $("#text-error").text("*Por favor, ingrese un teléfono.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (direccion == "" || direccion == " "){
        $("#text-error").text("*Por favor, ingrese una dirección.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (email == "" || email == " "){
        $("#text-error").text("*Por favor, ingrese un email.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (validateEmail(email) != true){
        $("#text-error").text("*Por favor, ingrese un email valido.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (usuario == "" || usuario == " "){
        $("#text-error").text("*Por favor, ingrese un usuario.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (pass == "" || pass == " "){
        $("#text-error").text("*Por favor, ingrese una contraseña.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (validatePass(pass) != true){
        $("#text-error").text("*La contraseña debe contener por lo menos una mayuscula, un digito y debe ser de mínimo 8 caracteres");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (cpass == "" || cpass == " "){
        $("#text-error").text("*Por favor, confirme su contraseña.");
        $("#text-error").css("display", "block");
        return false;
    }
    
    if (pass != cpass){
        $("#text-error").text("*Las contraseñas no son iguales.");
        $("#text-error").css("display", "block");
        return false;
    }

    return true;
}

function validatePass(pass) {
    var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;
    var test = re.test(pass);
    return test;
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode != 46 && charCode > 31
      && (charCode < 48 || charCode > 57))
        return false;

    return true;
}