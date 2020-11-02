package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Servicio;
import co.edu.usbbog.spmn.spmnws.repository.IServicioRepository;


@Service
public class ServicioService implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepo;

	@Override
	public String crearServicio(Servicio servicio) {
		try {
			servicioRepo.save(servicio);
			return "Se guardo el servicio";
		} catch (IllegalArgumentException e) {
			return "No se guardo el servicio: " + e.getMessage();
		}
	}

	@Override
	public String eliminarServicio(Servicio servicio) {
		try {
			if (servicioRepo.existsById(servicio.getId())) {
			servicioRepo.delete(servicio);
			return "Se elimino el servicio";
			}else {
				return "El servicio no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el servicio: " + e.getMessage();
		}
	}


	@Override
	public String modificarServicio(Servicio servicio) {
		try {
			if(servicioRepo.existsById(servicio.getId())) {
				servicioRepo.delete(servicio);
				servicioRepo.save(servicio);
				return "Se modifico el servicio";
			}else {
				return "No se encontro el servicio";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el servicio: " + e.getMessage();
		}
	}

	@Override
	public int contarServicio() {
		int contador = 0;
		try {
			contador = (int) servicioRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Servicio mostrarServicio(int id) {
		Servicio servicio = new Servicio();
		try {
			if(servicioRepo.existsById(id)) {				
				servicio = servicioRepo.getOne(id);
				return servicio;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			servicio = null;
		}
		return servicio;
	}

	@Override
	public List<Servicio> findAll() {
		List<Servicio> listaServicio = new ArrayList<Servicio>();
		try {
			listaServicio = servicioRepo.findAll();
			return listaServicio;
		} catch (IllegalArgumentException e) {
			return listaServicio;
		}
	}
	

}
