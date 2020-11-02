package co.edu.usbbog.spmn.spmnws.repository; 
 
import java.util.List; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
 
import co.edu.usbbog.spmn.spmnws.model.Producto; 
 
public interface IProductoRepository extends JpaRepository<Producto, Integer> { 
 
    public List<Producto> findByNombre(Integer nombre); 
     
}