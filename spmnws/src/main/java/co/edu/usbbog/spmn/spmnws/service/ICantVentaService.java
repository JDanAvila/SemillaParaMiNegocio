package co.edu.usbbog.spmn.spmnws.service;


import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.CantVenta;

public interface ICantVentaService {
	
	public String crearCantVenta(int facturaVenta1, int producto1, int cantidad);
	public String eliminarCantVenta(CantVenta cantVenta);
	public String modificarCantVenta(CantVenta cantVenta);
	public int contarCantVenta();
    public CantVenta mostrarCantVenta(int id);
    public List<CantVenta> findAll();
}
