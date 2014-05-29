package negocio;

import conexionSQL.ProductoDAO;
import javax.jws.WebService;
import pojo.Producto;

@WebService
public class ProductoNegocio 
{
    /*
    *Método para buscar un producto
    */
    public Producto busqueda(String criterio)
    {
        Producto p = ProductoDAO.buscaProducto(criterio);
        return p;
    }
    
}