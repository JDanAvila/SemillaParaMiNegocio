package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import co.edu.usbbog.spmn.spmnws.model.FacturaVenta; 
import co.edu.usbbog.spmn.spmnws.repository.IFacturaVentaRepository; 
 
 
@Service 
public class FacturaVentaService implements IFacturaVentaService { 
	 
	@Autowired 
	private IFacturaVentaRepository facturaVentaRepo; 
 
	@Override 
	public String crearFacturaVenta(FacturaVenta facturaVenta) { 
		try { 
			facturaVentaRepo.save(facturaVenta); 
			return "Se guardo la factura de venta"; 
		} catch (IllegalArgumentException e) { 
			return "No se guardo la factura de venta: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public String eliminarFacturaVenta(FacturaVenta facturaVenta) { 
		try { 
			if (facturaVentaRepo.existsById(facturaVenta.getId())) { 
				facturaVentaRepo.delete(facturaVenta); 
			return "Se elimino la factura de venta"; 
			}else { 
				return "La factura de venta no existe"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se elimino la factura de venta: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public String modificarFacturaVenta(FacturaVenta facturaVenta) { 
		try { 
			if(facturaVentaRepo.existsById(facturaVenta.getId())) { 
				facturaVentaRepo.delete(facturaVenta); 
				facturaVentaRepo.save(facturaVenta); 
				return "Se modifico la factura de venta"; 
			}else { 
				return "No se encontro la factura de venta"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se modifico la factura de venta: " + e.getMessage(); 
		} 
	} 
 
	@Override 
	public int contarFacturaVenta() { 
		int contador = 0; 
		try { 
			contador = (int) facturaVentaRepo.count(); 
			return contador; 
		} catch (IllegalArgumentException e) { 
			return contador; 
		} 
	} 
 
	@Override 
	public FacturaVenta mostrarFacturaVenta(int id) { 
		FacturaVenta facturaVenta = new FacturaVenta(); 
		try { 
			if(facturaVentaRepo.existsById(id)) {				 
				facturaVenta = facturaVentaRepo.getOne(id); 
				return facturaVenta; 
			}else { 
				return null; 
			} 
		} catch (IllegalArgumentException e) { 
			facturaVenta = null; 
		} 
		return facturaVenta; 
	} 
 
	@Override 
	public List<FacturaVenta> findAll() { 
		List<FacturaVenta> listaFacturaVenta = new ArrayList<FacturaVenta>(); 
		try { 
			listaFacturaVenta = facturaVentaRepo.findAll(); 
			//facturaVentaRepo.findByFecha();
			return listaFacturaVenta; 
			
		} catch (IllegalArgumentException e) { 
			return listaFacturaVenta; 
		} 
	}
	
	
	
	
 
} 