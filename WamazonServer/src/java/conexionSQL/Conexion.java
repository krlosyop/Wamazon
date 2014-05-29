package conexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static Connection con = null;
    private static final String BD = "tienda";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BD;
    private static final String usuario = "root";
    private static final String contrasena = "pass";
    
    public static Connection getConexion()
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(URL, usuario, contrasena);
        }
        catch(SQLException e){ System.out.println("Error al abrir la conexion D:\n" + e); }
        return con;
    }
    
    public static void closeConexion()
    {
        try
        {
            if(con != null)
                con.close(); 
        }
        catch(SQLException e){ System.out.println("Error al cerrar la conexion D:\n" + e); }
    }
}