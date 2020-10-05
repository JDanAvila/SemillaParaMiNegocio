/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pago_nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoNomina.findAll", query = "SELECT p FROM PagoNomina p")
    , @NamedQuery(name = "PagoNomina.findByEmpleadoCedula", query = "SELECT p FROM PagoNomina p WHERE p.pagoNominaPK.empleadoCedula = :empleadoCedula")
    , @NamedQuery(name = "PagoNomina.findByTiendaId", query = "SELECT p FROM PagoNomina p WHERE p.pagoNominaPK.tiendaId = :tiendaId")
    , @NamedQuery(name = "PagoNomina.findByDiasTrab", query = "SELECT p FROM PagoNomina p WHERE p.diasTrab = :diasTrab")
    , @NamedQuery(name = "PagoNomina.findByAuxTrans", query = "SELECT p FROM PagoNomina p WHERE p.auxTrans = :auxTrans")
    , @NamedQuery(name = "PagoNomina.findByLiquidacion", query = "SELECT p FROM PagoNomina p WHERE p.liquidacion = :liquidacion")
    , @NamedQuery(name = "PagoNomina.findByPension", query = "SELECT p FROM PagoNomina p WHERE p.pension = :pension")
    , @NamedQuery(name = "PagoNomina.findByNetoPagado", query = "SELECT p FROM PagoNomina p WHERE p.netoPagado = :netoPagado")
    , @NamedQuery(name = "PagoNomina.findByFechaPago", query = "SELECT p FROM PagoNomina p WHERE p.fechaPago = :fechaPago")})
public class PagoNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagoNominaPK pagoNominaPK;
    @Basic(optional = false)
    @Column(name = "dias_trab")
    private int diasTrab;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "aux_trans")
    private BigDecimal auxTrans;
    @Basic(optional = false)
    @Column(name = "liquidacion")
    private BigDecimal liquidacion;
    @Basic(optional = false)
    @Column(name = "pension")
    private BigDecimal pension;
    @Basic(optional = false)
    @Column(name = "neto_pagado")
    private BigDecimal netoPagado;
    @Basic(optional = false)
    @Column(name = "fecha_pago")
    private BigDecimal fechaPago;
    @JoinColumn(name = "empleado_cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "tienda_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tienda tienda;

    public PagoNomina() {
    }

    public PagoNomina(PagoNominaPK pagoNominaPK) {
        this.pagoNominaPK = pagoNominaPK;
    }

    public PagoNomina(PagoNominaPK pagoNominaPK, int diasTrab, BigDecimal auxTrans, BigDecimal liquidacion, BigDecimal pension, BigDecimal netoPagado, BigDecimal fechaPago) {
        this.pagoNominaPK = pagoNominaPK;
        this.diasTrab = diasTrab;
        this.auxTrans = auxTrans;
        this.liquidacion = liquidacion;
        this.pension = pension;
        this.netoPagado = netoPagado;
        this.fechaPago = fechaPago;
    }

    public PagoNomina(int empleadoCedula, int tiendaId) {
        this.pagoNominaPK = new PagoNominaPK(empleadoCedula, tiendaId);
    }

    public PagoNominaPK getPagoNominaPK() {
        return pagoNominaPK;
    }

    public void setPagoNominaPK(PagoNominaPK pagoNominaPK) {
        this.pagoNominaPK = pagoNominaPK;
    }

    public int getDiasTrab() {
        return diasTrab;
    }

    public void setDiasTrab(int diasTrab) {
        this.diasTrab = diasTrab;
    }

    public BigDecimal getAuxTrans() {
        return auxTrans;
    }

    public void setAuxTrans(BigDecimal auxTrans) {
        this.auxTrans = auxTrans;
    }

    public BigDecimal getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(BigDecimal liquidacion) {
        this.liquidacion = liquidacion;
    }

    public BigDecimal getPension() {
        return pension;
    }

    public void setPension(BigDecimal pension) {
        this.pension = pension;
    }

    public BigDecimal getNetoPagado() {
        return netoPagado;
    }

    public void setNetoPagado(BigDecimal netoPagado) {
        this.netoPagado = netoPagado;
    }

    public BigDecimal getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(BigDecimal fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
        hash += (pagoNominaPK != null ? pagoNominaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoNomina)) {
            return false;
        }
        PagoNomina other = (PagoNomina) object;
        if ((this.pagoNominaPK == null && other.pagoNominaPK != null) || (this.pagoNominaPK != null && !this.pagoNominaPK.equals(other.pagoNominaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoNomina[ pagoNominaPK=" + pagoNominaPK + " ]";
    }
    
}
