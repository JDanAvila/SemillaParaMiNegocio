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

    @Basic(optional = false)
    @Column(name = "empleado")
    private int empleado;
    @Basic(optional = false)
    @Column(name = "tienda")
    private int tienda;

    public PagoNominaPK() {
    }

    public PagoNominaPK(int empleado, int tienda) {
        this.empleado = empleado;
        this.tienda = tienda;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getTienda() {
        return tienda;
    }

    public void setTienda(int tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empleado;
        hash += (int) tienda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoNominaPK)) {
            return false;
        }
        PagoNominaPK other = (PagoNominaPK) object;
        if (this.empleado != other.empleado) {
            return false;
        }
        if (this.tienda != other.tienda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoNominaPK[ empleado=" + empleado + ", tienda=" + tienda + " ]";
    }
    
}
