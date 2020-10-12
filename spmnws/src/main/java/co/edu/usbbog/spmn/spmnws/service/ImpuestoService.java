package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Impuesto;
import co.edu.usbbog.spmn.spmnws.repository.IImpuestoRepository;


@Service
public class ImpuestoService implements IImpuestoService {
	
	@Autowired
	private IImpuestoRepository impuestoRepo;

	@Override
	public String crearImpuesto(Impuesto impuesto) {
		try {
			impuestoRepo.save(impuesto);
			return "Se guardo el impuesto";
		} catch (IllegalArgumentException e) {
			return "No se guardo el impuesto: " + e.getMessage();
		}
	}

	@Override
	public String eliminarImpuesto(Impuesto impuesto) {
		try {
			if (impuestoRepo.existsById(impuesto.getId())) {
			impuestoRepo.delete(impuesto);
			return "Se elimino el impuesto";
			}else {
				return "El impuesto no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el impuesto: " + e.getMessage();
		}
	}


	@Override
	public String modificarImpuesto(Impuesto impuesto) {
		try {
			if(impuestoRepo.existsById(impuesto.getId())) {
				impuestoRepo.delete(impuesto);
				impuestoRepo.save(impuesto);
				return "Se modifico el impuesto";
			}else {
				return "No se encontro el impuesto";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el impuesto: " + e.getMessage();
		}
	}

	@Override
	public int contarImpuesto() {
		int contador = 0;
		try {
			contador = (int) impuestoRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Impuesto mostrarImpuesto(int id) {
		Impuesto impuesto = new Impuesto();
		try {
			if(impuestoRepo.existsById(id)) {				
				impuesto = impuestoRepo.getOne(id);
				return impuesto;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			impuesto = null;
		}
		return impuesto;
	}

	@Override
	public List<Impuesto> findAll() {
		List<Impuesto> listaImpuesto = new ArrayList<Impuesto>();
		try {
			listaImpuesto = impuestoRepo.findAll();
			return listaImpuesto;
		} catch (IllegalArgumentException e) {
			return listaImpuesto;
		}
	}
	

}
