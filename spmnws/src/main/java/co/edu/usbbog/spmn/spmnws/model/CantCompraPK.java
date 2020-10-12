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
public class CantCompraPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "producto")
    private int producto;
    @Basic(optional = false)
    @Column(name = "recibo")
    private int recibo;

    public CantCompraPK() {
    }

    public CantCompraPK(int producto, int recibo) {
        this.producto = producto;
        this.recibo = recibo;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getRecibo() {
        return recibo;
    }

    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) producto;
        hash += (int) recibo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantCompraPK)) {
            return false;
        }
        CantCompraPK other = (CantCompraPK) object;
        if (this.producto != other.producto) {
            return false;
        }
        if (this.recibo != other.recibo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.CantCompraPK[ producto=" + producto + ", recibo=" + recibo + " ]";
    }
    
}
