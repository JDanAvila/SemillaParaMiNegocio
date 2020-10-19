package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Inventario;
import co.edu.usbbog.spmn.spmnws.repository.IInventarioRepository;

@Service
public class InventarioService implements IInventarioService {

	@Autowired
	private IInventarioRepository inventarioRepo;

	@Override
	public String crearInventario(Inventario inventario) {
		try {
			inventarioRepo.save(inventario);
			return "Se guardo el inventario";
		} catch (IllegalArgumentException e) {
			return "No se guardo el el inventario: " + e.getMessage();
		}
	}

	@Override
	public String eliminarInventario(Inventario inventario) {
		try {
			if (inventarioRepo.existsById(inventario.getCantidad())) {
				inventarioRepo.delete(inventario);
				return "Se elimino el inventario";
			} else {
				return "El inventario no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el inventario: " + e.getMessage();
		}
	}

	@Override
	public String modificarInventario(Inventario inventario) {
		try {
			if (inventarioRepo.existsById(inventario.getCantidad())) {
				inventarioRepo.delete(inventario);
				inventarioRepo.save(inventario);
				return "Se modifico el inventario";
			} else {
				return "No se encontro el inventario";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el inventario: " + e.getMessage();
		}
	}

	@Override
	public int contarInventario() {
		int contador = 0;
		try {
			contador = (int) inventarioRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Inventario mostrarInventario(int id) {
		Inventario inventario = new Inventario();
		try {
			if (inventarioRepo.existsById(id)) {
				inventario = inventarioRepo.getOne(id);
				return inventario;
			} else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			inventario = null;
		}
		return inventario;
	}

	@Override
	public List<Inventario> findAll() {
		List<Inventario> listaInventario = new ArrayList<Inventario>();
		try {
			listaInventario = inventarioRepo.findAll();
			return listaInventario;
		} catch (IllegalArgumentException e) {
			return listaInventario;
		}

	}

}
