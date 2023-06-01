package br.com.IDAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS) 
@DisplayName("Sala IDAO")
class SalaTeste {
	
	@Test @DisplayName("Atributo chave.")
	void atributoChave() {
		Sala sala = new Sala();
		
		assertNull(sala.getChave());
		sala.setChave(0l);
		assertEquals(0l, sala.getChave());
	}
	
	@Test @DisplayName("Atributo descrição.")
	void atributoDescricao() {
		Sala sala = new Sala();
		
		assertNull(sala.getDescricao());
		sala.setDescricao("descricao");
		assertEquals("descricao", sala.getDescricao());
	}
}