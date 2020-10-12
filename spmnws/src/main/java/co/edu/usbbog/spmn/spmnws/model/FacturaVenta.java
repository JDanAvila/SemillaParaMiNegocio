/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "FacturaVenta.findById", query = "SELECT f FROM FacturaVenta f WHERE f.id = :id")
    , @NamedQuery(name = "FacturaVenta.findByFecha", query = "SELECT f FROM FacturaVenta f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "FacturaVenta.findByDescripcion", query = "SELECT f FROM FacturaVenta f WHERE f.descripcion = :descripcion")
    , @NamedQuery(name = "FacturaVenta.findByTotalBruto", query = "SELECT f FROM FacturaVenta f WHERE f.totalBruto = :totalBruto")
    , @NamedQuery(name = "FacturaVenta.findByImpuestos", query = "SELECT f FROM FacturaVenta f WHERE f.impuestos = :impuestos")
    , @NamedQuery(name = "FacturaVenta.findByTotalPagar", query = "SELECT f FROM FacturaVenta f WHERE f.totalPagar = :totalPagar")})
public class FacturaVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_bruto")
    private BigDecimal totalBruto;
    @Basic(optional = false)
    @Column(name = "impuestos")
    private BigDecimal impuestos;
    @Basic(optional = false)
    @Column(name = "total_pagar")
    private BigDecimal totalPagar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaVenta1")
    private Collection<CantVenta> cantVentaCollection;
    @JoinColumn(name = "cliente", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuario cliente;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer id) {
        this.id = id;
    }

    public FacturaVenta(Integer id, Date fecha, String descripcion, BigDecimal totalBruto, BigDecimal impuestos, BigDecimal totalPagar) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.totalBruto = totalBruto;
        this.impuestos = impuestos;
        this.totalPagar = totalPagar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(BigDecimal totalBruto) {
        this.totalBruto = totalBruto;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    @XmlTransient
    public Collection<CantVenta> getCantVentaCollection() {
        return cantVentaCollection;
    }

    public void setCantVentaCollection(Collection<CantVenta> cantVentaCollection) {
        this.cantVentaCollection = cantVentaCollection;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.FacturaVenta[ id=" + id + " ]";
    }
    
}
