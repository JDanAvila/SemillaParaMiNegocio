package co.edu.usbbog.spmn.spmnws.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.spmn.spmnws.model.Producto;
import co.edu.usbbog.spmn.spmnws.service.IProductoService;

@RestController
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/crearProducto")
    public String crearProducto(@RequestBody Producto newProducto) {
        JSONObject respuesta= new JSONObject();
        if(productoService.crearProducto(newProducto).equals("Se guardo el producto")) {
            respuesta.put("respuesta", true);
            return respuesta.toString();
        }else {
            respuesta.put("respuesta", false);
            return respuesta.toString();
        }
    }
	
	@DeleteMapping("/eliminarProducto")
    public String eliminarProducto(@RequestBody Producto deleteProducto) {
		JSONObject respuesta= new JSONObject();
		if(productoService.eliminarProducto(deleteProducto).equals("Se elimino el producto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
    }
	
	@GetMapping("/mostrarProducto")
    public String buscarProducto(@RequestBody Producto producto) {
        JSONArray array = new JSONArray();
        Producto productos = productoService.mostrarProducto(producto.getId());
        if (productos != null) {
            JSONObject rolJson = new JSONObject();
            rolJson.put("id", productos.getId());
            rolJson.put("nombre", productos.getNombre());
            rolJson.put("tamano", productos.getTamano());
            rolJson.put("presentacion", productos.getPresentacion());
            rolJson.put("unidad_medida", productos.getUnidadMedida());
            rolJson.put("descripcion", productos.getDescripcion());
            rolJson.put("costo", productos.getCosto());
            rolJson.put("precio", productos.getPrecio());
            array.put(rolJson);
            return array.toString();
        } else {
            return "No se encontro";
        }

    }
	
	@PostMapping("/modificarProducto")
	public String modificarProducto(@RequestBody Producto editProducto) {
		JSONObject respuesta= new JSONObject();
		if(productoService.modificarProducto(editProducto).equals("Se modifico el producto")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/contarProducto")
	public String contarProducto() {
		JSONObject respuesta= new JSONObject();
			int aux=productoService.contarProducto();
			respuesta.put("Count", aux);
			return respuesta.toString();		
	}
	
	@PostMapping("/allProductos")
	public String getRoles() {
		JSONArray array= new JSONArray();
		List<Producto> productos=productoService.findAll();
		for (int i = 0; i < productos.size(); i++) {
			JSONObject productoJson= new JSONObject();
			productoJson.put("id", productos.get(i).getId());
			productoJson.put("nombre", productos.get(i).getNombre());
			productoJson.put("tamano", productos.get(i).getTamano());
			productoJson.put("presentacion", productos.get(i).getPresentacion());
			productoJson.put("unidad_medida", productos.get(i).getUnidadMedida());
			productoJson.put("descripcion", productos.get(i).getDescripcion());
			productoJson.put("costo", productos.get(i).getCosto());
			productoJson.put("precio", productos.get(i).getPrecio());
			array.put(productoJson);			
		}
		return array.toString();		
	}
}
