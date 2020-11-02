package co.edu.usbbog.spmn.spmnws.repository; 
 
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; 
 
 
import co.edu.usbbog.spmn.spmnws.model.FacturaVenta; 
 
public interface IFacturaVentaRepository extends JpaRepository<FacturaVenta, Integer>{ 
	 
	public List<FacturaVenta> findByFecha(LocalDate fecha);	 
	 

	@Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
	Foo retrieveByName(@Param("name") String name);


} 
