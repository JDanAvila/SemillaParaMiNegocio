/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "factura_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaVenta.findAll", query = "SELECT f FROM FacturaVenta f")
    , @NamedQuery(name = "FacturaVenta.findByIdFactura", query = "SELECT f FROM FacturaVenta f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "FacturaVenta.findByFdescripcion", query = "SELECT f FROM FacturaVenta f WHERE f.fdescripcion = :fdescripcion")
    , @NamedQuery(name = "FacturaVenta.findByFfecha", query = "SELECT f FROM FacturaVenta f WHERE f.ffecha = :ffecha")
    , @NamedQuery(name = "FacturaVenta.findByCantidad", query = "SELECT f FROM FacturaVenta f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "FacturaVenta.findByTotal", query = "SELECT f FROM FacturaVenta f WHERE f.total = :total")})
public class FacturaVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "F_descripcion")
    private String fdescripcion;
    @Basic(optional = false)
    @Column(name = "F_fecha")
    private String ffecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @JoinTable(name = "factura_has_producto", joinColumns = {
        @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura")}, inverseJoinColumns = {
        @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto")})
    @ManyToMany
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "Usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaVenta(Integer idFactura, String fdescripcion, String ffecha, int cantidad, int total) {
        this.idFactura = idFactura;
        this.fdescripcion = fdescripcion;
        this.ffecha = ffecha;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getFdescripcion() {
        return fdescripcion;
    }

    public void setFdescripcion(String fdescripcion) {
        this.fdescripcion = fdescripcion;
    }

    public String getFfecha() {
        return ffecha;
    }

    public void setFfecha(String ffecha) {
        this.ffecha = ffecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.FacturaVenta[ idFactura=" + idFactura + " ]";
    }
    
}
