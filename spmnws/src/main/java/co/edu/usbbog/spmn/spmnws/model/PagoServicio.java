/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "pago_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoServicio.findAll", query = "SELECT p FROM PagoServicio p")
    , @NamedQuery(name = "PagoServicio.findByTienda", query = "SELECT p FROM PagoServicio p WHERE p.pagoServicioPK.tienda = :tienda")
    , @NamedQuery(name = "PagoServicio.findByServicio", query = "SELECT p FROM PagoServicio p WHERE p.pagoServicioPK.servicio = :servicio")
    , @NamedQuery(name = "PagoServicio.findByPrecio", query = "SELECT p FROM PagoServicio p WHERE p.precio = :precio")
    , @NamedQuery(name = "PagoServicio.findByFechaLimite", query = "SELECT p FROM PagoServicio p WHERE p.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "PagoServicio.findByFechaPago", query = "SELECT p FROM PagoServicio p WHERE p.fechaPago = :fechaPago")})
public class PagoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagoServicioPK pagoServicioPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "fecha_limite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @JoinColumn(name = "tienda", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tienda tienda1;
    @JoinColumn(name = "servicio", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio1;

    public PagoServicio() {
    }

    public PagoServicio(PagoServicioPK pagoServicioPK) {
        this.pagoServicioPK = pagoServicioPK;
    }

    public PagoServicio(PagoServicioPK pagoServicioPK, BigDecimal precio, Date fechaLimite) {
        this.pagoServicioPK = pagoServicioPK;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
    }

    public PagoServicio(int tienda, int servicio) {
        this.pagoServicioPK = new PagoServicioPK(tienda, servicio);
    }

    public PagoServicioPK getPagoServicioPK() {
        return pagoServicioPK;
    }

    public void setPagoServicioPK(PagoServicioPK pagoServicioPK) {
        this.pagoServicioPK = pagoServicioPK;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Tienda getTienda1() {
        return tienda1;
    }

    public void setTienda1(Tienda tienda1) {
        this.tienda1 = tienda1;
    }

    public Servicio getServicio1() {
        return servicio1;
    }

    public void setServicio1(Servicio servicio1) {
        this.servicio1 = servicio1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagoServicioPK != null ? pagoServicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoServicio)) {
            return false;
        }
        PagoServicio other = (PagoServicio) object;
        if ((this.pagoServicioPK == null && other.pagoServicioPK != null) || (this.pagoServicioPK != null && !this.pagoServicioPK.equals(other.pagoServicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoServicio[ pagoServicioPK=" + pagoServicioPK + " ]";
    }
    
}
