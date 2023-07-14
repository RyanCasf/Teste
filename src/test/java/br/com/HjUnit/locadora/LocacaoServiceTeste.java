package br.com.HjUnit.locadora;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
	void deveAlugarFilmeCom25PorcentoDeDescontoParaTerceiroFilme() {
		Usuario usuario = new Usuario("Usuario1");
		List<Filme> filmes = Arrays.asList(
				new Filme("1", 2, BigDecimal.valueOf(4.0d)),
				new Filme("2", 2, BigDecimal.valueOf(4.0d)),
				new Filme("3", 2, BigDecimal.valueOf(4.0d))
		);
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals(0, locacao.getValor().compareTo(BigDecimal.valueOf(11)));
	}
	
	@Test
	void deveAlugarFilme50PorcentoDeDescontoParaQuartoFilme() {
		Usuario usuario = new Usuario("Usuario1");
		List<Filme> filmes = Arrays.asList(
				new Filme("1", 2, BigDecimal.valueOf(4.0d)),
				new Filme("2", 2, BigDecimal.valueOf(4.0d)),
				new Filme("3", 2, BigDecimal.valueOf(4.0d)),
				new Filme("4", 2, BigDecimal.valueOf(4.0d))
		);
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals(0, locacao.getValor().compareTo(BigDecimal.valueOf(13)));
	}
	
	@Test
	void deveAlugarFilme75PorcentoDeDescontoParaQuintoFilme() {
		Usuario usuario = new Usuario("Usuario1");
		List<Filme> filmes = Arrays.asList(
				new Filme("1", 2, BigDecimal.valueOf(4.0d)),
				new Filme("2", 2, BigDecimal.valueOf(4.0d)),
				new Filme("3", 2, BigDecimal.valueOf(4.0d)),
				new Filme("4", 2, BigDecimal.valueOf(4.0d)),
				new Filme("5", 2, BigDecimal.valueOf(4.0d))
		);
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals(0, locacao.getValor().compareTo(BigDecimal.valueOf(14)));
	}
	
	@Test
	void deveAlugarFilme100PorcentoDeDescontoParaSextoFilme() {
		Usuario usuario = new Usuario("Usuario1");
		List<Filme> filmes = Arrays.asList(
				new Filme("1", 2, BigDecimal.valueOf(4.0d)),
				new Filme("2", 2, BigDecimal.valueOf(4.0d)),
				new Filme("3", 2, BigDecimal.valueOf(4.0d)),
				new Filme("4", 2, BigDecimal.valueOf(4.0d)),
				new Filme("5", 2, BigDecimal.valueOf(4.0d)),
				new Filme("6", 2, BigDecimal.valueOf(4.0d))
		);
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		assertEquals(0, locacao.getValor().compareTo(BigDecimal.valueOf(14)));
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