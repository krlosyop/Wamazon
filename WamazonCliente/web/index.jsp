<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Wamazon - Index</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div id="loginpanelwrap">
            <div class="loginheader">
                <a href="index.jsp"><img src="images/logo.fw.png" alt="Wamazon" id="logo" /></a>
                <div class="logintitle">Login</div>
            </div>
            <div class="loginform">
                <form action="<%=request.getContextPath()%>/ManejoSesion?q=1" method="post">
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
                        <input type="password" class="loginform_input" name="TBPassword" id="TBPassword" required />
                    </div>
                    <div class="loginform_row centro">
                        <a href="registro.jsp">Registrarme!</a>                    
                        <input type="submit" class="loginform_submit" value="Login" />
                    </div>
                    <div class="clear"></div>
                </form>
            </div>
        </div>
    </body>
</html>