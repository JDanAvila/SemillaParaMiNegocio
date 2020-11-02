package co.edu.usbbog.spmn.spmnws.service;

import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Usuario;

public interface IUsuarioService {
	public String crearUsuario(Usuario user);
	public String eliminarUsuario(Usuario user);
	public String modificarUsuario(Usuario user);
	public int contarUsuario();
    public Usuario mostrarUsuario(int cc);
    public List<Usuario> findAll();
}
