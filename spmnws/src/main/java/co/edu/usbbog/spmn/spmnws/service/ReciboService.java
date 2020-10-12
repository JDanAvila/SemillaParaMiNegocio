package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.Recibo;
import co.edu.usbbog.spmn.spmnws.repository.IReciboRepository;

@Service
public class ReciboService implements IReciboService{
	
	@Autowired
	private IReciboRepository reciboRepo;

	@Override
	public String crearRecibo(Recibo recibo) {
		try {
			reciboRepo.save(recibo);
			return "Se guardo el recibo";
		} catch (IllegalArgumentException e) {
			return "No se guardo el recibo: " + e.getMessage();
		}
	}

	@Override
	public String eliminarRecibo(Recibo recibo) {
		try {
			if (reciboRepo.existsById(recibo.getId())) {
			reciboRepo.delete(recibo);
			return "Se elimino el recibo";
			}else {
				return "El recibo no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el recibo: " + e.getMessage();
		}
	}

	@Override
	public String modificarRecibo(Recibo recibo) {
		try {
			if(reciboRepo.existsById(recibo.getId())) {
				reciboRepo.delete(recibo);
				reciboRepo.save(recibo);
				return "Se modifico el recibo";
			}else {
				return "No se encontro el recibo";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el recibo: " + e.getMessage();
		}
	}

	@Override
	public int contarRecibo() {
		int contador = 0;
		try {
			contador = (int) reciboRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public Recibo mostrarRecibo(int id) {
		Recibo recibo = new Recibo();
		try {
			if(reciboRepo.existsById(id)) {				
				recibo = reciboRepo.getOne(id);
				return recibo;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			recibo = null;
		}
		return recibo;
	}

	@Override
	public List<Recibo> findAll() {
		List<Recibo> listaRecibo = new ArrayList<Recibo>();
		try {
			listaRecibo = reciboRepo.findAll();
			return listaRecibo;
		} catch (IllegalArgumentException e) {
			return listaRecibo;
		}
	}

}
