/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCedula", query = "SELECT e FROM Empleado e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Empleado.findBySueldoBasico", query = "SELECT e FROM Empleado e WHERE e.sueldoBasico = :sueldoBasico")
    , @NamedQuery(name = "Empleado.findByArl", query = "SELECT e FROM Empleado e WHERE e.arl = :arl")
    , @NamedQuery(name = "Empleado.findByEps", query = "SELECT e FROM Empleado e WHERE e.eps = :eps")
    , @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Empleado.findByFechaSalida", query = "SELECT e FROM Empleado e WHERE e.fechaSalida = :fechaSalida")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private Integer cedula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "sueldo_basico")
    private BigDecimal sueldoBasico;
    @Basic(optional = false)
    @Column(name = "arl")
    private BigDecimal arl;
    @Basic(optional = false)
    @Column(name = "eps")
    private BigDecimal eps;
    @Column(name = "fecha_ingreso", columnDefinition = "DATE", nullable = false)
    private LocalDate fechaIngreso;
    @Column(name = "fecha_salida", columnDefinition = "DATE", nullable = false)
    private LocalDate fechaSalida;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<PagoNomina> pagoNominaCollection;

    public Empleado() {
    }

    public Empleado(Integer cedula) {
        this.cedula = cedula;
    }

    public Empleado(Integer cedula, BigDecimal sueldoBasico, BigDecimal arl, BigDecimal eps, LocalDate fechaIngreso) {
        this.cedula = cedula;
        this.sueldoBasico = sueldoBasico;
        this.arl = arl;
        this.eps = eps;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(BigDecimal sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public BigDecimal getArl() {
        return arl;
    }

    public void setArl(BigDecimal arl) {
        this.arl = arl;
    }

    public BigDecimal getEps() {
        return eps;
    }

    public void setEps(BigDecimal eps) {
        this.eps = eps;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<PagoNomina> getPagoNominaCollection() {
        return pagoNominaCollection;
    }

    public void setPagoNominaCollection(Collection<PagoNomina> pagoNominaCollection) {
        this.pagoNominaCollection = pagoNominaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Empleado[ cedula=" + cedula + " ]";
    }
    
}
