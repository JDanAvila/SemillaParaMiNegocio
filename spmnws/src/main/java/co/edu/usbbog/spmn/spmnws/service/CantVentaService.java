package co.edu.usbbog.spmn.spmnws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.spmn.spmnws.model.CantVenta;
import co.edu.usbbog.spmn.spmnws.model.CantVentaPK;
import co.edu.usbbog.spmn.spmnws.model.FacturaVenta;
import co.edu.usbbog.spmn.spmnws.model.Producto;
import co.edu.usbbog.spmn.spmnws.model.Rol;
import co.edu.usbbog.spmn.spmnws.repository.ICantVentaRepository;
import co.edu.usbbog.spmn.spmnws.repository.IFacturaVentaRepository;
import co.edu.usbbog.spmn.spmnws.repository.IProductoRepository;


@Service
public class CantVentaService implements ICantVentaService {
	
	@Autowired
	private ICantVentaRepository cantVentaRepo;

	@Autowired
	private IFacturaVentaRepository facturaRepo;
	@Autowired
	private IProductoRepository productoRepo;


	@Override
	public String eliminarCantVenta(CantVenta cantVenta) {
		try {
			if (cantVentaRepo.existsById(cantVenta.getProducto1().getId())) {
				cantVentaRepo.delete(cantVenta);
			return "Se elimino el cantVenta";
			}else {
				return "El cantVenta no existe";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino el cantVenta: " + e.getMessage();
		}
	}

	@Override
	public String modificarCantVenta(CantVenta cantVenta) {
		try {
			if(cantVentaRepo.existsById(cantVenta.getProducto1().getId())) {
				cantVentaRepo.delete(cantVenta);
				cantVentaRepo.save(cantVenta);
				return "Se modifico el cantVenta";
			}else {
				return "No se encontro el cantVenta";
			}
		} catch (IllegalArgumentException e) {
			return "No se encontro el cantVenta: " + e.getMessage();
		}
	}

	@Override
	public int contarCantVenta() {
		int contador = 0;
		try {
			contador = (int) cantVentaRepo.count();
			return contador;
		} catch (IllegalArgumentException e) {
			return contador;
		}
	}

	@Override
	public CantVenta mostrarCantVenta(int id) {
		CantVenta cantVenta = new CantVenta();
		try {
			if(cantVentaRepo.existsById(id)) {				
				cantVenta = cantVentaRepo.getOne(id);
				return cantVenta;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			cantVenta = null;
		}
		return cantVenta;
	}

	@Override
	public List<CantVenta> findAll() {
		List<CantVenta> listaCantVenta = new ArrayList<CantVenta>();
		try {
			listaCantVenta = cantVentaRepo.findAll();
			return listaCantVenta;
		} catch (IllegalArgumentException e) {
			return listaCantVenta;
		}
	}

	@Override
	public String crearCantVenta(int facturaVenta1, int producto1, int cantidad) {
		FacturaVenta factura= facturaRepo.getOne(facturaVenta1);
		Producto producto= productoRepo.getOne(producto1);
		CantVentaPK pk = new CantVentaPK(factura.getId(), producto.getId());
		CantVenta cantVenta= new CantVenta(pk,cantidad);
		cantVenta.setFacturaVenta1(factura);
		cantVenta.setProducto1(producto);
		cantVentaRepo.save(cantVenta);
		return "Se guardo el cantVenta";
	}

	

}
