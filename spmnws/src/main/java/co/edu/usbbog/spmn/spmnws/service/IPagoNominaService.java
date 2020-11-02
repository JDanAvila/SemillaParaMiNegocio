package co.edu.usbbog.spmn.spmnws.service;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.PagoNomina;

public interface IPagoNominaService {
	
	public String crearPagoNomina(int empleado1, int tienda1, int diasTrab, BigDecimal auxTrans, BigDecimal liquidacion, 
			BigDecimal pension, BigDecimal netoPagado, BigDecimal fechaPago);
	public String eliminarPagoNomina(PagoNomina pagoNomina);
	public String modificarPagoNomina(PagoNomina pagoNomina);
	public int contarPagoNomina();
    public PagoNomina mostrarPagoNomina(int id);
    public List<PagoNomina> findAll();
}
