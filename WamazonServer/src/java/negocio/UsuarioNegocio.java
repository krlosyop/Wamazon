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
    public int registraUsuario(Usuario objUsuario)
    {
        int respuesta;
        
        //Se hace la consulta a la BD
        respuesta = UsuarioDAO.registraUsuario(objUsuario);
        
        return respuesta;
    }
}
