package co.edu.usbbog.spmn.spmnws.service;

import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Proveedor;


public interface IProveedorService {
	
	public String crearProveedor(Proveedor proveedor);

	public String eliminarProveedor(Proveedor proveedor);

	public String modificarProveedor(Proveedor proveedor);

	public int contarProveedor();

	public Proveedor mostrarProveedor(int nit);

	public List<Proveedor> findAll();
}
