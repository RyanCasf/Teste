package br.com.HjUnit.locadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	@Test @DisplayName("Alugar filme com usuário e filme nulos.")
	void alugarFilmeUsuarioNuloEFilmeNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(null, null));
	}
	
	@Test @DisplayName("Alugar filme com usuário nulo.")
	void alugarFilmeUsuarioNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(null, new ArrayList<Filme>()));
	}
	
	@Test @DisplayName("Alugar filme com filme nulo.")
	void alugarFilmeNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(new Usuario(), null));
	}
	
	@Test @DisplayName("Alugar filme com filme vazio.")
	void alugarFilmeVazio() {
		List<Filme> filmes = new ArrayList<Filme>();
		assertThrows(NullPointerException.class, () -> service.alugarFilme(new Usuario(), filmes));
	}
	
	@Test @DisplayName("Alugar filme com estoque nulo.")
	void alucarFilmeEstoqueNulo() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme());
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test @DisplayName("Alugar filme com estoque zerado.")
	void alucarFilmeEstoqueZerado() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 0, null));
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test @DisplayName("Alugar filme com estoques zerados.")
	void alucarFilmeEstoquesZerados() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 0, null), new Filme("Filme A", null, null), new Filme("Filme A", 0, null));
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test @DisplayName("Alugar filme verificar data do retorno add 1.")
	void alucarFilmeVerificarDataRetornoMaisUm() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 1, null));
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertTrue(LocalDate.now().plusDays(1).isEqual(locacao.getDataRetorno()));
	}
	
	@Test @DisplayName("Alugar filme com sucesso.")
	void alucarFilmeComSucesso() {
		Usuario usuario = new Usuario("usuario");
		List<Filme> filmes = List.of(new Filme("Filme A", 1, BigDecimal.ONE));
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals("usuario", locacao.getUsuario().getNome());
		assertEquals("Filme A", locacao.getFilmes().get(0).getNome());
		assertTrue(LocalDate.now().isEqual(locacao.getDataLocacao()));
		assertEquals(0, BigDecimal.ONE.compareTo(locacao.getValor()));
	}
}