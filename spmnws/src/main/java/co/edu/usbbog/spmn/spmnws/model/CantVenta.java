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
@Table(name = "cant_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CantVenta.findAll", query = "SELECT c FROM CantVenta c")
    , @NamedQuery(name = "CantVenta.findByFacturaVenta", query = "SELECT c FROM CantVenta c WHERE c.cantVentaPK.facturaVenta = :facturaVenta")
    , @NamedQuery(name = "CantVenta.findByProducto", query = "SELECT c FROM CantVenta c WHERE c.cantVentaPK.producto = :producto")
    , @NamedQuery(name = "CantVenta.findByCantidad", query = "SELECT c FROM CantVenta c WHERE c.cantidad = :cantidad")})
public class CantVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantVentaPK cantVentaPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "factura_venta", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacturaVenta facturaVenta1;
    @JoinColumn(name = "producto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto1;

    public CantVenta() {
    }

    public CantVenta(CantVentaPK cantVentaPK) {
        this.cantVentaPK = cantVentaPK;
    }

    public CantVenta(CantVentaPK cantVentaPK, int cantidad) {
        this.cantVentaPK = cantVentaPK;
        this.cantidad = cantidad;
    }

    public CantVenta(int facturaVenta, int producto) {
        this.cantVentaPK = new CantVentaPK(facturaVenta, producto);
    }

    public CantVentaPK getCantVentaPK() {
        return cantVentaPK;
    }

    public void setCantVentaPK(CantVentaPK cantVentaPK) {
        this.cantVentaPK = cantVentaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public FacturaVenta getFacturaVenta1() {
        return facturaVenta1;
    }

    public void setFacturaVenta1(FacturaVenta facturaVenta1) {
        this.facturaVenta1 = facturaVenta1;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantVentaPK != null ? cantVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantVenta)) {
            return false;
        }
        CantVenta other = (CantVenta) object;
        if ((this.cantVentaPK == null && other.cantVentaPK != null) || (this.cantVentaPK != null && !this.cantVentaPK.equals(other.cantVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.CantVenta[ cantVentaPK=" + cantVentaPK + " ]";
    }
    
}
