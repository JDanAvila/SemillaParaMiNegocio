package co.edu.usbbog.spmn.spmnws.service;


import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Impuesto;

public interface IImpuestoService {
	
	public String crearImpuesto(Impuesto impuesto);
	public String eliminarImpuesto(Impuesto impuesto);
	public String modificarImpuesto(Impuesto impuesto);
	public int contarImpuesto();
    public Impuesto mostrarImpuesto(int id);
    public List<Impuesto> findAll();
}
