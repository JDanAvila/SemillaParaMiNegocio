package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Inventario;
import co.edu.usbbog.spmn.spmnws.service.IInventarioService;

@RestController
public class InventarioController {

	@Autowired
	private IInventarioService inventarioService;
	
	@PostMapping("/crearInventario")
    public String crearInventario(@RequestBody Inventario newInventario) {
        JSONObject respuesta= new JSONObject();
        if(inventarioService.crearInventario(newInventario).equals("Se guardo el inventario")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@DeleteMapping("/eliminarInventario")
    public String eliminarInventario(@RequestBody Inventario deleteInventario) {
		JSONObject respuesta= new JSONObject();
		String devolucion = inventarioService.eliminarInventario(deleteInventario);
		switch (devolucion) {
		case "Se elimino el inventario":
			respuesta.put("respuesta", true);
			return respuesta.toString();
		/*case "No se elimino el rol":
			respuesta.put("respuesta", false);
			return respuesta.toString();*/
		}
		if(inventarioService.eliminarInventario(deleteInventario).equals("Se elimino el inventario")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@GetMapping("/mostrarInventario")
    public String buscarInventario(@RequestBody Inventario inventario) {
        JSONArray array = new JSONArray();
        Inventario inventarios = inventarioService.mostrarInventario(inventario.getCantidad());
        if (inventarios != null) {
            JSONObject inventarioJson = new JSONObject();
            inventarioJson.put("prducto", inventarios.getProducto1());
            inventarioJson.put("tienda", inventarios.getTienda1());
            inventarioJson.put("cantidad", inventarios.getCantidad());
            array.put(inventarioJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PutMapping("/modificarInventario")
	public String modificarInventario(@RequestBody Inventario editInventario) {
		JSONObject respuesta= new JSONObject();
		if(inventarioService.modificarInventario(editInventario).equals("Se modifico el inventario")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarInventario")
	public String contarInvenatrio() {
		JSONObject respuesta= new JSONObject();
			int aux=inventarioService.contarInventario();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allInventarios")
	public String getinvenatrio() {
		JSONArray array= new JSONArray();
		List<Inventario> inventarios=inventarioService.findAll();
		for (int i = 0; i < inventarios.size(); i++) {
			JSONObject inventarioJson= new JSONObject();
			inventarioJson.put("producto", inventarios.get(i).getProducto1());
			inventarioJson.put("tienda", inventarios.get(i).getTienda1());
			inventarioJson.put("cantidad", inventarios.get(i).getCantidad());
			array.put(inventarioJson);			
		}
		return array.toString();		
	}
}
