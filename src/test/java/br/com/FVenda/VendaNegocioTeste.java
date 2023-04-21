package br.com.FVenda;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Venda Negócio")
class VendaNegocioTeste {
	
	private CreditoServiceInterface cDAO = mock(CreditoServiceInterface.class);
	private VendaNegocio negocio;
	private final String CPF = "0";
	
	@BeforeEach
	void novo() {
		negocio = new VendaNegocio(cDAO);
	}
	
	@Test @DisplayName("Checkout sem venda.")
	void checkoutSemVenda() {
		assertFalse(negocio.checkout());
	}
	
	@Test @DisplayName("Checkout sem cliente.")
	void checkoutSemCliente() {
		negocio.setVenda(new Venda(null, null));
		assertFalse(negocio.checkout());
	}
	
	@Test @DisplayName("Checkout sem CPF.")
	void checkoutSemCPF() {
		negocio.setVenda(new Venda(new Cliente(null, null), null));
		when(cDAO.getLimiteCredito(null)).thenReturn(null);
		
		assertFalse(negocio.checkout());
	}
	
	@Test @DisplayName("Checkout com CPF inválido.")
	void checkoutCPFInvalido() {
		negocio.setVenda(new Venda(new Cliente(CPF, null), null));
		when(cDAO.getLimiteCredito(CPF)).thenReturn(null);
		
		assertFalse(negocio.checkout());
	}
	
	@Test @DisplayName("Checkout sem limite de crédito.")
	void checkoutSemLimite() {
		negocio.setVenda(new Venda(new Cliente(CPF, null), BigDecimal.valueOf(10.0)));
		when(cDAO.getLimiteCredito(CPF)).thenReturn(BigDecimal.valueOf(5.0));
		
		assertFalse(negocio.checkout());
	}
	
	@Test @DisplayName("Checkout.")
	void checkout() {
		negocio.setVenda(new Venda(new Cliente(CPF, null), BigDecimal.valueOf(10.0)));
		when(cDAO.getLimiteCredito(CPF)).thenReturn(BigDecimal.valueOf(10.0));
		
		assertTrue(negocio.checkout());
	}
}