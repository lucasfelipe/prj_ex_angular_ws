package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@Entity
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany
	private List<Produto> produtos = new ArrayList<Produto>();

	private String rua;

	private String cidade;

	public Carrinho adiciona(Produto produto) {
		produtos.add(produto);
		return this;
	}

	public Carrinho para(String rua, String cidade) {
		this.rua = rua;
		this.cidade = cidade;
		return this;
	}

	public Carrinho setId(long id) {
		this.id = id;
		return this;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public long getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

}
