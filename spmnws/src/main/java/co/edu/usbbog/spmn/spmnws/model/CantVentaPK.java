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
public class CantVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "factura")
    private int factura;
    @Basic(optional = false)
    @Column(name = "producto")
    private int producto;

    public CantVentaPK() {
    }

    public CantVentaPK(int factura, int producto) {
        this.factura = factura;
        this.producto = producto;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) factura;
        hash += (int) producto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantVentaPK)) {
            return false;
        }
        CantVentaPK other = (CantVentaPK) object;
        if (this.factura != other.factura) {
            return false;
        }
        if (this.producto != other.producto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.CantVentaPK[ factura=" + factura + ", producto=" + producto + " ]";
    }
    
}
