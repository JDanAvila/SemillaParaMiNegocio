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
import javax.persistence.JoinColumns;
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
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")
    , @NamedQuery(name = "Reporte.findByIdReportes", query = "SELECT r FROM Reporte r WHERE r.idReportes = :idReportes")
    , @NamedQuery(name = "Reporte.findByDescripcion", query = "SELECT r FROM Reporte r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Reporte.findByFechaInicial", query = "SELECT r FROM Reporte r WHERE r.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "Reporte.findByCantidadTotal", query = "SELECT r FROM Reporte r WHERE r.cantidadTotal = :cantidadTotal")
    , @NamedQuery(name = "Reporte.findByCantidadEspecifica", query = "SELECT r FROM Reporte r WHERE r.cantidadEspecifica = :cantidadEspecifica")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idReportes")
    private Integer idReportes;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Basic(optional = false)
    @Column(name = "cantidad_total")
    private int cantidadTotal;
    @Basic(optional = false)
    @Column(name = "cantidad_especifica")
    private int cantidadEspecifica;
    @JoinColumns({
        @JoinColumn(name = "inventario_Tienda_idTienda", referencedColumnName = "Tienda_idTienda")
        , @JoinColumn(name = "inventario_Producto_idProducto", referencedColumnName = "Producto_idProducto")})
    @ManyToOne(optional = false)
    private Inventario inventario;

    public Reporte() {
    }

    public Reporte(Integer idReportes) {
        this.idReportes = idReportes;
    }

    public Reporte(Integer idReportes, String descripcion, Date fechaInicial, int cantidadTotal, int cantidadEspecifica) {
        this.idReportes = idReportes;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.cantidadTotal = cantidadTotal;
        this.cantidadEspecifica = cantidadEspecifica;
    }

    public Integer getIdReportes() {
        return idReportes;
    }

    public void setIdReportes(Integer idReportes) {
        this.idReportes = idReportes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getCantidadEspecifica() {
        return cantidadEspecifica;
    }

    public void setCantidadEspecifica(int cantidadEspecifica) {
        this.cantidadEspecifica = cantidadEspecifica;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReportes != null ? idReportes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idReportes == null && other.idReportes != null) || (this.idReportes != null && !this.idReportes.equals(other.idReportes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Reporte[ idReportes=" + idReportes + " ]";
    }
    
}
