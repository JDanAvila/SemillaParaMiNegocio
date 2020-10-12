package co.edu.usbbog.spmn.spmnws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.spmn.spmnws.model.Inventario;

public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
	
	public List<Inventario> findByCantidad(Integer cantidad);
}
