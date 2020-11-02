package co.edu.usbbog.spmn.spmnws.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.PagoImpuesto;

public interface IPagoImpuestoService {
	
	public String crearPagoImpuesto(int impuesto1, int tienda1, BigDecimal precio, LocalDate fechaLimite, LocalDate fechaPago);
	public String eliminarPagoImpuesto(PagoImpuesto pagoImpuesto);
	public String modificarPagoImpuesto(PagoImpuesto pagoImpuesto);
	public int contarPagoImpuesto();
    public PagoImpuesto mostrarPagoImpuesto(int id);
    public List<PagoImpuesto> findAll();
}
