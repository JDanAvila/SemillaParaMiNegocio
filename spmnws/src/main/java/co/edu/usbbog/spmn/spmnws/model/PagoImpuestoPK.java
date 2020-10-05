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
public class PagoImpuestoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "impuesto")
    private int impuesto;
    @Basic(optional = false)
    @Column(name = "tienda")
    private int tienda;

    public PagoImpuestoPK() {
    }

    public PagoImpuestoPK(int impuesto, int tienda) {
        this.impuesto = impuesto;
        this.tienda = tienda;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
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
        hash += (int) impuesto;
        hash += (int) tienda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoImpuestoPK)) {
            return false;
        }
        PagoImpuestoPK other = (PagoImpuestoPK) object;
        if (this.impuesto != other.impuesto) {
            return false;
        }
        if (this.tienda != other.tienda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.PagoImpuestoPK[ impuesto=" + impuesto + ", tienda=" + tienda + " ]";
    }
    
}
