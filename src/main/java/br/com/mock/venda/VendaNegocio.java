package br.com.mock.venda;

import java.math.BigDecimal;

public class VendaNegocio {
	
	private Venda venda;
	private CreditoServiceInterface creditoService;
	
	public VendaNegocio(CreditoServiceInterface creditoService) {
		this.creditoService = creditoService;
	}
			
	public boolean checkout() {
		if (venda == null || venda.getCliente() == null) {
			return false;
		}
		
		final BigDecimal LIMITE_CREDITO = creditoService.getLimiteCredito(
				venda.getCliente().getCpf());
		
		if (LIMITE_CREDITO == null) {
			return false;
		}
		
		return venda.getValor().compareTo(LIMITE_CREDITO) <= 0;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}