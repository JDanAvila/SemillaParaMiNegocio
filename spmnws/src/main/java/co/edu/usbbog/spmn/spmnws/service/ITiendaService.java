package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.List; 
 
import co.edu.usbbog.spmn.spmnws.model.Tienda; 
 
public interface ITiendaService { 
	public String crearTienda(Tienda tienda); 
	public String eliminarTienda(Tienda tienda); 
	public String modificarTienda(Tienda tienda); 
	public int contarTienda(); 
    public Tienda mostrarTienda(int id); 
    public List<Tienda> findAll(); 
} 
