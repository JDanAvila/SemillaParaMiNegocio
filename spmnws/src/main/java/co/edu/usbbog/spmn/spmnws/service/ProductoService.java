package co.edu.usbbog.spmn.spmnws.service; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import co.edu.usbbog.spmn.spmnws.model.Producto; 
import co.edu.usbbog.spmn.spmnws.repository.IProductoRepository; 
 
@Service 
public class ProductoService implements IProductoService { 
 
	@Autowired 
	private IProductoRepository productoRepo; 
	 
	@Override 
	public String crearProducto(Producto producto) { 
		try { 
			productoRepo.save(producto); 
			return "Se guardo el producto"; 
		} catch (IllegalArgumentException e) { 
			return "No se guardo el producto "+ e.getMessage(); 
		} 
	} 
 
	@Override 
	public String eliminarProducto(Producto producto) { 
		try { 
			if(productoRepo.existsById(producto.getId())) { 
				productoRepo.delete(producto); 
				return "Se elimino el producto"; 
			}else { 
				return "El producto no existe"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se elimino el producto"+ e.getMessage(); 
		} 
	} 
 
	@Override 
	public String modificarProducto(Producto producto) { 
		try { 
			if(productoRepo.existsById(producto.getId())) { 
				productoRepo.delete(producto); 
				productoRepo.save(producto); 
				return "Se modifico el producto"; 
			}else { 
				return "No se encontro el producto"; 
			} 
		} catch (IllegalArgumentException e) { 
			return "No se modifico el producto"+ e.getMessage(); 
		} 
	} 
 
	@Override 
	public int contarProducto() { 
		int contador=0; 
		try { 
			contador = (int) productoRepo.count(); 
			return contador; 
		} catch (Exception e) { 
			return contador; 
		} 
	} 
 
	@Override 
	public Producto mostrarProducto(int id) { 
		Producto producto = new Producto(); 
		try { 
			if(productoRepo.existsById(id)) { 
				producto = productoRepo.getOne(id); 
				return producto; 
			}else { 
				return null; 
			} 
		} catch (Exception e) { 
			producto = null; 
		} 
		return producto; 
	} 
 
	@Override 
	public List<Producto> findAll() { 
		List<Producto> listaProducto = new ArrayList<Producto>(); 
		try { 
			listaProducto = productoRepo.findAll(); 
			return listaProducto; 
		} catch (Exception e) { 
			return listaProducto; 
		} 
		 
	} 
 
} 
