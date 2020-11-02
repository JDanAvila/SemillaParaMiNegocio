package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.List; 
 
import co.edu.usbbog.spmn.spmnws.model.Recibo; 
 
public interface IReciboService { 
	public String crearRecibo(Recibo recibo); 
	public String eliminarRecibo(Recibo recibo); 
	public String modificarRecibo(Recibo recibo); 
	public int contarRecibo(); 
    public Recibo mostrarRecibo(int id); 
    public List<Recibo> findAll(); 
 
} 
