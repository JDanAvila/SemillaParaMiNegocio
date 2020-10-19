package co.edu.usbbog.spmn.spmnws.service;


import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.FacturaVenta;

public interface IFacturaVentaService {
	
	public String crearFacturaVenta(FacturaVenta facturaVenta);
	public String eliminarFacturaVenta(FacturaVenta facturaVenta);
	public String modificarFacturaVenta(FacturaVenta facturaVenta);
	public int contarFacturaVenta();
    public FacturaVenta mostrarFacturaVenta(int id);
    public List<FacturaVenta> findAll();
}
