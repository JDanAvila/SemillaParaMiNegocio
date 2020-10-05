/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tienda.findAll", query = "SELECT t FROM Tienda t")
    , @NamedQuery(name = "Tienda.findById", query = "SELECT t FROM Tienda t WHERE t.id = :id")
    , @NamedQuery(name = "Tienda.findByNombre", query = "SELECT t FROM Tienda t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tienda.findByDireccion", query = "SELECT t FROM Tienda t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Tienda.findByTelefono", query = "SELECT t FROM Tienda t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Tienda.findByCajaMenor", query = "SELECT t FROM Tienda t WHERE t.cajaMenor = :cajaMenor")
    , @NamedQuery(name = "Tienda.findByDeudas", query = "SELECT t FROM Tienda t WHERE t.deudas = :deudas")
    , @NamedQuery(name = "Tienda.findBySaldo", query = "SELECT t FROM Tienda t WHERE t.saldo = :saldo")})
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "caja_menor")
    private BigDecimal cajaMenor;
    @Basic(optional = false)
    @Column(name = "deudas")
    private BigDecimal deudas;
    @Basic(optional = false)
    @Column(name = "saldo")
    private BigDecimal saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda1")
    private Collection<PagoServicio> pagoServicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda")
    private Collection<PagoNomina> pagoNominaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda1")
    private Collection<Inventario> inventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda1")
    private Collection<PagoImpuesto> pagoImpuestoCollection;

    public Tienda() {
    }

    public Tienda(Integer id) {
        this.id = id;
    }

    public Tienda(Integer id, String nombre, String direccion, int telefono, BigDecimal cajaMenor, BigDecimal deudas, BigDecimal saldo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cajaMenor = cajaMenor;
        this.deudas = deudas;
        this.saldo = saldo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getCajaMenor() {
        return cajaMenor;
    }

    public void setCajaMenor(BigDecimal cajaMenor) {
        this.cajaMenor = cajaMenor;
    }

    public BigDecimal getDeudas() {
        return deudas;
    }

    public void setDeudas(BigDecimal deudas) {
        this.deudas = deudas;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<PagoServicio> getPagoServicioCollection() {
        return pagoServicioCollection;
    }

    public void setPagoServicioCollection(Collection<PagoServicio> pagoServicioCollection) {
        this.pagoServicioCollection = pagoServicioCollection;
    }

    @XmlTransient
    public Collection<PagoNomina> getPagoNominaCollection() {
        return pagoNominaCollection;
    }

    public void setPagoNominaCollection(Collection<PagoNomina> pagoNominaCollection) {
        this.pagoNominaCollection = pagoNominaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
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
        if (!(object instanceof Tienda)) {
            return false;
        }
        Tienda other = (Tienda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.Tienda[ id=" + id + " ]";
    }
    
}
