package conexionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Categoria;

public class CategoriaDAO 
{
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;

    //Variable que contendra la consulta
    private static String consulta;

    public static int getCategoria(String nombre) 
    {
        int id = 0;
        consulta = "SELECT id_categoria FROM categoria WHERE nb_categoria ?";
        
        try 
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            if (rs.next())
                id = rs.getInt("id_categoria");
            pst.close();
        }
        catch(SQLException e){ System.out.println("Error al buscar la categoria D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        
        return id;
    }
    /*
     *Método que devuelve las subcategorias de un padre
     *Recibe el nombre del padre
     */

    public static List<Categoria> subcategoria(String categoria) 
    {
        List<Categoria> cat = new ArrayList<Categoria>();
        Categoria c = new Categoria();
        int id = -1;
        consulta = "SELECT  id_categoria, nb_categoria FROM tbl01_categoria WHERE id_padre ?";
        try 
        {
            id = getCategoria(categoria);
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) 
            {
                c.setIdCategoria(rs.getInt("id_categoria"));
                c.setCategoria(rs.getString("nb_categoria"));
                cat.add(c);
            }

            pst.close();
        }
        catch(SQLException e){ System.out.println("Error al buscar la subcategoria D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        
        return cat;
    }
}