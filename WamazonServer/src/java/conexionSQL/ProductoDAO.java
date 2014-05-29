package conexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Producto;

public class ProductoDAO 
{    
    //Variables para la conexion con la base de datos
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;
    
    //Variable que contendra la consulta
    private static String consulta;
    
    public static Producto buscaProducto(String criterio){
        Producto p = new Producto();
        consulta = "SELECT  P.id_producto, C.nb_categoria,P.nb_producto, P.nu_precio,P.nu_existencia,P.dx_descripcion  FROM tbl03_producto P JOIN tbl01_categoria C ON P.id_categoria = C.id_categoria  WHERE nb_producto LIKE %?% OR nb_categoria LIKE %?%";
        try
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, criterio);
            pst.setString(2, criterio);
            rs = pst.executeQuery();
            if(rs.next())
            {
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCategoria(rs.getString("nb_categoria"));
                p.setNombre(rs.getString("nb_producto"));
                p.setPrecio(rs.getDouble("nu_precio"));
                p.setExistencia(rs.getInt("nu_existencia"));
                p.setDescripcion(rs.getString("dx_descripcion"));
            }   
                
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error en el login D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        return p;
    }
}


