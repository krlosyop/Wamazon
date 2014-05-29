package negocio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import ws.negocio.Usuario;
import ws.negocio.UsuarioNegocioService;

public class UsuarioNegocio extends HttpServlet 
{
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WamazonServer/UsuarioNegocioService.wsdl")
    private UsuarioNegocioService service;
    
    //Variable de sesion
    private HttpSession session;
    
    //Variable para saber que operacion llamar
    private int q;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        //Obtenemos el puerto del service
        ws.negocio.UsuarioNegocio usuarioNegocioService = service.getUsuarioNegocioPort();
        
        //Obtenemos la sesion
        session = request.getSession();
        
        try {q = Integer.parseInt(request.getParameter("q"));}
        catch(NumberFormatException e) {q = 0;}
        
        switch(q)
        {
            case 1: //Registrar
                int registro = getRegistro(request, usuarioNegocioService);
                //Si hubo error en el registro
                if (registro == -1)
                    session.setAttribute("error", "Error al agregar a la base de datos");
                //Si el usuario ya existe
                else if (registro == 0)
                    session.setAttribute("error", "Error el usuario ya está registrado");
                //Regitro exitoso
                else if (registro == 1)
                    session.setAttribute("error", "El usuario se registró correctamente");
                //Error desconocido D:
                else                
                    session.setAttribute("error", "Ocurrio un error desconocido D:");
                
                response.sendRedirect("registro.jsp");
                break;
            case 2:
                break;
            default:
                response.sendRedirect("index.jsp");
        }
    }
    
    private int getRegistro(HttpServletRequest request, ws.negocio.UsuarioNegocio usuarioNegocioService)
    {
        int respuesta;
        
        //Recuperamos los campos
        String user = request.getParameter("TBUsuario");
        String pwd = request.getParameter("TBPassword");
        String nombre = request.getParameter("TBNombre");
        String apellidoPaterno = request.getParameter("TBApellidoPaterno");
        String apellidoMaterno = request.getParameter("TBApellidoMaterno");
        
        //Creamos el objeto usuario
        Usuario objUsuario = new Usuario();
        objUsuario.setUsuario(user);
        objUsuario.setPassword(pwd);
        objUsuario.setNombre(nombre);
        objUsuario.setApellidoPaterno(apellidoPaterno);
        objUsuario.setApellidoMaterno(apellidoMaterno);
        
        //Llamamos el webService
        respuesta = usuarioNegocioService.registraUsuario(objUsuario);
        
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
