package com.udem.api.stocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.udem.api.modelo.Stock;

@Service
public class StockServicioImp implements StockServicio {
	
	//Hash Table
	Map<Long,Stock> stocks = new HashMap<Long,Stock>();

	public StockServicioImp() {
		init();
	}
	
	void init() {	
		for(int i= 1 ; i<5 ; i++) {
			Stock stock = new Stock();
			stock.setId(i);
			stock.setNombre_produ("producto " + i);
			stock.setCantidad(i);
			stock.setCmin(i*2);
			stock.setCmax(i*10);	
			stocks.put(stock.getId(), stock);	
		}
	}
	
	@Override
	public List<Stock> getStocks() {
		Collection<Stock> result = stocks.values();
		List<Stock> respuesta = new ArrayList<>(result);
		return respuesta;
	}
	
	@Override
	public Stock getStock(Long id) {
		Stock var;
		var = stocks.get(id);
		System.out.println("GEEET " + var);
		return stocks.get(id);
	}

	@Override
	public Response crearStock(Stock stock) {
		stocks.put(stock.getId(), stock);
		return Response.ok(stock).build();
	}

	@Override
	public Response actualizarStock(Stock stock) {
		Stock stockActual = stocks.get(stock.getId());
		Response respuesta;
		
		if(stockActual != null) {
			stocks.put(stock.getId(), stock);
			
			respuesta = Response.ok().build();
		}else {
			respuesta = Response.notModified().build();
		}
		return respuesta;
	}

	@Override
	public Response eliminarStock(Long id) {
		Response respuesta;
		
		if(id != null) {
			stocks.remove(id);
			respuesta = Response.ok().build();
		}else {
			respuesta = Response.noContent().build();
		}
		return respuesta;
	}

	@Override
	public Long verificarStock(Long id) {
		long cant = 2;
		cant = stocks.get(id).getCantidad();
		System.out.println("GEEET "+ cant);
		return cant;
	}
	
	@Override
	public List<Stock> reportarStock() {
		Collection<Stock> stock = stocks.values();
		List<Stock> lstStock = new ArrayList<>(stock);
		List<Stock> lstNoStock = new ArrayList<>();
		
		for(int i = 0 ; i< lstStock.size(); i++ ) {
			if(lstStock.get(i).getCantidad() < lstStock.get(i).getCmin()) {
				lstNoStock.add(lstStock.get(i));
		}
			
		}
		return lstNoStock;	
	}
	
}