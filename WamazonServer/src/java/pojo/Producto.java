package pojo;

public class Producto 
{
    private int idProducto;
    private Categoria categoria;
    private String nombre;
    private double precio;
    private int existencia;
    private String descripcion;
    private Imagen imagen;
    
    public Producto(){
        idProducto = 0;
        categoria = new Categoria();
        nombre = "";
        precio = 0;
        existencia = 0;
        descripcion = "";
        imagen = new Imagen();
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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
    
    public Imagen getImagen() {
        return imagen;
    }
    
    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
