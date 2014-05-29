package negocio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioNegocio extends HttpServlet 
{
    //Variable de sesion
    HttpSession session;
    
    //Variable para saber que operacion llamar
    int q;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        //Obtenemos la sesion
        session = request.getSession();
        
        try {q = Integer.parseInt(request.getParameter("q"));}
        catch(NumberFormatException e) {q = 0;}
        
        switch(q)
        {
            case 1: //Registrar
                //int registro = getRegistro(request);
                /*if(registro == 1)  //Registro correcto
                    response.sendRedirect("bienvenidoAdministrador.jsp");
                else //Registro erroneo
                    response.sendRedirect("bienvenido.jsp");*/
                break;
            case 2:
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }
    
    private int getRegistro(HttpServletRequest request, sesion.ManejoSesion manejoSesion)
    {
        int respuesta;
        String user = request.getParameter("TBUsuario");
        String pwd = request.getParameter("TBPassword");
        String confirmarPwd = request.getParameter("TBConfirmarPassword");
        String nombre = request.getParameter("TBNombre");
        String apellidoPaterno = request.getParameter("TBApellidoPaterno");
        String apellidoMaterno = request.getParameter("TBApellidoMaterno");
        
        //Llamamos el webService
        respuesta = manejoSesion.getLogin(user, pwd);
        
        //Si el login fue correcto
        if(respuesta != -1)
        {
            //Subimos a sesion el resultado y el nombre de usuario
            session.setAttribute("rol", respuesta);
            session.setAttribute("nombreUsuario", user);
        }
        
        return respuesta;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
