package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Servicio;
import co.edu.usbbog.spmn.spmnws.service.IServicioService;

@RestController
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
	
	@PostMapping("/crearServicio")
    public String crearServicio(@RequestBody Servicio newServicio) {
        JSONObject respuesta= new JSONObject();
        if(servicioService.crearServicio(newServicio).equals("Se guardo el servicio")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarServicio")
    public String eliminarServicio(@RequestBody Servicio deleteServicio) {
		JSONObject respuesta= new JSONObject();
		if(servicioService.eliminarServicio(deleteServicio).equals("Se elimino el servicio")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarServicio")
    public String buscarServicio(@RequestBody Servicio servicio) {
        JSONArray array = new JSONArray();
        Servicio servicios = servicioService.mostrarServicio(servicio.getId());
        if (servicios != null) {
            JSONObject serviciosJson = new JSONObject();
            serviciosJson.put("id", servicios.getId());
            serviciosJson.put("nombre", servicios.getNombre());
            serviciosJson.put("descripcion", servicios.getDescripcion());
            serviciosJson.put("telefono", servicios.getTelefono());
            serviciosJson.put("entidad", servicios.getEntidad());
            array.put(serviciosJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarServicio")
	public String modificarServicio(@RequestBody Servicio editServicio) {
		JSONObject respuesta= new JSONObject();
		if(servicioService.modificarServicio(editServicio).equals("Se modifico el servicio")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarServicio")
	public String contarServicio() {
		JSONObject respuesta= new JSONObject();
			int aux=servicioService.contarServicio();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allServicios")
	public String getServicios() {
		JSONArray array= new JSONArray();
		List<Servicio> servicios=servicioService.findAll();
		for (int i = 0; i < servicios.size(); i++) {
			JSONObject servicioJson= new JSONObject();
			servicioJson.put("id", servicios.get(i).getId());
			servicioJson.put("nombre", servicios.get(i).getNombre());
			servicioJson.put("descripcion", servicios.get(i).getDescripcion());
			servicioJson.put("telefono", servicios.get(i).getTelefono());
			servicioJson.put("entidad", servicios.get(i).getEntidad());
			array.put(servicioJson);			
		}
		return array.toString();		
	}
	
}
