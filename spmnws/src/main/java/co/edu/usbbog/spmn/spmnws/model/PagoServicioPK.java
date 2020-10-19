/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hp
 */
@Embeddable
public class PagoServicioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "tienda")
    private int tienda;
    @Basic(optional = false)
    @Column(name = "servicio")
    private String servicio;

    public PagoServicioPK() {
    }

    public PagoServicioPK(int tienda, String servicio) {
        this.tienda = tienda;
        this.servicio = servicio;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tienda;
        hash += (servicio != null ? servicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoServicioPK)) {
            return false;
        }
        PagoServicioPK other = (PagoServicioPK) object;
        if (this.tienda != other.tienda) {
            return false;
        }
        if ((this.servicio == null && other.servicio != null) || (this.servicio != null && !this.servicio.equals(other.servicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoServicioPK[ tienda=" + tienda + ", servicio=" + servicio + " ]";
    }
    
}
