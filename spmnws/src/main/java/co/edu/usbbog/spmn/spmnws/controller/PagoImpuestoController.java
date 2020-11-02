package co.edu.usbbog.spmn.spmnws.controller;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.PagoImpuesto;
import co.edu.usbbog.spmn.spmnws.service.IPagoImpuestoService;

@RestController
public class PagoImpuestoController {
	
	//@Autowired
	private IPagoImpuestoService pagoImpuestoService;
	
	@PostMapping("/crearPagoImpuesto")
    public String crearPagoImpuesto(@RequestBody String newPagoImpuesto) {
        JSONObject respuesta= new JSONObject();        
        JSONObject entrada= new JSONObject(newPagoImpuesto);     
        LocalDate fecha = LocalDate.now();
        if(pagoImpuestoService.crearPagoImpuesto(entrada.getInt("tienda1"),entrada.getInt("servicio1"), entrada.getBigDecimal("Precio"), fecha, fecha).equals("Se guardo el pago del servicio")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
        
        
    }
	
	@PostMapping("/eliminarPagoImpuesto")
    public String eliminarPagoImpuesto(@RequestBody PagoImpuesto deletePagoImpuesto) {
		JSONObject respuesta= new JSONObject();
		if(pagoImpuestoService.eliminarPagoImpuesto(deletePagoImpuesto).equals("Se elimino el pago del impuesto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarPagoImpuesto")
    public String buscarPagoImpuesto(@RequestBody PagoImpuesto pagoImpuesto) {
        JSONArray array = new JSONArray();
        PagoImpuesto pagoImpuestos = pagoImpuestoService.mostrarPagoImpuesto(pagoImpuesto.getTienda1().getId());
        if (pagoImpuestos != null) {
            JSONObject pagoImpuestoJson = new JSONObject();
            pagoImpuestoJson.put("Tienda ", pagoImpuestos.getImpuesto1().getId());
            pagoImpuestoJson.put("Servicio ", pagoImpuestos.getTienda1().getId());
            pagoImpuestoJson.put("Precio ", pagoImpuestos.getCosto());
            pagoImpuestoJson.put("FechaLimite ", pagoImpuestos.getFechaLimite());           
            array.put(pagoImpuestoJson);
            return array.toString();
        } else {
            return "No se encontro";
        }
    }
	
	@PostMapping("/modificarPagoImpuesto")
	public String modificarPagoImpuesto(@RequestBody PagoImpuesto editPagoImpuesto) {
		JSONObject respuesta= new JSONObject();
		if(pagoImpuestoService.modificarPagoImpuesto(editPagoImpuesto).equals("Se modifico el pago del impuesto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarPagoImpuesto")
	public String contarPagoImpuesto() {
		JSONObject respuesta= new JSONObject();
			int aux=pagoImpuestoService.contarPagoImpuesto();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allPagoImpuesto")
	public String getPagoImpuesto() {
		JSONArray array= new JSONArray();
		List<PagoImpuesto> pagoServicio = pagoImpuestoService.findAll();
		for (int i = 0; i < pagoServicio.size(); i++) {
			JSONObject pagoImpuestoJson= new JSONObject();
			pagoImpuestoJson.put("Tienda", pagoServicio.get(i).getImpuesto1().getId());
			pagoImpuestoJson.put("Servicio", pagoServicio.get(i).getTienda1().getId());
			pagoImpuestoJson.put("Precio", pagoServicio.get(i).getCosto());
			pagoImpuestoJson.put("FechaLimte", pagoServicio.get(i).getFechaLimite());
			array.put(pagoImpuestoJson);			
		}
		return array.toString();		
	}
	
} 
