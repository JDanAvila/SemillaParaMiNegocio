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
        if(userService.crearUsuario(newUser).equals("Se guardo el usuario")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestBody Usuario deleteUser) {
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
    public String buscarUsuario(@RequestBody Usuario user) {
        JSONArray array = new JSONArray();
        Usuario usuarios = userService.mostrarUsuario(user.getCedula());
        if (usuarios != null) {
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("cedula", usuarios.getCedula());
            usuarioJson.put("nombre", usuarios.getNombre());
            usuarioJson.put("correo", usuarios.getCorreo());
            usuarioJson.put("contrasena", usuarios.getContrasena());
            usuarioJson.put("telefono", usuarios.getTelefono());
            usuarioJson.put("tienda", usuarios.getTienda());
            array.put(usuarioJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarUsuario")
	public String modificarUsuario(@RequestBody Usuario editUser) {
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
	public String contarUsuario() {
		JSONObject respuesta= new JSONObject();
			int aux=userService.contarUsuario();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allUsuarios")
	public String getUsuarios() {
		JSONArray array= new JSONArray();
		List<Usuario> usuarios=userService.findAll();
		for (int i = 0; i < usuarios.size(); i++) {
			JSONObject usuarioJson= new JSONObject();
			usuarioJson.put("cedula", usuarios.get(i).getCedula());
			usuarioJson.put("nombre", usuarios.get(i).getNombre());
			usuarioJson.put("correo", usuarios.get(i).getCorreo());
			usuarioJson.put("contrasena", usuarios.get(i).getContrasena());
			usuarioJson.put("telefono", usuarios.get(i).getTelefono());
			usuarioJson.put("tienda", usuarios.get(i).getTienda());			
			array.put(usuarioJson);			
		}
		return array.toString();		
	}
	
}
