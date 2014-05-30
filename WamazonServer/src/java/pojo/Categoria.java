package pojo;

public class Categoria 
{
   private int idCategoria;
   private int idPadre;
   private String nombreCategoria;

    public Categoria() 
    {
        this.idCategoria = 0;
        this.idPadre = 0;
        this.nombreCategoria = "";
    }
    
    public Categoria(int idCategoria, String nombreCategoria)
    {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}