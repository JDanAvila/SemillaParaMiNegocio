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
@Table(name = "recibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recibo.findAll", query = "SELECT r FROM Recibo r")
    , @NamedQuery(name = "Recibo.findById", query = "SELECT r FROM Recibo r WHERE r.id = :id")
    , @NamedQuery(name = "Recibo.findByFecha", query = "SELECT r FROM Recibo r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Recibo.findByTotalRecibo", query = "SELECT r FROM Recibo r WHERE r.totalRecibo = :totalRecibo")
    , @NamedQuery(name = "Recibo.findByDescripcion", query = "SELECT r FROM Recibo r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Recibo.findByEstado", query = "SELECT r FROM Recibo r WHERE r.estado = :estado")
    , @NamedQuery(name = "Recibo.findByFechaPago", query = "SELECT r FROM Recibo r WHERE r.fechaPago = :fechaPago")})
public class Recibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "totalRecibo")
    private BigDecimal totalRecibo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @JoinColumn(name = "proveedor", referencedColumnName = "nit")
    @ManyToOne(optional = false)
    private Proveedor proveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recibo1")
    private Collection<CantCompra> cantCompraCollection;

    public Recibo() {
    }

    public Recibo(Integer id) {
        this.id = id;
    }

    public Recibo(Integer id, Date fecha, BigDecimal totalRecibo, String descripcion, String estado, Date fechaPago) {
        this.id = id;
        this.fecha = fecha;
        this.totalRecibo = totalRecibo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaPago = fechaPago;
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

    public BigDecimal getTotalRecibo() {
        return totalRecibo;
    }

    public void setTotalRecibo(BigDecimal totalRecibo) {
        this.totalRecibo = totalRecibo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @XmlTransient
    public Collection<CantCompra> getCantCompraCollection() {
        return cantCompraCollection;
    }

    public void setCantCompraCollection(Collection<CantCompra> cantCompraCollection) {
        this.cantCompraCollection = cantCompraCollection;
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
        if (!(object instanceof Recibo)) {
            return false;
        }
        Recibo other = (Recibo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Recibo[ id=" + id + " ]";
    }
    
}
