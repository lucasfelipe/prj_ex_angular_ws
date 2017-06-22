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

}
