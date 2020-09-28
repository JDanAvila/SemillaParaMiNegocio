package co.edu.usbbog.spmn.spmnws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Rol;
import co.edu.usbbog.spmn.spmnws.service.IRolService;

@RestController
public class RolController {
	
	@Autowired
	private IRolService rolService;
	
	@PostMapping("/crearRol")
	public String crearRol(@RequestBody Rol newRol) {
		return rolService.crearRol(newRol);		
	}

}
