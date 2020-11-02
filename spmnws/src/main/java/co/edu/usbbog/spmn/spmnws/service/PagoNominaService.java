package co.edu.usbbog.spmn.spmnws.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.usbbog.spmn.spmnws.model.Empleado;
import co.edu.usbbog.spmn.spmnws.model.PagoNomina;
import co.edu.usbbog.spmn.spmnws.model.PagoNominaPK;
import co.edu.usbbog.spmn.spmnws.model.Tienda;
import co.edu.usbbog.spmn.spmnws.repository.IEmpleadoRepository;
import co.edu.usbbog.spmn.spmnws.repository.IPagoNominaRepository;
import co.edu.usbbog.spmn.spmnws.repository.ITiendaRepository;

public class PagoNominaService implements IPagoNominaService{
	
	@Autowired
	private IPagoNominaRepository pagoNominaRepo;

	@Autowired
	private IEmpleadoRepository empleadoRepo;
	
	@Autowired
	private ITiendaRepository tiendaRepo;

	@Override
	public String crearPagoNomina(int empleado1, int tienda1, int diasTrab, BigDecimal auxTrans, BigDecimal liquidacion,
			BigDecimal pension, BigDecimal netoPagado, BigDecimal fechaPago) {
		Tienda tienda = tiendaRepo.getOne(tienda1);
		Empleado empleado = empleadoRepo.getOne(empleado1);
		PagoNominaPK pk = new PagoNominaPK(tienda.getId(), empleado.getCedula());
		PagoNomina pagoNomina = new PagoNomina(pk, diasTrab, auxTrans, liquidacion, pension, netoPagado, fechaPago);
		pagoNomina.setTienda(tienda);;
		pagoNomina.setEmpleado(empleado);
		pagoNominaRepo.save(pagoNomina);
		return "Se guardo el pago de la nomina";
	}

	@Override
	public String eliminarPagoNomina(PagoNomina pagoNomina) {
		try {
			if (pagoNominaRepo.existsById(pagoNomina.getTienda().getId())) {
				pagoNominaRepo.delete(pagoNomina);
			return "Se elimino el pago de la nomina";
			}else {
				return "El pago de la nomina servicio no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el pago de la nomina: " + e.getMessage();
		}
	}

	@Override
	public String modificarPagoNomina(PagoNomina pagoNomina) {
		try {
			if(pagoNominaRepo.existsById(pagoNomina.getTienda().getId())) {
				pagoNominaRepo.delete(pagoNomina);
				pagoNominaRepo.save(pagoNomina);
				return "Se modifico el pago de la nomina";
			}else {
				return "No se encontro el pago de la nomina";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el pago de la nomina: " + e.getMessage();
		}
	}

	@Override
	public int contarPagoNomina() {
		int contador = 0;
		try {
			contador = (int) pagoNominaRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public PagoNomina mostrarPagoNomina(int id) {
		PagoNomina pagoNomina = new PagoNomina();
		try {
			if(pagoNominaRepo.existsById(id)) {				
				pagoNomina = pagoNominaRepo.getOne(id);
				return pagoNomina;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			pagoNomina = null;
		}
		return pagoNomina;
	}

	@Override
	public List<PagoNomina> findAll() {
		List<PagoNomina> listaPagoNomina = new ArrayList<PagoNomina>();
		try {
			listaPagoNomina = pagoNominaRepo.findAll();
			return listaPagoNomina;
		} catch (IllegalArgumentException e) {
			return listaPagoNomina;
		}
	}

}
