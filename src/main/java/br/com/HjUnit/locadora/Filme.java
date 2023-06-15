package br.com.HjUnit.locadora;

import java.math.BigDecimal;

public class Filme {
	
	private String nome;
	private Integer estoque;
	private BigDecimal precoLocacao;
	
	public BigDecimal getPrecoLocacao() {
		return precoLocacao;
	}
	
	public void setPrecoLocacao(BigDecimal precoLocacao) {
		this.precoLocacao = precoLocacao;
	}
}