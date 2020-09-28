/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usbbog.spmn.spmnws.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "rol_has_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolHasUsuario.findAll", query = "SELECT r FROM RolHasUsuario r")
    , @NamedQuery(name = "RolHasUsuario.findByRolidRol", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.rolidRol = :rolidRol")
    , @NamedQuery(name = "RolHasUsuario.findByUsuarioidUsuario", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.usuarioidUsuario = :usuarioidUsuario")
    , @NamedQuery(name = "RolHasUsuario.findByRolIdRol", query = "SELECT r FROM RolHasUsuario r WHERE r.rolIdRol = :rolIdRol")
    , @NamedQuery(name = "RolHasUsuario.findByUsuarioIdUsuario", query = "SELECT r FROM RolHasUsuario r WHERE r.usuarioIdUsuario = :usuarioIdUsuario")})
public class RolHasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolHasUsuarioPK rolHasUsuarioPK;
    @Basic(optional = false)
    @Column(name = "rol_id_rol")
    private int rolIdRol;
    @Basic(optional = false)
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @JoinColumn(name = "rol_idRol", referencedColumnName = "idRol", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public RolHasUsuario() {
    }

    public RolHasUsuario(RolHasUsuarioPK rolHasUsuarioPK) {
        this.rolHasUsuarioPK = rolHasUsuarioPK;
    }

    public RolHasUsuario(RolHasUsuarioPK rolHasUsuarioPK, int rolIdRol, int usuarioIdUsuario) {
        this.rolHasUsuarioPK = rolHasUsuarioPK;
        this.rolIdRol = rolIdRol;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public RolHasUsuario(int rolidRol, int usuarioidUsuario) {
        this.rolHasUsuarioPK = new RolHasUsuarioPK(rolidRol, usuarioidUsuario);
    }

    public RolHasUsuarioPK getRolHasUsuarioPK() {
        return rolHasUsuarioPK;
    }

    public void setRolHasUsuarioPK(RolHasUsuarioPK rolHasUsuarioPK) {
        this.rolHasUsuarioPK = rolHasUsuarioPK;
    }

    public int getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolHasUsuarioPK != null ? rolHasUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasUsuario)) {
            return false;
        }
        RolHasUsuario other = (RolHasUsuario) object;
        if ((this.rolHasUsuarioPK == null && other.rolHasUsuarioPK != null) || (this.rolHasUsuarioPK != null && !this.rolHasUsuarioPK.equals(other.rolHasUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.usbbog.spmn.spmnws.model.RolHasUsuario[ rolHasUsuarioPK=" + rolHasUsuarioPK + " ]";
    }
    
}
