package conexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Usuario;

public class UsuarioDAO 
{
    //Variables para la conexion con la base de datos
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;
    
    //Variable que contendra la consulta
    private static String consulta;
    
    /*
    * Metodo para validar un usuario y contraseña en la base de datos. 
    * Recibe el usuario y contraseña a verificar.
    * Retorna -1 en caso de error, 0 si es usuario, 1 si es administrador.
    */
    public static int getLogin(String user, String pwd)
    {
        int rol = -1;
        consulta = "SELECT rol FROM tbl07_usuario WHERE tx_login = ? AND tx_password = ?";
        
        try
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, user);
            pst.setString(2, pwd);
            rs = pst.executeQuery();
            if(rs.next())
                rol = rs.getInt("rol");
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error en el login D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        return rol;
    }
    
    /*
    * Metodo para agregar un usuario a la base de datos. 
    * Recibe un objeto usuario.
    * Retorna 0 en caso de que el usuario ya exista, 1 en caso de exito y -1 en caso de error.
    */
    public static int registraUsuario(Usuario objUsuario)
    {
        int respuesta = -1;
     
        //Validamos que el usuario no exista
        if(buscarUsuario(objUsuario.getUsuario()) == null)
        {
            consulta = "INSERT INTO tbl07_usuario VALUES (null, ?, ?, ?, ?, ?, 0)";

            try
            {
                con = Conexion.getConexion();
                pst = con.prepareStatement(consulta);
                pst.setString(1, objUsuario.getUsuario());
                pst.setString(2, objUsuario.getPassword());
                pst.setString(3, objUsuario.getNombre());
                pst.setString(4, objUsuario.getApellidoPaterno());
                pst.setString(5, objUsuario.getApellidoMaterno());

                //Ejecutamos la consulta
                pst.execute();

                pst.close();

                respuesta = 1;
            }
            catch(SQLException e){ System.out.println("Error al registrar al usuario D:\n" + e); }
            finally { if(con != null) Conexion.closeConexion(); }
        }
        else
            respuesta = 0;
        return respuesta;
    }
    
    /*
    * Metodo para buscar un usuario dentro de la base de datos.
    * Recibe el nombre de usuario a verificar.
    * Retorna un objeto usuario con los datos del usuario o null en caso de que no haya coincidencia.
    */
    public static Usuario buscarUsuario(String usuario)
    {
        Usuario objUsuario = null;
        consulta = "SELECT nb_usuario, tx_apa, tx_apb FROM tbl07_usuario WHERE tx_login = ?";
        
        try
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            if(rs.next())
            {
                objUsuario = new Usuario();
                objUsuario.setUsuario(usuario);
                objUsuario.setNombre(rs.getString("nb_usuario"));
                objUsuario.setApellidoPaterno(rs.getString("tx_apa"));
                objUsuario.setApellidoMaterno(rs.getString("tx_apb"));
            }
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error en el login D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        return objUsuario;
    }
}
