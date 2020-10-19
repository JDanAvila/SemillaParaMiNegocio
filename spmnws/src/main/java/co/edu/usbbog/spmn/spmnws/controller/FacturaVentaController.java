package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.FacturaVenta;
import co.edu.usbbog.spmn.spmnws.service.IFacturaVentaService;

@RestController
public class FacturaVentaController {
	
	@Autowired
	private IFacturaVentaService facturaVentaService;
	
	@PostMapping("/crearFacturaVenta")
    public String crearFacturaVenta(@RequestBody FacturaVenta newFacturaVenta) {
        JSONObject respuesta= new JSONObject();
        if(facturaVentaService.crearFacturaVenta(newFacturaVenta).equals("Se guardo la factura de venta")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarFacturaVenta")
    public String eliminarFacturaVenta(@RequestBody FacturaVenta deleteFacturaVenta) {
		JSONObject respuesta= new JSONObject();
		if(facturaVentaService.eliminarFacturaVenta(deleteFacturaVenta).equals("Se elimino el rol")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarFacturaVenta")
    public String buscarFacturaVenta(@RequestBody FacturaVenta facturaVenta) {
        JSONArray array = new JSONArray();
        FacturaVenta facturaVentas = facturaVentaService.mostrarFacturaVenta(facturaVenta.getId());
        if (facturaVentas != null) {
            JSONObject facturaVeentaJson = new JSONObject();
            facturaVeentaJson.put("id", facturaVentas.getId());
            facturaVeentaJson.put("nombre", facturaVentas.getFecha());
            facturaVeentaJson.put("tamano", facturaVentas.getDescripcion());
            facturaVeentaJson.put("presentacion", facturaVentas.getTotalBruto());
            facturaVeentaJson.put("unidad_medida", facturaVentas.getImpuestos());
            facturaVeentaJson.put("descripcion", facturaVentas.getTotalPagar());
            facturaVeentaJson.put("costo", facturaVentas.getCliente());
            array.put(facturaVeentaJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarFacturaVenta")
	public String modificarRol(@RequestBody FacturaVenta editFacturaVenta) {
		JSONObject respuesta= new JSONObject();
		if(facturaVentaService.modificarFacturaVenta(editFacturaVenta).equals("Se modifico la factura de venta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarFacturaVenta")
	public String contarFacturaVenta() {
		JSONObject respuesta= new JSONObject();
			int aux=facturaVentaService.contarFacturaVenta();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allFacturaVentas")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<FacturaVenta> facturas=facturaVentaService.findAll();
		for (int i = 0; i < facturas.size(); i++) {
			JSONObject rolJson= new JSONObject();
			rolJson.put("id", facturas.get(i).getId());
			rolJson.put("nombre", facturas.get(i).getFecha());
			rolJson.put("tamano", facturas.get(i).getDescripcion());
			rolJson.put("presentacion", facturas.get(i).getTotalBruto());
			rolJson.put("unidad_medida", facturas.get(i).getImpuestos());
			rolJson.put("descripcion", facturas.get(i).getTotalPagar());
			rolJson.put("costo", facturas.get(i).getCliente());
			array.put(rolJson);			
		}
		return array.toString();		
	}
	
}
