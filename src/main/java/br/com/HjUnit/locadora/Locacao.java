package br.com.HjUnit.locadora;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Locacao {
	
	private LocalDate dataLocacao;
	private LocalDate dataRetorno;
	private BigDecimal valor;
	private Filme filme;
	private Usuario usuario;
	
	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getDataLocacao() {
		return dataLocacao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Filme getFilme() {
		return filme;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public LocalDate getDataRetorno() {
		return dataRetorno;
	}
}