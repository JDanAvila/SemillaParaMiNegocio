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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "Tienda_idTienda")
    private int tiendaidTienda;
    @Basic(optional = false)
    @Column(name = "Producto_idProducto")
    private int productoidProducto;

    public InventarioPK() {
    }

    public InventarioPK(int tiendaidTienda, int productoidProducto) {
        this.tiendaidTienda = tiendaidTienda;
        this.productoidProducto = productoidProducto;
    }

    public int getTiendaidTienda() {
        return tiendaidTienda;
    }

    public void setTiendaidTienda(int tiendaidTienda) {
        this.tiendaidTienda = tiendaidTienda;
    }

    public int getProductoidProducto() {
        return productoidProducto;
    }

    public void setProductoidProducto(int productoidProducto) {
        this.productoidProducto = productoidProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tiendaidTienda;
        hash += (int) productoidProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioPK)) {
            return false;
        }
        InventarioPK other = (InventarioPK) object;
        if (this.tiendaidTienda != other.tiendaidTienda) {
            return false;
        }
        if (this.productoidProducto != other.productoidProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.InventarioPK[ tiendaidTienda=" + tiendaidTienda + ", productoidProducto=" + productoidProducto + " ]";
    }
    
}
