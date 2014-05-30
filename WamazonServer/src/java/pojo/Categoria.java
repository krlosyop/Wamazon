package pojo;

public class Categoria 
{
   private int idCategoria;
   private int idPadre;
   private String categoria;

    public Categoria() 
    {
        this.idCategoria = 0;
        this.idPadre = 0;
        this.categoria = "";
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}