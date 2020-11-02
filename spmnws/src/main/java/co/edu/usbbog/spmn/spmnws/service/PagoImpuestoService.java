package co.edu.usbbog.spmn.spmnws.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbbog.spmn.spmnws.model.Impuesto;
import co.edu.usbbog.spmn.spmnws.model.PagoImpuesto;
import co.edu.usbbog.spmn.spmnws.model.PagoImpuestoPK;
import co.edu.usbbog.spmn.spmnws.model.Tienda;
import co.edu.usbbog.spmn.spmnws.repository.IPagoImpuestoRepository;
import co.edu.usbbog.spmn.spmnws.repository.IImpuestoRepository;
import co.edu.usbbog.spmn.spmnws.repository.ITiendaRepository;

public class PagoImpuestoService implements IPagoImpuestoService {
	
	@Autowired
	private IPagoImpuestoRepository pagoImpuestoRepo;

	@Autowired
	private IImpuestoRepository impuestoRepo;
	
	@Autowired
	private ITiendaRepository tiendaRepo;

	@Override
	public String crearPagoImpuesto(int impuesto1, int tienda1, BigDecimal precio, LocalDate fechaLimite, LocalDate fechaPago) {
		Tienda tienda = tiendaRepo.getOne(tienda1);
		Impuesto impuesto = impuestoRepo.getOne(impuesto1);
		PagoImpuestoPK pk = new PagoImpuestoPK(impuesto.getId(), tienda.getId());
		PagoImpuesto pagoImpuesto = new PagoImpuesto(pk, precio, fechaLimite);
		pagoImpuesto.setTienda1(tienda);;
		pagoImpuesto.setImpuesto1(impuesto);
		pagoImpuestoRepo.save(pagoImpuesto);
		return "Se guardo el pago del servicio";
	}

	@Override
	public String eliminarPagoImpuesto(PagoImpuesto pagoImpuesto) {
		try {
			if (pagoImpuestoRepo.existsById(pagoImpuesto.getImpuesto1().getId())) {
				pagoImpuestoRepo.delete(pagoImpuesto);
			return "Se elimino el pago del impuesto";
			}else {
				return "No se elimino el pago del impuesto";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el pago del impuesto: " + e.getMessage();
		}
	}

	@Override
	public String modificarPagoImpuesto(PagoImpuesto pagoServicio) {
		try {
			if(pagoImpuestoRepo.existsById(pagoServicio.getImpuesto1().getId())) {
				pagoImpuestoRepo.delete(pagoServicio);
				pagoImpuestoRepo.save(pagoServicio);
				return "Se modifico el pago del impuesto";
			}else {
				return "No se encontro el pago del impuesto";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el pago del impuesto: " + e.getMessage();
		}
	}

	@Override
	public int contarPagoImpuesto() {
		int contador = 0;
		try {
			contador = (int) pagoImpuestoRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public PagoImpuesto mostrarPagoImpuesto(int id) {
		PagoImpuesto pagoImpuesto = new PagoImpuesto();
		try {
			if(pagoImpuestoRepo.existsById(id)) {				
				pagoImpuesto = pagoImpuestoRepo.getOne(id);
				return pagoImpuesto;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			pagoImpuesto = null;
		}
		return pagoImpuesto;
	}

	@Override
	public List<PagoImpuesto> findAll() {
		List<PagoImpuesto> listaPagoImpuesto = new ArrayList<PagoImpuesto>();
		try {
			listaPagoImpuesto = pagoImpuestoRepo.findAll();
			return listaPagoImpuesto;
		} catch (IllegalArgumentException e) {
			return listaPagoImpuesto;
		}
	}

}
