package co.edu.usbbog.spmn.spmnws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import co.edu.usbbog.spmn.spmnws.model.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	public List<Empleado> findByCedula(String cedula);
		
	
}
