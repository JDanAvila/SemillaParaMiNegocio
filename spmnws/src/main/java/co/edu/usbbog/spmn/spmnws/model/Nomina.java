/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nomina.findAll", query = "SELECT n FROM Nomina n")
    , @NamedQuery(name = "Nomina.findByIdNomina", query = "SELECT n FROM Nomina n WHERE n.idNomina = :idNomina")
    , @NamedQuery(name = "Nomina.findByFecha", query = "SELECT n FROM Nomina n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Nomina.findByNombre", query = "SELECT n FROM Nomina n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "Nomina.findByDiasTrabajados", query = "SELECT n FROM Nomina n WHERE n.diasTrabajados = :diasTrabajados")
    , @NamedQuery(name = "Nomina.findBySueldoBasico", query = "SELECT n FROM Nomina n WHERE n.sueldoBasico = :sueldoBasico")
    , @NamedQuery(name = "Nomina.findByLiquidacionTotal", query = "SELECT n FROM Nomina n WHERE n.liquidacionTotal = :liquidacionTotal")})
public class Nomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idNomina")
    private Integer idNomina;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dias_trabajados")
    private int diasTrabajados;
    @Basic(optional = false)
    @Column(name = "sueldo_basico")
    private int sueldoBasico;
    @Basic(optional = false)
    @Column(name = "liquidacion_total")
    private int liquidacionTotal;
    @JoinColumn(name = "tienda_idTienda", referencedColumnName = "idTienda")
    @ManyToOne(optional = false)
    private Tienda tiendaidTienda;

    public Nomina() {
    }

    public Nomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Nomina(Integer idNomina, Date fecha, String nombre, int diasTrabajados, int sueldoBasico, int liquidacionTotal) {
        this.idNomina = idNomina;
        this.fecha = fecha;
        this.nombre = nombre;
        this.diasTrabajados = diasTrabajados;
        this.sueldoBasico = sueldoBasico;
        this.liquidacionTotal = liquidacionTotal;
    }

    public Integer getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Integer idNomina) {
        this.idNomina = idNomina;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(int sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getLiquidacionTotal() {
        return liquidacionTotal;
    }

    public void setLiquidacionTotal(int liquidacionTotal) {
        this.liquidacionTotal = liquidacionTotal;
    }

    public Tienda getTiendaidTienda() {
        return tiendaidTienda;
    }

    public void setTiendaidTienda(Tienda tiendaidTienda) {
        this.tiendaidTienda = tiendaidTienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNomina != null ? idNomina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nomina)) {
            return false;
        }
        Nomina other = (Nomina) object;
        if ((this.idNomina == null && other.idNomina != null) || (this.idNomina != null && !this.idNomina.equals(other.idNomina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication104.Nomina[ idNomina=" + idNomina + " ]";
    }
    
}
