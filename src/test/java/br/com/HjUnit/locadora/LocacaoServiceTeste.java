package br.com.HjUnit.locadora;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	void alugarFilmeLancarNullPointerExceptionPorParametrosNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(null, null));
	}
	
	@Test
	void alugarFilmeLancarNullPointerExceptionPorUsuarioNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(null, new ArrayList<Filme>()));
	}
	
	@Test
	void alugarFilmeLancarNullPointerExceptionPorFilmesNulo() {
		assertThrows(NullPointerException.class, () -> service.alugarFilme(new Usuario(), null));
	}
	
	@Test
	void alugarFilmeLancarNullPointerExceptionPorFilmesVazio() {
		List<Filme> filmes = new ArrayList<Filme>();
		assertThrows(NullPointerException.class, () -> service.alugarFilme(new Usuario(), filmes));
	}
	
	@Test
	void alugarFilmeLancarValidacaoExceptionPorEstoqueFilmeNulo() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme());
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test
	void alugarFilmeLancarValidacaoExceptionPorEstoqueFilmeZerado() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 0, null));
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test
	void alugarFilmeLancarValidacaoExceptionPorEstoqueFilmesZerado() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 0, null), new Filme("Filme A", null, null), new Filme("Filme A", 0, null));
		
		assertThrows(ValidacaoException.class, () -> service.alugarFilme(usuario, filmes));
	}
	
	@Test
	void alugarFilmeVerificarDataRetornoMaisUm() {
		Usuario usuario = new Usuario();
		List<Filme> filmes = List.of(new Filme("Filme A", 1, null));
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertTrue(LocalDate.now().plusDays(1).isEqual(locacao.getDataRetorno()));
	}
	
	@Test
	void deveAlugarFilmeCom75PorcentoDeDescontoParaTerceiroFilme() {
		fail();
	}
	
	@Test
	void alugarFilmeComSucesso() {
		Usuario usuario = new Usuario("usuario");
		List<Filme> filmes = List.of(new Filme("Filme A", 1, BigDecimal.ONE));
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals("usuario", locacao.getUsuario().getNome());
		assertEquals("Filme A", locacao.getFilmes().get(0).getNome());
		assertTrue(LocalDate.now().isEqual(locacao.getDataLocacao()));
		assertEquals(0, BigDecimal.ONE.compareTo(locacao.getValor()));
	}
}