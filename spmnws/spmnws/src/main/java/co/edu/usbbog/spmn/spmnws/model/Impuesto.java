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
@Table(name = "impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i")
    , @NamedQuery(name = "Impuesto.findByIdIimpuestos", query = "SELECT i FROM Impuesto i WHERE i.idIimpuestos = :idIimpuestos")
    , @NamedQuery(name = "Impuesto.findByNombre", query = "SELECT i FROM Impuesto i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Impuesto.findByDescripcion", query = "SELECT i FROM Impuesto i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Impuesto.findByCosto", query = "SELECT i FROM Impuesto i WHERE i.costo = :costo")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idIimpuestos")
    private Integer idIimpuestos;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "costo")
    private int costo;
    @JoinColumn(name = "Tienda_idTienda", referencedColumnName = "idTienda")
    @ManyToOne(optional = false)
    private Tienda tiendaidTienda;

    public Impuesto() {
    }

    public Impuesto(Integer idIimpuestos) {
        this.idIimpuestos = idIimpuestos;
    }

    public Impuesto(Integer idIimpuestos, String nombre, String descripcion, int costo) {
        this.idIimpuestos = idIimpuestos;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Integer getIdIimpuestos() {
        return idIimpuestos;
    }

    public void setIdIimpuestos(Integer idIimpuestos) {
        this.idIimpuestos = idIimpuestos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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
        hash += (idIimpuestos != null ? idIimpuestos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.idIimpuestos == null && other.idIimpuestos != null) || (this.idIimpuestos != null && !this.idIimpuestos.equals(other.idIimpuestos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Impuesto[ idIimpuestos=" + idIimpuestos + " ]";
    }
    
}
