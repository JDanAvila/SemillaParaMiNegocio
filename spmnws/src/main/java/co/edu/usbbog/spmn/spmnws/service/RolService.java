package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Rol;
import co.edu.usbbog.spmn.spmnws.repository.IRolRepository;


@Service
public class RolService implements IRolService {
	
	@Autowired
	private IRolRepository rolRepo;

	@Override
	public String crearRol(Rol rol) {
		try {
			rolRepo.save(rol);
			return "Se guardo el rol";
		} catch (IllegalArgumentException e) {
			return "No se guardo el rol: " + e.getMessage();
		}
	}

	@Override
	public String eliminarRol(Rol rol) {
		try {
			if (rolRepo.existsById(rol.getId())) {
			rolRepo.delete(rol);
			return "Se elimino el rol";
			}else {
				return "El rol no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el rol: " + e.getMessage();
		}
	}


	@Override
	public String modificarRol(Rol rol) {
		try {
			if(rolRepo.existsById(rol.getId())) {
				rolRepo.delete(rol);
				rolRepo.save(rol);
				return "Se modifico el rol";
			}else {
				return "No se encontro el rol";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el rol: " + e.getMessage();
		}
	}

	@Override
	public int contarRol() {
		int contador = 0;
		try {
			contador = (int) rolRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Rol mostrarRol(int id) {
		Rol rol = new Rol();
		try {
			if(rolRepo.existsById(id)) {				
				rol = rolRepo.getOne(id);
				return rol;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			rol = null;
		}
		return rol;
	}

	@Override
	public List<Rol> findAll() {
		List<Rol> listaRol = new ArrayList<Rol>();
		try {
			listaRol = rolRepo.findAll();
			return listaRol;
		} catch (IllegalArgumentException e) {
			return listaRol;
		}
	}
	

}
