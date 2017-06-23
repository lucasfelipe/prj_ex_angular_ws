package br.com.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.loja.dao.ProdutoDAO;
import br.com.loja.modelo.Produto;

@Path("produtos")
public class ProdutoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String produtosLista() {
		return new Gson().toJson(new ProdutoDAO().listarTodos());
	}

	// public String produtosLista(@QueryParam("callback") String callback) {
	// return callback + "(" + new Gson().toJson(new ProdutoDAO().listarTodos())
	// + ")";
	// }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvaProduto(String conteudo) {
		Produto produto = new Gson().fromJson(conteudo, Produto.class);
		new ProdutoDAO().adiciona(produto);
		URI uri = URI.create("/produtos/" + produto.getId());
		return Response.created(uri).build();
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaProduto(@PathParam("id") long id) {
		return new ProdutoDAO().buscaProduto(id).toJSON();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarProduto(String conteudo) {
		Produto produto = new Gson().fromJson(conteudo, Produto.class);
		new ProdutoDAO().editaProduto(produto);
		return Response.ok().build();
	}

	@Path("{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response excluirProduto(@PathParam("id") long id) {
		new ProdutoDAO().excluirProduto(id);
		return Response.ok().build();
	}
}
