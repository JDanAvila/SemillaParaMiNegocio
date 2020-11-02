package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import co.edu.usbbog.spmn.spmnws.model.Proveedor; 
import co.edu.usbbog.spmn.spmnws.repository.IProveedorRepository; 
 
 
@Service 
public class ProveedorService implements IProveedorService{ 
	 
	@Autowired 
	private IProveedorRepository proveedorRepo; 
 
	@Override 
	public String crearProveedor(Proveedor proveedor) { 
		try { 
			proveedorRepo.save(proveedor); 
			return "Se guardo el proveedor"; 
		} catch (IllegalArgumentException e) { 
			return "No se guardo el proveedor: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public String eliminarProveedor(Proveedor proveedor) { 
		try { 
			if (proveedorRepo.existsById(proveedor.getNit())) { 
			proveedorRepo.delete(proveedor); 
			return "Se elimino el proveedor"; 
			}else { 
				return "El proveedor no existe"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se elimino el proveedor: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public String modificarProveedor(Proveedor proveedor) { 
		try { 
			if(proveedorRepo.existsById(proveedor.getNit())) { 
				proveedorRepo.delete(proveedor); 
				proveedorRepo.save(proveedor); 
				return "Se modifico el proveedor"; 
			}else { 
				return "No se encontro el proveedor"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se encontro el proveedor: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public int contarProveedor() { 
		int contador = 0; 
		try { 
			contador = (int) proveedorRepo.count(); 
			return contador; 
		} catch (IllegalArgumentException e) { 
			return contador; 
		} 
	} 
 
	@Override 
	public Proveedor mostrarProveedor(int nit) { 
		Proveedor proveedor = new Proveedor(); 
		try { 
			if(proveedorRepo.existsById(nit)) {				 
				proveedor = proveedorRepo.getOne(nit); 
				return proveedor; 
			}else { 
				return null; 
			} 
		} catch (IllegalArgumentException e) { 
			proveedor = null; 
		} 
		return proveedor; 
	} 
 
	@Override 
	public List<Proveedor> findAll() { 
		List<Proveedor> listaProveedor = new ArrayList<Proveedor>(); 
		try { 
			listaProveedor = proveedorRepo.findAll(); 
			return listaProveedor; 
		} catch (IllegalArgumentException e) { 
			return listaProveedor; 
		} 
	} 
 
} 
