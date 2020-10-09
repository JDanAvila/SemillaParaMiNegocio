package co.edu.usbbog.spmn.spmnws.service;


import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Rol;

public interface IRolService {
	
	public String crearRol(Rol rol);
	public String eliminarRol(Rol rol);
	public String modificarRol(Rol rol);
	public int contarRol();
    public Rol mostrarRol(int id);
    public List<Rol> findAll();
}
