package br.com.FVenda;

import java.math.BigDecimal;

public class Venda {
	
	private Cliente cliente;
	private BigDecimal valor;
	
	public Venda(final Cliente cliente, final BigDecimal valor) {
		this.cliente = cliente;
		this.valor = valor;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
}