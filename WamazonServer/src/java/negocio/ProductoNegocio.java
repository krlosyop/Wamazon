package negocio;

import conexionSQL.CategoriaDAO;
import conexionSQL.ProductoDAO;
import java.util.List;
import javax.jws.WebService;
import pojo.Categoria;
import pojo.Producto;

@WebService
public class ProductoNegocio 
{
    /*
    *Método para buscar un producto
    */
    public Producto buscarProducto(String criterio)
    {
        Producto p = ProductoDAO.buscarProducto(criterio);
        return p;
    }
    
    /*
    *Método para registrar un producto
    */
    public boolean registrarProducto(Producto producto)
    {
        boolean respuesta;
        respuesta = ProductoDAO.registrarProducto(producto);
        return respuesta;
    }    
    
    /*
    * Método para recuperar las categorias que hay en la base de datos
    */
    public List<Categoria> getCategorias()
    {
        List<Categoria> respuesta;
        respuesta = CategoriaDAO.getCategorias();
        return respuesta;
    }    
}