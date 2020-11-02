package co.edu.usbbog.spmn.spmnws.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbbog.spmn.spmnws.model.PagoServicio;
import co.edu.usbbog.spmn.spmnws.model.PagoServicioPK;
import co.edu.usbbog.spmn.spmnws.model.Servicio;
import co.edu.usbbog.spmn.spmnws.model.Tienda;
import co.edu.usbbog.spmn.spmnws.repository.IPagoServicioRepository;
import co.edu.usbbog.spmn.spmnws.repository.IServicioRepository;
import co.edu.usbbog.spmn.spmnws.repository.ITiendaRepository;

public class PagoServicioService implements IPagoServicioService {
	
	@Autowired
	private IPagoServicioRepository pagoServicioRepo;

	@Autowired
	private IServicioRepository servicioRepo;
	
	@Autowired
	private ITiendaRepository tiendaRepo;

	@Override
	public String crearPagoServicio(int tienda1, int servicio1, BigDecimal precio, LocalDate fechaLimite, LocalDate fechaPago) {
		Tienda tienda = tiendaRepo.getOne(tienda1);
		Servicio servicio = servicioRepo.getOne(servicio1);
		PagoServicioPK pk = new PagoServicioPK(tienda.getId(), servicio.getId());
		PagoServicio pagoServicio = new PagoServicio(pk, precio, fechaLimite);
		pagoServicio.setTienda1(tienda);;
		pagoServicio.setServicio1(servicio);
		pagoServicioRepo.save(pagoServicio);
		return "Se guardo el pago del servicio";
	}

	@Override
	public String eliminarPagoServicio(PagoServicio pagoServicio) {
		try {
			if (pagoServicioRepo.existsById(pagoServicio.getTienda1().getId())) {
				pagoServicioRepo.delete(pagoServicio);
			return "Se elimino el pago del servicio";
			}else {
				return "El pago del servicio no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el pago del servicio: " + e.getMessage();
		}
	}

	@Override
	public String modificarPagoServicio(PagoServicio pagoServicio) {
		try {
			if(pagoServicioRepo.existsById(pagoServicio.getTienda1().getId())) {
				pagoServicioRepo.delete(pagoServicio);
				pagoServicioRepo.save(pagoServicio);
				return "Se modifico el pago del servicio";
			}else {
				return "No se encontro el pago del servicio";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el pago del servicio: " + e.getMessage();
		}
	}

	@Override
	public int contarPagoServicio() {
		int contador = 0;
		try {
			contador = (int) pagoServicioRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public PagoServicio mostrarPagoServicio(int id) {
		PagoServicio pagoServicio = new PagoServicio();
		try {
			if(pagoServicioRepo.existsById(id)) {				
				pagoServicio = pagoServicioRepo.getOne(id);
				return pagoServicio;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			pagoServicio = null;
		}
		return pagoServicio;
	}

	@Override
	public List<PagoServicio> findAll() {
		List<PagoServicio> listaPagoServicio = new ArrayList<PagoServicio>();
		try {
			listaPagoServicio = pagoServicioRepo.findAll();
			return listaPagoServicio;
		} catch (IllegalArgumentException e) {
			return listaPagoServicio;
		}
	}

}
