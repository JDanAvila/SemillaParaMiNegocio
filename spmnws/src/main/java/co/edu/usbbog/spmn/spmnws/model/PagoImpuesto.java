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
@Table(name = "pago_impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoImpuesto.findAll", query = "SELECT p FROM PagoImpuesto p")
    , @NamedQuery(name = "PagoImpuesto.findByImpuesto", query = "SELECT p FROM PagoImpuesto p WHERE p.pagoImpuestoPK.impuesto = :impuesto")
    , @NamedQuery(name = "PagoImpuesto.findByTienda", query = "SELECT p FROM PagoImpuesto p WHERE p.pagoImpuestoPK.tienda = :tienda")
    , @NamedQuery(name = "PagoImpuesto.findByCosto", query = "SELECT p FROM PagoImpuesto p WHERE p.costo = :costo")
    , @NamedQuery(name = "PagoImpuesto.findByFechaLimite", query = "SELECT p FROM PagoImpuesto p WHERE p.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "PagoImpuesto.findByFechaPago", query = "SELECT p FROM PagoImpuesto p WHERE p.fechaPago = :fechaPago")})
public class PagoImpuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagoImpuestoPK pagoImpuestoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "fechaLimite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Column(name = "fechaPago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @JoinColumn(name = "tienda", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tienda tienda1;
    @JoinColumn(name = "impuesto", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Impuesto impuesto1;

    public PagoImpuesto() {
    }

    public PagoImpuesto(PagoImpuestoPK pagoImpuestoPK) {
        this.pagoImpuestoPK = pagoImpuestoPK;
    }

    public PagoImpuesto(PagoImpuestoPK pagoImpuestoPK, BigDecimal costo, Date fechaLimite) {
        this.pagoImpuestoPK = pagoImpuestoPK;
        this.costo = costo;
        this.fechaLimite = fechaLimite;
    }

    public PagoImpuesto(int impuesto, int tienda) {
        this.pagoImpuestoPK = new PagoImpuestoPK(impuesto, tienda);
    }

    public PagoImpuestoPK getPagoImpuestoPK() {
        return pagoImpuestoPK;
    }

    public void setPagoImpuestoPK(PagoImpuestoPK pagoImpuestoPK) {
        this.pagoImpuestoPK = pagoImpuestoPK;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
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

    public Impuesto getImpuesto1() {
        return impuesto1;
    }

    public void setImpuesto1(Impuesto impuesto1) {
        this.impuesto1 = impuesto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagoImpuestoPK != null ? pagoImpuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoImpuesto)) {
            return false;
        }
        PagoImpuesto other = (PagoImpuesto) object;
        if ((this.pagoImpuestoPK == null && other.pagoImpuestoPK != null) || (this.pagoImpuestoPK != null && !this.pagoImpuestoPK.equals(other.pagoImpuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoImpuesto[ pagoImpuestoPK=" + pagoImpuestoPK + " ]";
    }
    
}
