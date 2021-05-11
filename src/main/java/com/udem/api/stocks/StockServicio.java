package com.udem.api.stocks;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.udem.api.modelo.Stock;

@Path("api/v1/")

public interface StockServicio {

	@Path("/stocks")
	@GET 
	List<Stock> getStocks();
	
	@Path("/stocks/{id}")
	@GET
	Stock getStock(@PathParam("id") Long id);
	
	@Path("/stocks")
	@POST
	Response crearStock(Stock stock);
	
	@Path("/stocks/{id}")
	@PUT
	Response actualizarStock(Stock stock);
	
	@Path("/stocks/{id}")
	@DELETE
	Response eliminarStock(@PathParam("id") Long id);
	
	@Path("/disponibilidad/producto/{id}")
	@GET
	Long verificarStock(Long id);
	
	@Path("/reportestock")
	@GET
	List<Stock> reportarStock();

}
