package co.edu.usbbog.spmn.spmnws.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.PagoServicio;

public interface IPagoServicioService {
	
	public String crearPagoServicio(int tienda1, int servicio1, BigDecimal precio, LocalDate fechaLimite, LocalDate fechaPago);
	public String eliminarPagoServicio(PagoServicio pagoServicio);
	public String modificarPagoServicio(PagoServicio pagoServicio);
	public int contarPagoServicio();
    public PagoServicio mostrarPagoServicio(int id);
    public List<PagoServicio> findAll();
    
}
