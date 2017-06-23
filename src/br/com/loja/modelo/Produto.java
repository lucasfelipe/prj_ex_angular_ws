package br.com.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double preco;
	private String nome;
	private Integer quantidade;

	public Produto(long id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produto() {
	}

	public double getPreco() {
		return preco;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPrecoTotal() {
		return quantidade * preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
}
