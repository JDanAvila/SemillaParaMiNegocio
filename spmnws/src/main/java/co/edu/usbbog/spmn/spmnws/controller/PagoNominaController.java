package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.PagoNomina;
import co.edu.usbbog.spmn.spmnws.service.IPagoNominaService;

@RestController
public class PagoNominaController {
	
	//@Autowired
	private IPagoNominaService pagoNominaService;
	
	@PostMapping("/crearPagoNomina")
    public String crearPagoNomina(@RequestBody String newPagoNomina) {
        JSONObject respuesta= new JSONObject();        
        JSONObject entrada= new JSONObject(newPagoNomina);               
        if(pagoNominaService.crearPagoNomina(entrada.getInt("empleado1"),entrada.getInt("tienda1"), 
        		entrada.getInt("dias_trab"), entrada.getBigDecimal("Aux_trans"), entrada.getBigDecimal("liquidacion"), 
        		entrada.getBigDecimal("pension"), entrada.getBigDecimal("netoPagado"), entrada.getBigDecimal("fechaPago")).equals("Se guardo el pago de la nomina")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
        
        
    }
	
	@PostMapping("/eliminarPagoNomina")
    public String eliminarPagoNomina(@RequestBody PagoNomina deletePagoNomina) {
		JSONObject respuesta= new JSONObject();
		if(pagoNominaService.eliminarPagoNomina(deletePagoNomina).equals("Se elimino el pago de la nomina")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarPagoNomina")
    public String buscarPagoNomina(@RequestBody PagoNomina pagoNomina) {
        JSONArray array = new JSONArray();
        PagoNomina pagoNominas = pagoNominaService.mostrarPagoNomina(pagoNomina.getTienda().getId());
        if (pagoNominas != null) {
            JSONObject pagoNominaJson = new JSONObject();
            pagoNominaJson.put("Empleado", pagoNomina.getEmpleado().getCedula());			
			pagoNominaJson.put("Tienda", pagoNomina.getTienda().getId());
			pagoNominaJson.put("Dias_trab", pagoNomina.getDiasTrab());
			pagoNominaJson.put("Aux_trans", pagoNomina.getAuxTrans());
			pagoNominaJson.put("liquidacion", pagoNomina.getLiquidacion());
			pagoNominaJson.put("pension", pagoNomina.getPension());
			pagoNominaJson.put("netoPagado", pagoNomina.getNetoPagado());
			pagoNominaJson.put("fechaPagado", pagoNomina.getFechaPago());        
            array.put(pagoNominaJson);
            return array.toString();
        } else {
            return "No se encontro";
        }
    }
	
	@PostMapping("/modificarPagoNomina")
	public String modificarPagoNomina(@RequestBody PagoNomina editPagoNomina) {
		JSONObject respuesta= new JSONObject();
		if(pagoNominaService.modificarPagoNomina(editPagoNomina).equals("Se modifico el pago de la nomina")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarPagoNomina")
	public String contarPagoNomina() {
		JSONObject respuesta= new JSONObject();
			int aux=pagoNominaService.contarPagoNomina();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allPagoNomina")
	public String getPagoNomina() {
		JSONArray array= new JSONArray();
		List<PagoNomina> pagoNomina = pagoNominaService.findAll();
		for (int i = 0; i < pagoNomina.size(); i++) {
			JSONObject pagoNominaJson= new JSONObject();
			pagoNominaJson.put("Empleado", pagoNomina.get(i).getEmpleado().getCedula());			
			pagoNominaJson.put("Tienda", pagoNomina.get(i).getTienda().getId());
			pagoNominaJson.put("Dias_trab", pagoNomina.get(i).getDiasTrab());
			pagoNominaJson.put("Aux_trans", pagoNomina.get(i).getAuxTrans());
			pagoNominaJson.put("liquidacion", pagoNomina.get(i).getLiquidacion());
			pagoNominaJson.put("pension", pagoNomina.get(i).getPension());
			pagoNominaJson.put("netoPagado", pagoNomina.get(i).getNetoPagado());
			pagoNominaJson.put("fechaPagado", pagoNomina.get(i).getFechaPago());
			array.put(pagoNominaJson);			
		}
		return array.toString();		
	}
	
} 
