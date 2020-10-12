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
public class PagoNominaPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "empleado_cedula")
    private int empleadoCedula;
    @Basic(optional = false)
    @Column(name = "tienda_id")
    private int tiendaId;

    public PagoNominaPK() {
    }

    public PagoNominaPK(int empleadoCedula, int tiendaId) {
        this.empleadoCedula = empleadoCedula;
        this.tiendaId = tiendaId;
    }

    public int getEmpleadoCedula() {
        return empleadoCedula;
    }

    public void setEmpleadoCedula(int empleadoCedula) {
        this.empleadoCedula = empleadoCedula;
    }

    public int getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(int tiendaId) {
        this.tiendaId = tiendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empleadoCedula;
        hash += (int) tiendaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoNominaPK)) {
            return false;
        }
        PagoNominaPK other = (PagoNominaPK) object;
        if (this.empleadoCedula != other.empleadoCedula) {
            return false;
        }
        if (this.tiendaId != other.tiendaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoNominaPK[ empleadoCedula=" + empleadoCedula + ", tiendaId=" + tiendaId + " ]";
    }
    
}
