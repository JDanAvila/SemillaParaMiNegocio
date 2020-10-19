package co.edu.usbbog.spmn.spmnws.service;

import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Inventario;

public interface IInventarioService {

	public String crearInventario(Inventario inventario);
	public String eliminarInventario(Inventario inventario);
	public String modificarInventario(Inventario inventario);
	public int contarInventario();
    public Inventario mostrarInventario(int id);
    public List<Inventario> findAll();
}
