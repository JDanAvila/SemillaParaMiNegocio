package co.edu.usbbog.spmn.spmnws.service;


import java.util.List;

import co.edu.usbbog.spmn.spmnws.model.Servicio;

public interface IServicioService {
	
	public String crearServicio(Servicio servicio);
	public String eliminarServicio(Servicio servicio);
	public String modificarServicio(Servicio servicio);
	public int contarServicio();
    public Servicio mostrarServicio(int id);
    public List<Servicio> findAll();
}
