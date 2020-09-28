/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */
@Entity
@Table(name = "factura_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCompra.findAll", query = "SELECT f FROM FacturaCompra f")
    , @NamedQuery(name = "FacturaCompra.findByIdFactura", query = "SELECT f FROM FacturaCompra f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "FacturaCompra.findByFdescripcion", query = "SELECT f FROM FacturaCompra f WHERE f.fdescripcion = :fdescripcion")
    , @NamedQuery(name = "FacturaCompra.findByFfecha", query = "SELECT f FROM FacturaCompra f WHERE f.ffecha = :ffecha")})
public class FacturaCompra implements Serializable {

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
    @JoinColumns({
        @JoinColumn(name = "inventario_Tienda_idTienda", referencedColumnName = "Tienda_idTienda")
        , @JoinColumn(name = "inventario_Producto_idProducto", referencedColumnName = "Producto_idProducto")})
    @ManyToOne(optional = false)
    private Inventario inventario;
    @JoinColumn(name = "proveedor_nit", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Proveedor proveedorNit;

    public FacturaCompra() {
    }

    public FacturaCompra(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaCompra(Integer idFactura, String fdescripcion, String ffecha) {
        this.idFactura = idFactura;
        this.fdescripcion = fdescripcion;
        this.ffecha = ffecha;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Proveedor getProveedorNit() {
        return proveedorNit;
    }

    public void setProveedorNit(Proveedor proveedorNit) {
        this.proveedorNit = proveedorNit;
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
        if (!(object instanceof FacturaCompra)) {
            return false;
        }
        FacturaCompra other = (FacturaCompra) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication104.FacturaCompra[ idFactura=" + idFactura + " ]";
    }
    
}
