package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.CantVenta;
import co.edu.usbbog.spmn.spmnws.service.ICantVentaService;

@RestController
public class CantVentaController {
	
	@Autowired
	private ICantVentaService cantVentaService;
	
	@PostMapping("/crearCantVenta")
    public String crearCantVenta(@RequestBody CantVenta newCantVenta) {
        JSONObject respuesta= new JSONObject();
        if(cantVentaService.crearCantVenta(newCantVenta).equals("Se guardo el cantVenta")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarCantVenta")
    public String eliminarCantVenta(@RequestBody CantVenta deleteCantVenta) {
		JSONObject respuesta= new JSONObject();
		if(cantVentaService.eliminarCantVenta(deleteCantVenta).equals("Se elimino el cantVenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarCantVenta")
    public String buscarCantVenta(@RequestBody CantVenta  cantVenta) {
        JSONArray array = new JSONArray();
        CantVenta cantVentas = cantVentaService.mostrarCantVenta(cantVenta.getProducto1().getId());
        if (cantVentas != null) {
            JSONObject cantVentaJson = new JSONObject();
            cantVentaJson.put("Factura ", cantVentas.getFacturaVenta1().getId());
            cantVentaJson.put("Producto ", cantVentas.getProducto1().getId());
            cantVentaJson.put("Cantidad ", cantVentas.getCantidad());
            array.put(cantVentaJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarCantVenta")
	public String modificarRol(@RequestBody CantVenta editcantVenta) {
		JSONObject respuesta= new JSONObject();
		if(cantVentaService.modificarCantVenta(editcantVenta).equals("Se modifico el cantVenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarCantVenta")
	public String contarCantVenta() {
		JSONObject respuesta= new JSONObject();
			int aux=cantVentaService.contarCantVenta();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allCantVentas")
	public String getCa() {
		JSONArray array= new JSONArray();
		List<CantVenta> cantVenta=cantVentaService.findAll();
		for (int i = 0; i < cantVenta.size(); i++) {
			JSONObject cantVentaJson= new JSONObject();
			cantVentaJson.put("Factura", cantVenta.get(i).getFacturaVenta1().getId());
			cantVentaJson.put("Producto", cantVenta.get(i).getProducto1().getId());
			cantVentaJson.put("Cantidad", cantVenta.get(i).getCantidad());
			array.put(cantVentaJson);			
		}
		return array.toString();		
	}
	
}
