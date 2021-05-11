package com.udem.api.productos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;//anotacion

import com.udem.api.modelo.Producto;

import javax.ws.rs.core.Response;//libreria de respuestas


@Service
public class ProductoServicioImp implements ProductoServicio {
	
	//Hash Table
	Map<Long,Producto> productos = new HashMap<Long,Producto>();
	long idAct =123;
	long preAct=3000;
	long garant=90; //en dias
	
	//contructor
	public ProductoServicioImp() {
		init();//init para crear el cliente por primera vez
	}
	
	void init() {
		Producto producto = new Producto();
		producto.setReferencia(idAct);
		producto.setPrecio(preAct);
		producto.setDescripcion("Madero SantaCruz");
		producto.setGarantia(garant);
		productos.put(producto.getReferencia(), producto);//producto para manejar put OJO		
	}

	@Override
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		Collection<Producto> result = productos.values();
		List<Producto> respuesta = new ArrayList<>(result);
		return respuesta;
	}
	
	
	@Override
	public Producto getProducto(Long referencia) {
		return productos.get(referencia);
	}
	
	@Override
	public Response crearProducto(Producto producto) {
		producto.setReferencia(++idAct);
		productos.put(producto.getReferencia(), producto);
		return Response.ok(producto).build();
	}

	@Override
	public Response actualizarProducto(Producto producto) {
		Producto productoActual = productos.get(producto.getReferencia());
		Response respuesta;
		
		if(productoActual != null) {
			productos.put(producto.getReferencia(), producto);
			
			respuesta = Response.ok().build();
		}else {
			respuesta = Response.notModified().build();
		}
		return respuesta;
		/*clientes.put(cliente.getId(), cliente);
		 * return null;
		 * */
	}
	
	
/*
 * clientes.remove(id);
		return Response.ok(cliente).build();
 */
	@Override
	public Response eliminarProducto(Long referencia) {
		Response respuesta;
		if(referencia != null) {
			productos.remove(referencia);
			respuesta = Response.ok().build();
		}else {
			respuesta = Response.noContent().build();
		}
		return respuesta;		
	}
	
}
