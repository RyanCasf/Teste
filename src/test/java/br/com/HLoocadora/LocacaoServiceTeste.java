package br.com.HLoocadora;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Locação Service")
class LocacaoServiceTeste {
	
	private LocacaoService service;
	
	@BeforeEach
	void novo() {
		service = new LocacaoService();
	}
	
	@Test @DisplayName("Alugar filme com usuário nulo.")
	void alugarFilmeUsuarioNulo() {
		Locacao encontrado = service.alugarFilme(null, new Filme());
		assertNull(encontrado.getUsuario());
	}
	
	@Test @DisplayName("Alugar filme com filme nulo.")
	void alugarFilmeNulo() {
		Locacao encontrado = service.alugarFilme(new Usuario(), null);
		assertNull(encontrado.getFilme());
		assertNull(encontrado.getValor());
	}
	
	@Test @DisplayName("Alugar filme com usuário e filme nulos.")
	void alugarFilmeUsuarioNuloEFilmeNulo() {
		Locacao encontrado = service.alugarFilme(null, null);
		assertNull(encontrado.getUsuario());
		assertNull(encontrado.getFilme());
		assertNull(encontrado.getValor());
	}
	
	@Test @DisplayName("Alugar filme validar data atual em locação.")
	void alugarFilmeDataLocacaoAtual() {
		Locacao encontrado = service.alugarFilme(null, null);
		assertEquals(0, LocalDate.now().compareTo(encontrado.getDataLocacao()));
	}
	
	@Test @DisplayName("Alugar filme validar data retorno para +1.")
	void alugarFilmeDataRetorno() {
		Locacao encontrado = service.alugarFilme(null, null);
		assertEquals(0, LocalDate.now().plusDays(1).compareTo(encontrado.getDataRetorno()));
	}
	
	@Test @DisplayName("Alugar filme.")
	void alugarFilme() {
		Filme filme = new Filme();
		filme.setPrecoLocacao(BigDecimal.TEN);
		
		Locacao encontrado = service.alugarFilme(new Usuario(), filme);
		assertNotNull(encontrado.getUsuario());
		assertNotNull(encontrado.getFilme());
		assertEquals(0, encontrado.getValor().compareTo(BigDecimal.TEN));
	}
}