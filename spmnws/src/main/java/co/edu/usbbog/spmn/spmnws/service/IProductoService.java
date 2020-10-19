package co.edu.usbbog.spmn.spmnws.service;

import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Producto;

public interface IProductoService {

	public String crearProducto(Producto producto);
	public String eliminarProducto(Producto producto);
	public String modificarProducto(Producto producto);
	public int contarProducto();
    public Producto mostrarProducto(int id);
    public List<Producto> findAll();
	
}
