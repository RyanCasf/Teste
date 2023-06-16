package br.com.ITDD.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Calculadora")
class CalculadoraTeste {
	
	private Calculadora calculadora;
	
	@BeforeAll
	void novo() {
		calculadora = new Calculadora();
	}
	
	@Test
	void deveRetornarZeroParaSomatorioComValoresNulo() {
		final int RETORNO = calculadora.somar(null);
		
		final int RESULTADO_ESPERADO = 0;
		assertEquals(RESULTADO_ESPERADO, RETORNO);
	}
	
	@Test
	void deveSomarUnicoValor() {
		final int VALOR_UNICO = 10;
		
		final int RETORNO = calculadora.somar(VALOR_UNICO);
		assertEquals(VALOR_UNICO, RETORNO);
	}
	
	@Test
	void deveSomarMultiplosValores() {
		final int VALOR_1 = 10;
		final int VALOR_2 = 10;
		final int VALOR_3 = -10;
		
		final int RETORNO = calculadora.somar(VALOR_1, VALOR_2, VALOR_3);
		
		final int RESULTADO_ESPERADO = 10;
		assertEquals(RESULTADO_ESPERADO, RETORNO);
	}
}