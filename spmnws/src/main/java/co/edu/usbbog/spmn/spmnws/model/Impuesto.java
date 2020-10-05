/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i")
    , @NamedQuery(name = "Impuesto.findById", query = "SELECT i FROM Impuesto i WHERE i.id = :id")
    , @NamedQuery(name = "Impuesto.findByNombre", query = "SELECT i FROM Impuesto i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Impuesto.findByDescripcion", query = "SELECT i FROM Impuesto i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Impuesto.findByEntidad", query = "SELECT i FROM Impuesto i WHERE i.entidad = :entidad")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "entidad")
    private String entidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impuesto1")
    private Collection<PagoImpuesto> pagoImpuestoCollection;

    public Impuesto() {
    }

    public Impuesto(Integer id) {
        this.id = id;
    }

    public Impuesto(Integer id, String nombre, String descripcion, String entidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.entidad = entidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @XmlTransient
    public Collection<PagoImpuesto> getPagoImpuestoCollection() {
        return pagoImpuestoCollection;
    }

    public void setPagoImpuestoCollection(Collection<PagoImpuesto> pagoImpuestoCollection) {
        this.pagoImpuestoCollection = pagoImpuestoCollection;
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
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Impuesto[ id=" + id + " ]";
    }
    
}
