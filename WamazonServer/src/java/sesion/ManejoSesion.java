package sesion;

import conexionSQL.UsuarioDAO;
import javax.jws.WebService;

@WebService
public class ManejoSesion
{
    /*
     * Metodo para accesar al sistema. Invoca al metodo que hace la consulta a la base de datos.
     * Recibe un usuario y un password.
     * Retorna -1 en caso de error, 1 si es administrador y 0 si es usuario.
     */
    public int getLogin(String user, String pwd)
    {
        int rol;
        
        //Se hace la consulta a la BD
        rol = UsuarioDAO.getLogin(user, pwd);
        
        return rol;
    }
}
