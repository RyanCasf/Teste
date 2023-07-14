package br.com.HjUnit.locadora;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Locacao {
	
	private static final int QUANTIDADE_DIAS_PARA_RETORNO = 1;
	
	private LocalDate dataLocacao;
	private LocalDate dataRetorno;
	private BigDecimal valor;
	private List<Filme> filmes;
	private Usuario usuario;
	
	public static int getQuantidadeDiasParaRetorno(DayOfWeek dayOfWeek) {
		if (dayOfWeek == null)
			return QUANTIDADE_DIAS_PARA_RETORNO;
		
		switch (dayOfWeek) {
			case SATURDAY: 
				return QUANTIDADE_DIAS_PARA_RETORNO + 1;
			
			case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUNDAY:
			default:
				return QUANTIDADE_DIAS_PARA_RETORNO;
		}
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public void setDataRetorno(LocalDate dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
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
	
	public List<Filme> getFilmes() {
		return filmes;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public LocalDate getDataRetorno() {
		return dataRetorno;
	}
}