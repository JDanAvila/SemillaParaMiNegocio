package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
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
		String devolucion = rolService.eliminarRol(deleteRol);
		switch (devolucion) {
		case "Se elimino el rol":
			respuesta.put("respuesta", true);
			return respuesta.toString();
		/*case "No se elimino el rol":
			respuesta.put("respuesta", false);
			return respuesta.toString();*/
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
    public String buscarRol(@RequestBody Rol rol) {
        JSONArray array = new JSONArray();
        Rol roles = rolService.mostrarRol(rol.getId());
        if (roles != null) {
            JSONObject rolJson = new JSONObject();
            rolJson.put("id", roles.getId());
            rolJson.put("nombre", roles.getCargo());
            array.put(rolJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PutMapping("/modificarRol")
	public String modificarRol(@RequestBody Rol editRol) {
		JSONObject respuesta= new JSONObject();
		if(rolService.modificarRol(editRol).equals("Se modifico el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarRol")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=rolService.contarRol();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allRoles")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Rol> roles=rolService.findAll();
		for (int i = 0; i < roles.size(); i++) {
			JSONObject rolJson= new JSONObject();
			rolJson.put("id", roles.get(i).getId());
			rolJson.put("cargo", roles.get(i).getCargo());
			array.put(rolJson);			
		}
		return array.toString();		
	}
	
}
