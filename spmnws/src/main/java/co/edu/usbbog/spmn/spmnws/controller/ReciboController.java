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

import co.edu.usbbog.spmn.spmnws.model.Recibo;
import co.edu.usbbog.spmn.spmnws.service.IReciboService;

@RestController
public class ReciboController {
	
	@Autowired
	private IReciboService reciboService;
	
	@PostMapping("/crearRecibo")
    public String crearRecibo(@RequestBody Recibo newRecibo) {
        JSONObject respuesta= new JSONObject();
        if(reciboService.crearRecibo(newRecibo).equals("Se guardo el recibo")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@DeleteMapping("/eliminarRecibo")
    public String eliminarRecibo(@RequestBody Recibo deleteRecibo) {
		JSONObject respuesta= new JSONObject();
		String devolucion = reciboService.eliminarRecibo(deleteRecibo);
		switch (devolucion) {
		case "Se elimino el recibo":
			respuesta.put("respuesta", true);
			return respuesta.toString();
		/*case "No se elimino el rol":
			respuesta.put("respuesta", false);
			return respuesta.toString();*/
		}
		if(reciboService.eliminarRecibo(deleteRecibo).equals("Se elimino el recibo")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@GetMapping("/mostrarRecibo")
    public String buscarRecibo(@RequestBody Recibo recibo) {
        JSONArray array = new JSONArray();
        Recibo recibos = reciboService.mostrarRecibo(recibo.getId());
        if (recibos != null) {
            JSONObject reciboJson = new JSONObject();
            reciboJson.put("id", recibos.getId());
            reciboJson.put("fecha", recibos.getFecha());
            reciboJson.put("totalRecibo", recibos.getTotalRecibo());
            reciboJson.put("descripcion", recibos.getDescripcion());
            reciboJson.put("estado", recibos.getEstado());
            reciboJson.put("fechaPago", recibos.getFechaPago());
            reciboJson.put("proveedor", recibos.getProveedor());
            array.put(reciboJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PutMapping("/modificarRecibo")
	public String modificarRecibo(@RequestBody Recibo editRecibo) {
		JSONObject respuesta= new JSONObject();
		if(reciboService.modificarRecibo(editRecibo).equals("Se modifico el recibo")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarRecibo")
	public String contarRecibo() {
		JSONObject respuesta= new JSONObject();
			int aux=reciboService.contarRecibo();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allRecibo")
	public String getRecibos() {
		JSONArray array= new JSONArray();
		List<Recibo> recibos=reciboService.findAll();
		for (int i = 0; i < recibos.size(); i++) {
			JSONObject reciboJson= new JSONObject();
			reciboJson.put("id", recibos.get(i).getId());
			reciboJson.put("fecha", recibos.get(i).getFecha());
            reciboJson.put("total_recibo", recibos.get(i).getTotalRecibo());
            reciboJson.put("descripcion", recibos.get(i).getDescripcion());
            reciboJson.put("estado", recibos.get(i).getEstado());
            reciboJson.put("fecha_pago", recibos.get(i).getFechaPago());
            reciboJson.put("proveedor", recibos.get(i).getProveedor());
			array.put(reciboJson);			
		}
		return array.toString();		
	}
}
