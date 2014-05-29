package negocio;

import conexionSQL.UsuarioDAO;
import javax.jws.WebService;
import pojo.Usuario;

@WebService
public class UsuarioNegocio 
{
    /*
     * Metodo para registrar un usuario. Invoca al metodo que hace la insercion en la base de datos.
     * Recibe un objeto usuario.
     * Retorna true en caso de éxito o false en caso contrario.
    */
    public boolean registraUsuario(Usuario objUsuario)
    {
        boolean respuesta;
        
        objUsuario = new Usuario();
        objUsuario.setUsuario("carlos");
        objUsuario.setPassword("1234");
        objUsuario.setNombre("Carlos Adrian");
        objUsuario.setApellidoPaterno("Jimenez");
        objUsuario.setApellidoMaterno("Lopez");
        
        //Se hace la consulta a la BD
        respuesta = UsuarioDAO.registraUsuario(objUsuario);
        
        return respuesta;
    }
}
