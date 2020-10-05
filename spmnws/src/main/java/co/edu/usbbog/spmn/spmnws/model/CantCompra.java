/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "cant_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CantCompra.findAll", query = "SELECT c FROM CantCompra c")
    , @NamedQuery(name = "CantCompra.findByProducto", query = "SELECT c FROM CantCompra c WHERE c.cantCompraPK.producto = :producto")
    , @NamedQuery(name = "CantCompra.findByRecibo", query = "SELECT c FROM CantCompra c WHERE c.cantCompraPK.recibo = :recibo")
    , @NamedQuery(name = "CantCompra.findByCantidad", query = "SELECT c FROM CantCompra c WHERE c.cantidad = :cantidad")})
public class CantCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantCompraPK cantCompraPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "producto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;
    @JoinColumn(name = "recibo", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recibo recibo1;

    public CantCompra() {
    }

    public CantCompra(CantCompraPK cantCompraPK) {
        this.cantCompraPK = cantCompraPK;
    }

    public CantCompra(CantCompraPK cantCompraPK, int cantidad) {
        this.cantCompraPK = cantCompraPK;
        this.cantidad = cantidad;
    }

    public CantCompra(int producto, int recibo) {
        this.cantCompraPK = new CantCompraPK(producto, recibo);
    }

    public CantCompraPK getCantCompraPK() {
        return cantCompraPK;
    }

    public void setCantCompraPK(CantCompraPK cantCompraPK) {
        this.cantCompraPK = cantCompraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Recibo getRecibo1() {
        return recibo1;
    }

    public void setRecibo1(Recibo recibo1) {
        this.recibo1 = recibo1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantCompraPK != null ? cantCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantCompra)) {
            return false;
        }
        CantCompra other = (CantCompra) object;
        if ((this.cantCompraPK == null && other.cantCompraPK != null) || (this.cantCompraPK != null && !this.cantCompraPK.equals(other.cantCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.CantCompra[ cantCompraPK=" + cantCompraPK + " ]";
    }
    
}
