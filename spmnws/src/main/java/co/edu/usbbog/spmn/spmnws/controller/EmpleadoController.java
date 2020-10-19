package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Empleado;
import co.edu.usbbog.spmn.spmnws.service.IEmpleadoService;

@RestController
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@PostMapping("/crearEmpleado")
    public String crearEmpleado(@RequestBody Empleado newEmpleado) {
        JSONObject respuesta= new JSONObject();
        if(empleadoService.crearEmpleado(newEmpleado).equals("Se guardo el empleado")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@PostMapping("/eliminarEmpleado")
    public String eliminarEmpleado(@RequestBody Empleado deleteEmpleado) {
		JSONObject respuesta= new JSONObject();
		if(empleadoService.eliminarEmpleado(deleteEmpleado).equals("Se elimino el empleado")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@PostMapping("/mostrarEmpleado")
    public String buscarEmpleado(@RequestBody Empleado empleado) {
        JSONArray array = new JSONArray();
        Empleado empleados = empleadoService.mostrarEmpleado(empleado.getCedula());
        if (empleados != null) {
            JSONObject empleadoJson = new JSONObject();
            empleadoJson.put("cedula", empleados.getCedula());
            empleadoJson.put("sueldo_basico", empleados.getSueldoBasico());
            empleadoJson.put("arl", empleados.getArl());
            empleadoJson.put("eps", empleados.getEps());
            empleadoJson.put("fecha_ingreso", empleados.getFechaIngreso());
            empleadoJson.put("fecha_salida", empleados.getFechaSalida());
            array.put(empleadoJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarEmpleado")
	public String modificarEmpleado(@RequestBody Empleado editEmpleado) {
		JSONObject respuesta= new JSONObject();
		if(empleadoService.modificarEmpleado(editEmpleado).equals("Se modifico el empleado")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarEmpleado")
	public String contarEmpleado() {
		JSONObject respuesta= new JSONObject();
			int aux=empleadoService.contarEmpleado();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allEmplados")
	public String getEmpleados() {
		JSONArray array= new JSONArray();
		List<Empleado> empleados=empleadoService.findAll();
		for (int i = 0; i < empleados.size(); i++) {
			JSONObject empleadoJson= new JSONObject();
			empleadoJson.put("cedula", empleados.get(i).getCedula());
			empleadoJson.put("sueldo_basico", empleados.get(i).getSueldoBasico());
			empleadoJson.put("arl", empleados.get(i).getArl());
			empleadoJson.put("eps", empleados.get(i).getEps());
			empleadoJson.put("fecha_ingreso", empleados.get(i).getFechaIngreso());
			empleadoJson.put("fecha_salida", empleados.get(i).getFechaSalida());
			array.put(empleadoJson);			
		}
		return array.toString();		
	}
	
}
