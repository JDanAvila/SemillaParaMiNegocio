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
import co.edu.usbbog.spmn.spmnws.model.Proveedor;
import co.edu.usbbog.spmn.spmnws.service.IProveedorService;

@RestController
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;
	
	@PostMapping("/crearProveedor")
    public String crearProveedor(@RequestBody Proveedor newProveedor) {
        JSONObject respuesta= new JSONObject();
        if(proveedorService.crearProveedor(newProveedor).equals("Se guardo el proveedor")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }

	@DeleteMapping("/eliminarProveedor")
    public String eliminarProveedor(@RequestBody Proveedor deleteProveedor) {
		JSONObject respuesta= new JSONObject();
		String devolucion = proveedorService.eliminarProveedor(deleteProveedor);
		switch (devolucion) {
		case "Se elimino el proveedor":
			respuesta.put("respuesta", true);
			return respuesta.toString();
		/*case "No se elimino el rol":
			respuesta.put("respuesta", false);
			return respuesta.toString();*/
		}
		if(proveedorService.eliminarProveedor(deleteProveedor).equals("Se elimino el proveedor")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarProveedor")
    public String buscarProveedor(@RequestBody Proveedor proveedor) {
        JSONArray array = new JSONArray();
        Proveedor proveedores = proveedorService.mostrarProveedor(proveedor.getNit());
        if (proveedores != null) {
            JSONObject rolJson = new JSONObject();
            rolJson.put("nit", proveedores.getNit());
            rolJson.put("nombre", proveedores.getNombre());
            rolJson.put("direccion", proveedores.getDireccion());
            rolJson.put("cel", proveedores.getCel());
            array.put(rolJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PutMapping("/modificarProveedor")
	public String modificarRol(@RequestBody Proveedor editProveedor) {
		JSONObject respuesta= new JSONObject();
		if(proveedorService.modificarProveedor(editProveedor).equals("Se modifico el proveedor")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarProveedor")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=proveedorService.contarProveedor();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allProveedores")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Proveedor> proveedores=proveedorService.findAll();
		for (int i = 0; i < proveedores.size(); i++) {
			JSONObject proveedorJson= new JSONObject();
			proveedorJson.put("nit", proveedores.get(i).getNit());
			proveedorJson.put("nombre", proveedores.get(i).getNombre());
			proveedorJson.put("direccion", proveedores.get(i).getDireccion());
			proveedorJson.put("cel", proveedores.get(i).getCel());
			array.put(proveedorJson);			
		}
		return array.toString();		
	}
}
