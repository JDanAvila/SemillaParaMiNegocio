/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByTiendaidTienda", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.tiendaidTienda = :tiendaidTienda")
    , @NamedQuery(name = "Inventario.findByProductoidProducto", query = "SELECT i FROM Inventario i WHERE i.inventarioPK.productoidProducto = :productoidProducto")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioPK inventarioPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private Collection<FacturaCompra> facturaCompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventario")
    private Collection<Reportes> reportesCollection;
    @JoinColumn(name = "Producto_idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "Tienda_idTienda", referencedColumnName = "idTienda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tienda tienda;

    public Inventario() {
    }

    public Inventario(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    public Inventario(int tiendaidTienda, int productoidProducto) {
        this.inventarioPK = new InventarioPK(tiendaidTienda, productoidProducto);
    }

    public InventarioPK getInventarioPK() {
        return inventarioPK;
    }

    public void setInventarioPK(InventarioPK inventarioPK) {
        this.inventarioPK = inventarioPK;
    }

    @XmlTransient
    public Collection<FacturaCompra> getFacturaCompraCollection() {
        return facturaCompraCollection;
    }

    public void setFacturaCompraCollection(Collection<FacturaCompra> facturaCompraCollection) {
        this.facturaCompraCollection = facturaCompraCollection;
    }

    @XmlTransient
    public Collection<Reportes> getReportesCollection() {
        return reportesCollection;
    }

    public void setReportesCollection(Collection<Reportes> reportesCollection) {
        this.reportesCollection = reportesCollection;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioPK != null ? inventarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.inventarioPK == null && other.inventarioPK != null) || (this.inventarioPK != null && !this.inventarioPK.equals(other.inventarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication104.Inventario[ inventarioPK=" + inventarioPK + " ]";
    }
    
}
