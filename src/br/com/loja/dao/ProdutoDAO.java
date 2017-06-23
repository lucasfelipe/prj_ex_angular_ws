package br.com.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class ProdutoDAO {

	private EntityManager manager;

	public ProdutoDAO() {
		this.manager = new JPAUtil().getEntityManager();
	}

	public List<Produto> listarTodos() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	public void adiciona(Produto produto) {
		this.manager.getTransaction().begin();
		this.manager.persist(produto);
		this.manager.getTransaction().commit();
	}
	
	public Produto buscaProduto(long id) {
		return this.manager.find(Produto.class, id);
	}
	
	public void editaProduto(Produto produto) {
		this.manager.getTransaction().begin();
		this.manager.merge(produto);
		this.manager.getTransaction().commit();
	}
	
	public void excluirProduto(long id) {
		Produto produto = this.manager.find(Produto.class, id);
		this.manager.getTransaction().begin();
		this.manager.remove(produto);
		this.manager.getTransaction().commit();
	}

}
