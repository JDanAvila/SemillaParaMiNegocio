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
			return "Se guardo el usuario";
		} catch (IllegalArgumentException e) {
			return "No se guardo el usuario: " + e.getMessage();
		}
	}

	@Override
	public String eliminarUsuario(Usuario user) {
		try {
			if (userRepo.existsById(user.getCedula())) {
				userRepo.delete(user);
				return "Se elimino el rol";
			}else {
				return "El usuario no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el usuario: " + e.getMessage();
		}
	}


	@Override
	public String modificarUsuario(Usuario user) {
		try {
			if(userRepo.existsById(user.getCedula())) {
				userRepo.delete(user);
				userRepo.save(user);
				return "Se modifico el usuario";
			}else {
				return "No se encontro el usuario";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el usuario: " + e.getMessage();
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
	public Usuario mostrarUsuario(int cc) {
		Usuario user = new Usuario();
		try {
			if(userRepo.existsById(cc)) {				
				user = userRepo.getOne(cc);
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
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			listaUsuario = userRepo.findAll();
			return listaUsuario;
		} catch (IllegalArgumentException e) {
			return listaUsuario;
		}
	}
	

}

