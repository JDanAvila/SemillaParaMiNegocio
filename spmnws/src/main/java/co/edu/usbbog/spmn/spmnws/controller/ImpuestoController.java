package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Impuesto;
import co.edu.usbbog.spmn.spmnws.service.IImpuestoService;

@RestController
public class ImpuestoController {
	
	@Autowired
	private IImpuestoService impuestoService;
	
	@PostMapping("/crearImpuesto")
    public String crearImpuesto(@RequestBody Impuesto newImpuesto) {
        JSONObject respuesta= new JSONObject();
        if(impuestoService.crearImpuesto(newImpuesto).equals("Se guardo el impuesto")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarImpuesto")
    public String eliminarImpuesto(@RequestBody Impuesto deleteImpuesto) {
		JSONObject respuesta= new JSONObject();
		if(impuestoService.eliminarImpuesto(deleteImpuesto).equals("Se elimino el impuesto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarImpuesto")
    public String buscarImpuesto(@RequestBody Impuesto impuesto) {
        JSONArray array = new JSONArray();
        Impuesto impuestos = impuestoService.mostrarImpuesto(impuesto.getId());
        if (impuestos != null) {
            JSONObject impuestoJson = new JSONObject();
            impuestoJson.put("id", impuestos.getId());
            impuestoJson.put("nombre", impuestos.getNombre());
            impuestoJson.put("descripcion", impuestos.getDescripcion());
            impuestoJson.put("entidad", impuestos.getEntidad());
            array.put(impuestoJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarImpuesto")
	public String modificarImpuesto(@RequestBody Impuesto editImpuesto) {
		JSONObject respuesta= new JSONObject();
		if(impuestoService.modificarImpuesto(editImpuesto).equals("Se modifico el impuesto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarImpuesto")
	public String contarRol() {
		JSONObject respuesta= new JSONObject();
			int aux=impuestoService.contarImpuesto();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allImpuestos")
	public String getImpuestos() {
		JSONArray array= new JSONArray();
		List<Impuesto> impuestos=impuestoService.findAll();
		for (int i = 0; i < impuestos.size(); i++) {
			JSONObject impuestoJson= new JSONObject();
			impuestoJson.put("id", impuestos.get(i).getId());
			impuestoJson.put("nombre", impuestos.get(i).getNombre());
			impuestoJson.put("descripcion", impuestos.get(i).getDescripcion());
			impuestoJson.put("entidad", impuestos.get(i).getEntidad());
			array.put(impuestoJson);			
		}
		return array.toString();		
	}
	
}
