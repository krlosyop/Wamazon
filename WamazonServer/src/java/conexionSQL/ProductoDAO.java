package conexionSQL;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import pojo.Categoria;
import pojo.Producto;

public class ProductoDAO 
{
    //Variables para la conexion con la base de datos
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement pst;

    //Variable que contendra la consulta
    private static String consulta;
    
    /*
     *Método que busca un producto en base al nombre, la categoria o una palabra en su descripción
     *Recibe una cadena de criterio
     *Regresa el producto que cumple con alguno de los criterios
     */
    public static Producto buscarProducto(String criterio) 
    {
        Producto p = new Producto();
        consulta = "SELECT  P.id_producto, P.id_categoria, C.nb_categoria,P.nb_producto, P.nu_precio,P.nu_existencia,P.dx_descripcion  FROM tbl03_producto P JOIN tbl01_categoria C ON P.id_categoria = C.id_categoria  WHERE nb_producto LIKE %?% OR nb_categoria LIKE %?% OR dx_descripcion LIKE %?%";
        try 
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, criterio);
            pst.setString(2, criterio);
            pst.setString(3, criterio);
            rs = pst.executeQuery();
            if (rs.next()) 
            {
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCategoria(new Categoria(rs.getInt("id_categoria"),rs.getString("nb_categoria")));
                p.setNombre(rs.getString("nb_producto"));
                p.setPrecio(rs.getDouble("nu_precio"));
                p.setExistencia(rs.getInt("nu_existencia"));
                p.setDescripcion(rs.getString("dx_descripcion"));
            }

            pst.close();
        } 
        catch(SQLException e){ System.out.println("Error al buscar un producto D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        
        return p;
    }
    /*
     *
     *Método para buscar los productos de una categoria
     *Recibe la categoria
     * Regresa una lista de los objetos incluidos en la categoria
     *
     */

    public static List<Producto> buscarCategoria(String categoria) {
        List<Producto> productos = new ArrayList<Producto>();
        Producto p = new Producto();
        consulta = "SELECT  P.id_producto, P.id_categoria, C.nb_categoria,P.nb_producto, P.nu_precio,P.nu_existencia,P.dx_descripcion FROM tbl03_producto P JOIN tbl01_categoria C ON P.id_categoria = C.id_categoria  WHERE C.nb_categoria LIKE ?%";
        try {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setString(1, categoria);
            rs = pst.executeQuery();
            while (rs.next()) {
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCategoria(new Categoria(rs.getInt("id_categoria"),rs.getString("nb_categoria")));
                p.setNombre(rs.getString("nb_producto"));
                p.setPrecio(rs.getDouble("nu_precio"));
                p.setExistencia(rs.getInt("nu_existencia"));
                p.setDescripcion(rs.getString("dx_descripcion"));

                productos.add(p);
            }

            pst.close();
        } 
        catch(SQLException e){ System.out.println("Error al buscar un los productos de una categoria D:\n" + e); }
        finally { if(con != null) Conexion.closeConexion(); }
        
        return productos;
    }
    
    /*
     *Método que agrega un producto a la base de datos.
     *Recibe un objeto producto.
     *Regresa true en caso de exito o false en caso contrario.
     */
    public static boolean registrarProducto(Producto producto) 
    {
        boolean registrado = false;
        consulta = "INSERT INTO tbl03_producto (id_categoria, nb_producto, nu_precio, nu_existencia, dx_descripcion, bl_fotografia) VALUES (?, ?, ?, ?, ?, ?)";
        try 
        {
            con = Conexion.getConexion();
            pst = con.prepareStatement(consulta);
            pst.setInt(1, producto.getCategoria().getIdCategoria());
            pst.setString(2, producto.getNombre());
            pst.setDouble(3, producto.getPrecio());
            pst.setInt(4, producto.getExistencia());
            pst.setString(5, producto.getDescripcion());
            
            /* Empieza desmadre para el blob*/
            Image image = producto.getImagen().getImagen();
            BufferedImage bImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);  
            Graphics bg = bImage.getGraphics();  
            bg.drawImage(image,0,0,null);  
            bg.dispose();  
            ByteArrayOutputStream out = new ByteArrayOutputStream();  
            ImageIO.write(bImage,"jpeg",out);  
            byte[] buf = out.toByteArray();
            ByteArrayInputStream inStream = new ByteArrayInputStream(buf);
            
            pst.setBinaryStream(6, inStream);
            
            pst.execute();

            pst.close();
            
            registrado = true;
        } 
        catch(SQLException e) {System.out.println("Error al registrar un producto D:\n" + e);} 
        catch (IOException e) {System.out.println("Error al registrar un producto D:\n" + e);}
        finally { if(con != null) Conexion.closeConexion(); }
        
        return registrado;
    }
}