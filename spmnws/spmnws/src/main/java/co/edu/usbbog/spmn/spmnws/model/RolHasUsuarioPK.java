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
public class RolHasUsuarioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "rol_idRol")
    private int rolidRol;
    @Basic(optional = false)
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;

    public RolHasUsuarioPK() {
    }

    public RolHasUsuarioPK(int rolidRol, int usuarioidUsuario) {
        this.rolidRol = rolidRol;
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getRolidRol() {
        return rolidRol;
    }

    public void setRolidRol(int rolidRol) {
        this.rolidRol = rolidRol;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolidRol;
        hash += (int) usuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasUsuarioPK)) {
            return false;
        }
        RolHasUsuarioPK other = (RolHasUsuarioPK) object;
        if (this.rolidRol != other.rolidRol) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.RolHasUsuarioPK[ rolidRol=" + rolidRol + ", usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
}
