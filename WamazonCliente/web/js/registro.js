function validaContrasenasIguales()
{
    var contrasena = document.getElementById('TBPassword');
    var contrasenaConfirmada = document.getElementById('TBConfirmarPassword');
    
    //Comparamos que sean iguales
    if (contrasena.value !== contrasenaConfirmada.value)
        contrasenaConfirmada.setCustomValidity('Las contraseñas no coinciden');
    else
        contrasenaConfirmada.setCustomValidity('');
}