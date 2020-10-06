package co.edu.usbbog.spmn.spmnws.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        JSONObject respuesta= new JSONObject();
        if(rolService.crearRol(newRol).equals("Se guardo el rol")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@DeleteMapping("/eliminarRol")
    public String eliminarRol(@RequestBody Rol deleteRol) {
        JSONObject respuesta= new JSONObject();
        String devolucion=rolService.eliminarRol(deleteRol);
        switch (devolucion) {
        case "Se elimino el rol":
        	respuesta.put("respuesta", true);
            return respuesta.toString();
            
        case "El rol no existe":
        	respuesta.put("respuesta", false);
            return respuesta.toString();
        }
        if(rolService.eliminarRol(deleteRol).equals("Se elimino el rol")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/mostrarRol")
    public String mostrarRol(@RequestBody Rol showRol) {
        JSONObject respuesta= new JSONObject();
        if(rolService.mostrarRol(showRol.getId()) != null) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PutMapping("/modificarRol")
    public String modificarRol(@RequestBody Rol editRol) {
        JSONObject respuesta= new JSONObject();
        if(rolService.modificarRol(editRol) != null)  {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/buscarCargo")
    public String buscarNombre(@RequestBody String cargo) {
        JSONObject respuesta= new JSONObject();
        if(rolService.findByCargo(cargo)!=null) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }

    }
}
