package br.com.loja.dao;

import javax.persistence.EntityManager;

import br.com.loja.util.JPAUtil;
import br.com.loja.modelo.Carrinho;
import br.com.loja.modelo.Produto;

public class CarrinhoDAO {

	private EntityManager manager;

	public CarrinhoDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public void adiciona(Carrinho carrinho) {
		manager.getTransaction().begin();
		manager.persist(carrinho);
		manager.getTransaction().commit();
	}

	public Carrinho busca(Long id) {
		return manager.find(Carrinho.class, id);
	}

	public Carrinho remove(long id) {
		manager.getTransaction().begin();
		Carrinho carrinho = manager.find(Carrinho.class, id);
		manager.remove(carrinho);
		manager.getTransaction().commit();
		return carrinho;
	}

	public void removeProduto(long id, long idProduto) {
		manager.getTransaction().begin();
		Carrinho carrinho = manager.find(Carrinho.class, id);
		Produto produto = manager.find(Produto.class, idProduto);

		carrinho.getProdutos().remove(produto);
		manager.merge(carrinho);
		manager.getTransaction().commit();

	}

	public void trocaQuantidade(Produto produto) {
		manager.getTransaction().begin();
		manager.merge(produto);
		manager.getTransaction().commit();
	}

}
