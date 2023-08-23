package br.com.mock.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Pessoa")
class PessoaTeste {
	
	@Test @DisplayName("Retorno falar.")
	void falar() {
		Pessoa pessoa = Mockito.mock(Pessoa.class);
		Mockito.when(pessoa.falar()).thenReturn("Ol� mundo!");
		
		assertEquals("Ol� mundo!", pessoa.falar());
	}
}