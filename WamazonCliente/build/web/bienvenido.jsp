<%
    String usuario = null;
    int rol = -1;
    
    //Checamos que exista la sesion
    if(session != null && session.getAttribute("rol") != null)
    {
        rol = (Integer)session.getAttribute("rol");

        //Si no es usuario normal se redirecciona a un administrador
        if(rol!=0){response.sendRedirect("bienvenidoAdministrador.jsp");}

        usuario = (String)session.getAttribute("nombreUsuario");
    }
    else
        response.sendRedirect("index.jsp");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Wamazon</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
        <!-- jQuery file -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            var $ = jQuery.noConflict();
            $(function() {
                $('#tabsmenu').tabify();
                $(".toggle_container").hide();
                $(".trigger").click(function() {
                    $(this).toggleClass("active").next().slideToggle("slow");
                    return false;
                });
            });
        </script>
    </head>
    <body>
        <div id="panelwrap">

            <div class="header">
                <div class="title"><a href="#">Compra productos</a></div>

                <div 
                    class="header_right"><img src="images/logo.fw.png" alt="Wamazon" id="welcome" />elcome <%=usuario%> <a href="#" class="settings">Settings</a> <a href="<%=request.getContextPath()%>/ManejoSesion?q=2" class="logout">Logout</a>
                </div>

                <div class="menu">
                    <ul>
                        <li><a href="bienvenido.jsp" class="selected">Página Principal</a></li>
                        <li><a href="verCarrito.jsp">Ver Carrito</a></li>
                    </ul>
                    
                </div>
                <div class="buscar">
                        <form action="#" method="POST">
                                <input type="search"name="buscar" class ="selected"/>
                                <input type="submit"name="enviar" value="Buscar" class ="selected"/>
                        </form>
                </div>
            </div>
       
           <div class="center_content">  

                <div id="right_wrap">
                    <div id="right_content">             
                        <h2>Productos</h2> 


                        

                       
                       
                    </div>
                </div><!-- end of right content-->


                <div class="sidebar" id="sidebar">
                    <h2>Browse categories</h2>

                    <ul>
                        <li><a href="#" class="selected">Main page</a></li>
                        <li><a href="#">Template settings</a></li>
                        <li><a href="#">Add page</a></li>
                        <li><a href="#">Edit section</a></li>
                        <li><a href="#">Templates</a></li>
                        <li><a href="#">Clients</a></li>
                    </ul>
                </div>             


                <div class="clear"></div>
            </div> <!--end of center_content-->

            <div class="footer">
                Panelo - Free Admin Template by <a href="htpp://csstemplatesmarket.com" target="_blank">CSSTemplatesMarket</a>
            </div>

        </div>


    </body>
</html>