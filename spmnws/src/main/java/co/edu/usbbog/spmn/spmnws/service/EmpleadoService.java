package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Empleado;
import co.edu.usbbog.spmn.spmnws.model.Rol;
import co.edu.usbbog.spmn.spmnws.repository.IEmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepo;

	@Override
	public String crearEmpleado(Empleado empleado) {
		try {
			empleadoRepo.save(empleado);
			return "Se guardo el empleado";
		} catch (IllegalArgumentException e) {
			return "No se guardo el emplado: " + e.getMessage();
		}
	}

	@Override
	public String eliminarEmpleado(Empleado empleado) {
		try {
			if (empleadoRepo.existsById(empleado.getCedula())) {
				empleadoRepo.delete(empleado);
				return "Se elimino el empleado";
			} else {
				return "El empleado no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el emplado: " + e.getMessage();
		}
	}

	@Override
	public String modificarEmpleado(Empleado empleado) {
		try {
			if (empleadoRepo.existsById(empleado.getCedula())) {
				empleadoRepo.delete(empleado);
				empleadoRepo.save(empleado);
				return "Se modifico el empleado";
			} else {
				return "No se encontro el empleado";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el empleado: " + e.getMessage();
		}
	}

	@Override
	public int contarEmpleado() {
		int contador = 0;
		try {
			contador = (int) empleadoRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Empleado mostrarEmpleado(int id) {
		Empleado empleado = new Empleado();
		try {
			if(empleadoRepo.existsById(id)) {				
				empleado = empleadoRepo.getOne(id);
				return empleado;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			empleado = null;
		}
		return empleado;
	}

	@Override
	public List<Empleado> findAll() {
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		try {
			listaEmpleado = empleadoRepo.findAll();
			return listaEmpleado;
		} catch (IllegalArgumentException e) {
			return listaEmpleado;
		}
	}

}
