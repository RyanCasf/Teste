package br.com.junit.locadora;

import java.math.BigDecimal;

public class Filme {
	
	private String nome;
	private Integer estoque;
	private BigDecimal precoLocacao;
	
	public Filme() {
		super();
	}
	
	public Filme(String nome, Integer estoque, BigDecimal precoLocacao) {
		super();
		this.nome = nome;
		this.estoque = estoque;
		this.precoLocacao = precoLocacao;
	}
	
	public String getNome() {
		return nome;
	}

	public Integer getEstoque() {
		return estoque;
	}
	
	public BigDecimal getPrecoLocacao() {
		return precoLocacao;
	}
	
	public void setPrecoLocacao(BigDecimal precoLocacao) {
		this.precoLocacao = precoLocacao;
	}
}