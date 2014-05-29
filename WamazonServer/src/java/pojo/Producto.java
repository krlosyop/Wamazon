package pojo;

public class Producto 
{
    private int idProducto;
    private String categoria;
    private String nombre;
    private double precio;
    private int existencia;
    private String descripcion;
    
    public Producto(){
        idProducto = 0;
        categoria = "";
        nombre = "";
        precio = 0;
        existencia = 0;
        descripcion = "";
    }
    public Producto(int idProducto){
        
       this.idProducto = idProducto; 
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
