package negocio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import sesion.ManejoSesionService;

public class ManejoSesion extends HttpServlet
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WamazonServer/ManejoSesionService.wsdl")
    private ManejoSesionService service;
    
    //Variable de sesion
    HttpSession session;
    
    //Variable para saber que operacion llamar
    int q;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        //Obtenemos el puerto del service
        sesion.ManejoSesion manejoSesion = service.getManejoSesionPort();
        
        //Obtenemos la sesion
        session = request.getSession();
        
        try {q = Integer.parseInt(request.getParameter("q"));}
        catch(NumberFormatException e) {q = 0;}
        
        switch(q)
        {
            case 1: //Iniciar Sesion
                int login = getLogin(request, manejoSesion);
                if(login == 1)  //Es administrador                    
                    response.sendRedirect("bienvenidoAdministrador.jsp");
                else if(login == 0)  //Es usuario
                    response.sendRedirect("bienvenido.jsp");
                else
                {
                    //Mandamos el error
                    session.setAttribute("error", "Nombre de usuario o contraseña incorrectos");
                    response.sendRedirect("index.jsp");
                }
                break;
            case 2: //Cerrar Sesion
                session.invalidate();
                response.sendRedirect("index.jsp");
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }
    
    private int getLogin(HttpServletRequest request, sesion.ManejoSesion manejoSesion)
    {
        int respuesta;
        String user = request.getParameter("TBUsuario");
        String pwd = request.getParameter("TBPassword");
        
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
