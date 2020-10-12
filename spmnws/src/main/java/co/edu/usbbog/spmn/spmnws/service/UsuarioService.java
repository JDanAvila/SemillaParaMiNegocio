package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Usuario;
import co.edu.usbbog.spmn.spmnws.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository userRepo;

	@Override
	public String crearUsuario(Usuario user) {
		try {
			userRepo.save(user);
			return "Se guardo el rol";
		} catch (IllegalArgumentException e) {
			return "No se guardo el rol: " + e.getMessage();
		}
	}

	@Override
	public String eliminarUsuario(Usuario user) {
		try {
			if (userRepo.existsById(user.getCedula())) {
				userRepo.delete(user);
				return "Se elimino el rol";
			}else {
				return "El rol no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el rol: " + e.getMessage();
		}
	}


	@Override
	public String modificarUsuario(Usuario user) {
		try {
			if(userRepo.existsById(user.getCedula())) {
				userRepo.delete(user);
				userRepo.save(user);
				return "Se modifico el rol";
			}else {
				return "No se encontro el rol";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el rol: " + e.getMessage();
		}
	}

	@Override
	public int contarUsuario() {
		int contador = 0;
		try {
			contador = (int) userRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Usuario mostrarRol(int id) {
		Usuario user = new Usuario();
		try {
			if(userRepo.existsById(id)) {				
				user = userRepo.getOne(id);
				return user;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			user = null;
		}
		return user;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> listaRol = new ArrayList<Usuario>();
		try {
			listaRol = userRepo.findAll();
			return listaRol;
		} catch (IllegalArgumentException e) {
			return listaRol;
		}
	}
	

}

