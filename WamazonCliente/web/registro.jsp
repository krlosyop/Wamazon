<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Wamazon - Registro</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
        <script src="js/registro.js" type="text/javascript" charset="utf-8"></script>
    </head>
    <body>
        <div id="loginpanelwrap">
            <div class="loginheader">
                <a href="index.jsp"><img src="images/logo.fw.png" alt="Wamazon" id="logo" /></a>
                <div class="logintitle">Registro</div>
            </div>
            <div class="loginform">
                <form action="<%=request.getContextPath()%>/UsuarioNegocio?q=1" method="post">
                    <%
                    if(session.getAttribute("error") != null)
                    {%>
                    <div class="error"><%=session.getAttribute("error")%></div>
                    <%
                        session.removeAttribute("error");
                    }%>
                    <div class="loginform_row">
                        <label>Usuario:</label>
                        <input type="email" class="loginform_input" name="TBUsuario" id="TBUsuario" required />
                    </div>
                    <div class="loginform_row">
                        <label>Password:</label>
                        <input type="password" class="loginform_input" name="TBPassword" id="TBPassword" required oninput="validaContrasenasIguales()" />
                    </div>
                    <div class="loginform_row">
                        <label>Confirmar Password:</label>
                        <input type="password" class="loginform_input" name="TBConfirmarPassword" id="TBConfirmarPassword" required oninput="validaContrasenasIguales()" />
                    </div>
                    <div class="loginform_row">
                        <label>Nombre:</label>
                        <input type="text" class="loginform_input" name="TBNombre" id="TBNombre" required />
                    </div>
                    <div class="loginform_row">
                        <label>Apellido Paterno:</label>
                        <input type="text" class="loginform_input" name="TBApellidoPaterno" id="TBApellidoPaterno" required />
                    </div>
                    <div class="loginform_row">
                        <label>Apellido Materno:</label>
                        <input type="text" class="loginform_input" name="TBApellidoMaterno" id="TBApellidoMaterno" required />
                    </div>
                    <div class="loginform_row">
                        <input type="submit" class="loginform_submit" value="Registrar" />
                    </div>
                    <div class="clear"></div>
                </form>
            </div>
        </div>
    </body>
</html>