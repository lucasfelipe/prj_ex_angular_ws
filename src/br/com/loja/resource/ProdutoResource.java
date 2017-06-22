package br.com.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.loja.dao.ProdutoDAO;

@Path("produtos")
public class ProdutoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String produtosLista(@QueryParam("callback") String callback) {
		return callback + "(" + new Gson().toJson(new ProdutoDAO().listarTodos()) + ")";
	}
	
}
