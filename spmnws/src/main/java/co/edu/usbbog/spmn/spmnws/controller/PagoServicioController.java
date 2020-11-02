package co.edu.usbbog.spmn.spmnws.controller;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.PagoServicio;
import co.edu.usbbog.spmn.spmnws.service.IPagoServicioService;

@RestController
public class PagoServicioController {
	
	//@Autowired
	private IPagoServicioService pagoServicioService;
	
	@PostMapping("/crearPagoServicio")
    public String crearPagoServicio(@RequestBody String newPagoServicio) {
        JSONObject respuesta= new JSONObject();        
        JSONObject entrada= new JSONObject(newPagoServicio); 
        LocalDate fecha = LocalDate.now();
        if(pagoServicioService.crearPagoServicio(entrada.getInt("tienda"),entrada.getInt("servicio"), entrada.getBigDecimal("precio"), fecha, fecha).equals("Se guardo el pago del servicio")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
        
        
    }
	
	@PostMapping("/eliminarPagoServicio")
    public String eliminarPagoServicio(@RequestBody PagoServicio deletePagoServicio) {
		JSONObject respuesta= new JSONObject();
		if(pagoServicioService.eliminarPagoServicio(deletePagoServicio).equals("Se elimino el cantVenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarPagoServicio")
    public String buscarPagoServicio(@RequestBody PagoServicio pagoServicio) {
        JSONArray array = new JSONArray();
        PagoServicio pagoServicios = pagoServicioService.mostrarPagoServicio(pagoServicio.getTienda1().getId());
        if (pagoServicios != null) {
            JSONObject pagoServicioJson = new JSONObject();
            pagoServicioJson.put("Tienda ", pagoServicios.getTienda1().getId());
            pagoServicioJson.put("Servicio ", pagoServicios.getServicio1().getId());
            pagoServicioJson.put("Precio ", pagoServicios.getPrecio());
            pagoServicioJson.put("FechaLimite ", pagoServicios.getFechaLimite());           
            array.put(pagoServicioJson);
            return array.toString();
        } else {
            return "No se encontro";
        }
    }
	
	@PostMapping("/modificarPagoServicio")
	public String modificarPagoServicio(@RequestBody PagoServicio editPagoServicio) {
		JSONObject respuesta= new JSONObject();
		if(pagoServicioService.modificarPagoServicio(editPagoServicio).equals("Se modifico el cantVenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarPagoServicio")
	public String contarPagoServicio() {
		JSONObject respuesta= new JSONObject();
			int aux=pagoServicioService.contarPagoServicio();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allPagoServicio")
	public String getPagoServicio() {
		JSONArray array= new JSONArray();
		List<PagoServicio> pagoServicio = pagoServicioService.findAll();
		for (int i = 0; i < pagoServicio.size(); i++) {
			JSONObject pagoServicioJson= new JSONObject();
			pagoServicioJson.put("Tienda", pagoServicio.get(i).getTienda1().getId());
			pagoServicioJson.put("Servicio", pagoServicio.get(i).getServicio1().getId());
			pagoServicioJson.put("Precio", pagoServicio.get(i).getPrecio());
			pagoServicioJson.put("FechaLimte", pagoServicio.get(i).getFechaLimite());
			array.put(pagoServicioJson);			
		}
		return array.toString();		
	}
	
} 
