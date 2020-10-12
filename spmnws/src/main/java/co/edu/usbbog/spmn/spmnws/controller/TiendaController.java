package co.edu.usbbog.spmn.spmnws.controller; 
 
import java.util.List; 
 
import org.json.JSONArray; 
import org.json.JSONObject; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 
 
import co.edu.usbbog.spmn.spmnws.model.Tienda; 
import co.edu.usbbog.spmn.spmnws.service.ITiendaService; 
 
@RestController 
public class TiendaController { 
	 
	@Autowired 
	private ITiendaService tiendaService; 
	 
	@PostMapping("/crearTienda") 
    public String crearTienda(@RequestBody Tienda newTienda) { 
        JSONObject respuesta= new JSONObject(); 
        if(tiendaService.crearTienda(newTienda).equals("Se guardo la tienda")) { 
            respuesta.put("respuesta", true); 
            return respuesta.toString(); 
        }else { 
            respuesta.put("respuesta", false); 
            return respuesta.toString(); 
        } 
    } 
	 
	@PostMapping("/eliminarTienda") 
    public String eliminarTienda(@RequestBody Tienda deleteTienda) { 
		JSONObject respuesta= new JSONObject(); 
		if(tiendaService.eliminarTienda(deleteTienda).equals("Se elimino la tienda")) { 
			respuesta.put("respuesta", true); 
			return respuesta.toString(); 
		}else { 
			respuesta.put("respuesta", false); 
			return respuesta.toString(); 
		} 
    } 
	 
	@PostMapping("/mostrarTienda") 
    public String buscarTienda(@RequestBody Tienda tienda) { 
        JSONArray array = new JSONArray(); 
        Tienda tiendas = tiendaService.mostrarTienda(tienda.getId()); 
        if (tiendas != null) { 
            JSONObject tiendaJson = new JSONObject(); 
            tiendaJson.put("id", tiendas.getId()); 
            tiendaJson.put("nombre", tiendas.getNombre()); 
            tiendaJson.put("direccion", tiendas.getDireccion()); 
            tiendaJson.put("telefono", tiendas.getTelefono()); 
            tiendaJson.put("cajaMenor", tiendas.getCajaMenor()); 
            tiendaJson.put("deudas", tiendas.getDeudas()); 
            tiendaJson.put("saldo", tiendas.getSaldo()); 
            array.put(tiendaJson); 
            return array.toString(); 
        } else { 
            return "No se encontro"; 
        } 
 
    } 
	 
	@PostMapping("/modificarTienda") 
	public String modificarTienda(@RequestBody Tienda editTienda) { 
		JSONObject respuesta= new JSONObject(); 
		if(tiendaService.modificarTienda(editTienda).equals("Se modifico la tienda")) { 
			respuesta.put("respuesta", true); 
			return respuesta.toString(); 
		}else { 
			respuesta.put("respuesta", false); 
			return respuesta.toString(); 
		} 
		 
	} 
	 
	@PostMapping("/contarTienda") 
	public String contarTienda() { 
		JSONObject respuesta= new JSONObject(); 
			int aux=tiendaService.contarTienda(); 
			respuesta.put("Count", aux); 
			return respuesta.toString();		 
	} 
	 
	@PostMapping("/allTiendas") 
	public String getTiendas() { 
		JSONArray array= new JSONArray(); 
		List<Tienda> tiendas=tiendaService.findAll(); 
		for (int i = 0; i < tiendas.size(); i++) { 
			JSONObject tiendaJson= new JSONObject(); 
			tiendaJson.put("id", tiendas.get(i).getId()); 
			tiendaJson.put("nombre", tiendas.get(i).getNombre()); 
			tiendaJson.put("direccion", tiendas.get(i).getDireccion()); 
			tiendaJson.put("telefono", tiendas.get(i).getTelefono()); 
			tiendaJson.put("cajaMenor", tiendas.get(i).getCajaMenor()); 
			tiendaJson.put("deudas", tiendas.get(i).getDeudas()); 
			tiendaJson.put("saldo", tiendas.get(i).getSaldo());			 
			array.put(tiendaJson);			 
		} 
		return array.toString();		 
	} 
	 
} 
