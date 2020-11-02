package co.edu.usbbog.spmn.spmnws.repository; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
 
import co.edu.usbbog.spmn.spmnws.model.Proveedor; 
 
import java.util.List; 
 
 
public interface IProveedorRepository extends JpaRepository<Proveedor,Integer>{ 
	 
	public List<Proveedor> findByNit(Integer nit); 
 
} 