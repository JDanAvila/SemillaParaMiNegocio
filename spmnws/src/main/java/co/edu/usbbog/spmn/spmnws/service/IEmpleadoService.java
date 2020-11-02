package co.edu.usbbog.spmn.spmnws.service; 
 
 
import java.util.List; 
 
import co.edu.usbbog.spmn.spmnws.model.Empleado; 
 
public interface IEmpleadoService { 
	 
	public String crearEmpleado(Empleado empleado); 
	public String eliminarEmpleado(Empleado empleado); 
	public String modificarEmpleado(Empleado empleado); 
	public int contarEmpleado(); 
    public Empleado mostrarEmpleado(int id); 
    public List<Empleado> findAll(); 
} 