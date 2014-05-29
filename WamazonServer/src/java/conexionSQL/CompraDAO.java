/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Producto;

/**
 *
 * @author Larissa
 */
public class CompraDAO {
    //Variables para la conexion con la base de datos
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;
    
    //Variable que contendra la consulta
    private static String consulta;
    
    public static List<Producto> verCarrito(int usuario)
    {
        List <Producto> prod = new ArrayList<Producto>();
        Producto p = new Producto();
       consulta = "";
        try
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setInt(1, usuario);
            rs = pst.executeQuery();
            while(rs.next())
            {
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCategoria(rs.getString("nb_categoria"));
                p.setNombre(rs.getString("nb_producto"));
                p.setPrecio(rs.getDouble("nu_precio"));
                p.setExistencia(rs.getInt("nu_existencia"));
                p.setDescripcion(rs.getString("dx_descripcion"));
                
                prod.add(p);
            }   
                
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error en el login D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
       
        return prod;
    }        
}
