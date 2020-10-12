/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hp
 */
@Embeddable
public class InventarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "producto")
    private int producto;
    @Basic(optional = false)
    @Column(name = "tienda")
    private int tienda;

    public InventarioPK() {
    }

    public InventarioPK(int producto, int tienda) {
        this.producto = producto;
        this.tienda = tienda;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) producto;
        hash += (int) tienda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.producto != other.producto) {
            return false;
        }
        if (this.tienda != other.tienda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.InventarioPK[ producto=" + producto + ", tienda=" + tienda + " ]";
    }
    
}
