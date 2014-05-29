/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pojo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Larissa
 */
public class Compra {
    private int idCompra;
    private int usuario;
    private Date fecha;

    public Compra() {
        this.idCompra = 0;
        this.usuario = 0;
        this.fecha = null;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}

