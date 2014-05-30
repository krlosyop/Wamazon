package conexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Producto;

public class CompraDAO 
{
    //Variables para la conexion con la base de datos
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;
    
    //Variable que contendra la consulta
    private static String consulta;
    
    public static List<Producto> verCarrito(int usuario) 
    {
        List<Producto> prod = new ArrayList<Producto>();
        Producto p = new Producto();
        consulta = "SELECT  P.id_producto,P.nb_producto, P.nu_precio,C.cantidad"
                + "FROM tbl03_producto P "
                + "JOIN tbl06_producto_compra PC ON P.id_producto = PC.id_producto "
                + "JOIN tbl05_compra C ON PC.id_compra = C.id_compra "
                + "JOIN tbl07_usuario  U ON C.id_usuario = U.id_usuario "
                + "WHERE U.id_usuario ? and C.fh_compra ?";
        try
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setInt(1, usuario);
            rs = pst.executeQuery();
            while(rs.next())
            {
                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nb_producto"));
                p.setPrecio(rs.getDouble("nu_precio"));
                p.setExistencia(rs.getInt("cantidad"));
                prod.add(p);
            }
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error al ver el carrito D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
       
        return prod;
    }
}