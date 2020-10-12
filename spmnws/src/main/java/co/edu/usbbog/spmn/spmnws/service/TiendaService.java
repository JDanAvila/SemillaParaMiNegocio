package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import co.edu.usbbog.spmn.spmnws.model.Tienda; 
import co.edu.usbbog.spmn.spmnws.repository.ITiendaRepository; 
 
 
@Service 
public class TiendaService implements ITiendaService { 
	 
	@Autowired 
	private ITiendaRepository tiendaRepo; 
 
	@Override 
	public String crearTienda(Tienda tienda) { 
		try { 
			tiendaRepo.save(tienda); 
			return "Se guardo la tienda"; 
		} catch (IllegalArgumentException e) { 
			return "No se guardo la tienda: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public String eliminarTienda(Tienda tienda) { 
		try { 
			if (tiendaRepo.existsById(tienda.getId())) { 
			tiendaRepo.delete(tienda); 
			return "Se elimino la tienda"; 
			}else { 
				return "La tienda no existe"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se elimino la tienda: " + e.getMessage(); 
		} 
	} 
 
 
	@Override 
	public String modificarTienda(Tienda tienda) { 
		try { 
			if(tiendaRepo.existsById(tienda.getId())) { 
				tiendaRepo.delete(tienda); 
				tiendaRepo.save(tienda); 
				return "Se modifico la tienda"; 
			}else { 
				return "No se encontro la tienda"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se encontro la tienda: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public int contarTienda() { 
		int contador = 0; 
		try { 
			contador = (int) tiendaRepo.count(); 
			return contador; 
		} catch (IllegalArgumentException e) { 
			return contador; 
		} 
	} 
 
	@Override 
	public Tienda mostrarTienda(int id) { 
		Tienda tienda = new Tienda(); 
		try { 
			if(tiendaRepo.existsById(id)) {				 
				tienda = tiendaRepo.getOne(id); 
				return tienda; 
			}else { 
				return null; 
			} 
		} catch (IllegalArgumentException e) { 
			tienda = null; 
		} 
		return tienda; 
	} 
 
	@Override 
	public List<Tienda> findAll() { 
		List<Tienda> listaTienda = new ArrayList<Tienda>(); 
		try { 
			listaTienda = tiendaRepo.findAll(); 
			return listaTienda; 
		} catch (IllegalArgumentException e) { 
			return listaTienda; 
		} 
	} 
	 
 
} 