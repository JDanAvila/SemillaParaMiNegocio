package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.CantVenta;
import co.edu.usbbog.spmn.spmnws.model.Rol;
import co.edu.usbbog.spmn.spmnws.repository.ICantVentaRepository;


@Service
public class CantVentaService implements ICantVentaService {
	
	@Autowired
	private ICantVentaRepository cantVentaRepo;

	@Override
	public String crearCantVenta(CantVenta cantVenta) {
		try {
			cantVentaRepo.save(cantVenta);
			return "Se guardo el cantVenta";
		} catch (IllegalArgumentException e) {
			return "No se guardo el cantVenta: " + e.getMessage();
		}
	}

	@Override
	public String eliminarCantVenta(CantVenta cantVenta) {
		try {
			if (cantVentaRepo.existsById(cantVenta.getProducto1().getId())) {
				cantVentaRepo.delete(cantVenta);
			return "Se elimino el cantVenta";
			}else {
				return "El cantVenta no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el cantVenta: " + e.getMessage();
		}
	}

	@Override
	public String modificarCantVenta(CantVenta cantVenta) {
		try {
			if(cantVentaRepo.existsById(cantVenta.getProducto1().getId())) {
				cantVentaRepo.delete(cantVenta);
				cantVentaRepo.save(cantVenta);
				return "Se modifico el cantVenta";
			}else {
				return "No se encontro el cantVenta";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el cantVenta: " + e.getMessage();
		}
	}

	@Override
	public int contarCantVenta() {
		int contador = 0;
		try {
			contador = (int) cantVentaRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public CantVenta mostrarCantVenta(int id) {
		CantVenta cantVenta = new CantVenta();
		try {
			if(cantVentaRepo.existsById(id)) {				
				cantVenta = cantVentaRepo.getOne(id);
				return cantVenta;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			cantVenta = null;
		}
		return cantVenta;
	}

	@Override
	public List<CantVenta> findAll() {
		List<CantVenta> listaCantVenta = new ArrayList<CantVenta>();
		try {
			listaCantVenta = cantVentaRepo.findAll();
			return listaCantVenta;
		} catch (IllegalArgumentException e) {
			return listaCantVenta;
		}
	}

	

}
