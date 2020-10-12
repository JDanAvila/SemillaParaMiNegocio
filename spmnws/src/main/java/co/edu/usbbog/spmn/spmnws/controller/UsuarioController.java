package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Usuario;
import co.edu.usbbog.spmn.spmnws.service.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService userService;
	
	@PostMapping("/crearUsuario")
    public String crearRol(@RequestBody Usuario newUser) {
        JSONObject respuesta= new JSONObject();
        if(userService.crearUsuario(newUser).equals("Se guardo el rol")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarUsuario")
    public String eliminarRol(@RequestBody Usuario deleteUser) {
		JSONObject respuesta= new JSONObject();
		if(userService.eliminarUsuario(deleteUser).equals("Se elimino el usuario")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarUsuario")
    public String buscarRol(@RequestBody Usuario user) {
        JSONArray array = new JSONArray();
        Usuario roles = userService.mostrarRol(user.getCedula());
        if (roles != null) {
            JSONObject rolJson = new JSONObject();
            rolJson.put("id", roles.getCedula());
            rolJson.put("nombre", roles.getNombre());
            array.put(rolJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarUsuario")
	public String modificarRol(@RequestBody Usuario editUser) {
		JSONObject respuesta= new JSONObject();
		if(userService.modificarUsuario(editUser).equals("Se modifico el usuario")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarUsuario")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=userService.contarUsuario();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allUsuarios")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Usuario> roles=userService.findAll();
		for (int i = 0; i < roles.size(); i++) {
			JSONObject rolJson= new JSONObject();
			rolJson.put("id", roles.get(i).getCedula());
			rolJson.put("cargo", roles.get(i).getNombre());
			array.put(rolJson);			
		}
		return array.toString();		
	}
	
}
