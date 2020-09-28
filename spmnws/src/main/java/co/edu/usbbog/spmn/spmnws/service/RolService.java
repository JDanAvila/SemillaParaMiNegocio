package co.edu.usbbog.spmn.spmnws.service;

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
	

}
