package pojo;

public class Usuario 
{
    private String usuario;
    private String password;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    
    public Usuario()
    {
        usuario = "";
        password = "";
        nombre = "";
        apellidoPaterno = "";
        apellidoMaterno = "";
    }
    
    public Usuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }    
    
    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }
}
