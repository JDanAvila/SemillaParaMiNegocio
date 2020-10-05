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
			rolRepo.delete(rol);
			return "Se elimino el rol";
		} catch (IllegalArgumentException e) {
			return "No se elimino el rol: " + e.getMessage();
		}
	}


	@Override
	public String modificarRol(Rol rol) {
		try {
			if(mostrarRol(rol.getId()) != null) {
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
	public List<Rol> findByCargo(String cargo) {
		List<Rol> listaRol = new ArrayList<Rol>();
		try {
			for (int i = 0; i < listaRol.size(); i++) {
				listaRol.addAll(rolRepo.findByCargo(cargo));
			}
			return listaRol;
		} catch (IllegalArgumentException e) {
			return listaRol;
		}
	}

	@Override
	public Rol mostrarRol(int id) {
		Rol r = new Rol();
		try {
			r = rolRepo.getOne(id);
			return r;
		} catch (IllegalArgumentException e) {
			return r;
		}
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
