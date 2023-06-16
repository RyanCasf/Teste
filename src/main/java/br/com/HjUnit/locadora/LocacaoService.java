package br.com.HjUnit.locadora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) {
		if (usuario == null)
			throw new NullPointerException("Param usuario is null");
		
		if (filmes == null || filmes.isEmpty())  
			throw new NullPointerException("Param filme is null");
		
		Integer quantidadeEstoque = 0;
		for (Filme filme : filmes) {
			quantidadeEstoque += filme.getEstoque() != null ? filme.getEstoque() : 0;
		}
		
		if (quantidadeEstoque == 0)
			throw new ValidacaoException("Filmes sem estoque");
		
		BigDecimal valorFilmes = BigDecimal.ZERO;
		for (Filme filme : filmes) {
			BigDecimal valorFilme = filme.getPrecoLocacao() != null ? filme.getPrecoLocacao() : BigDecimal.ZERO;
			valorFilmes = valorFilmes.add(valorFilme);
		}
		
		Locacao locacao = new Locacao();
		final int QUANTIDADE_DIAS_PARA_RETORNO = 1;
		
		locacao.setUsuario(usuario);
		locacao.setFilmes(filmes);
		locacao.setDataLocacao(LocalDate.now());
		locacao.setValor(valorFilmes);
		locacao.setDataRetorno(locacao.getDataLocacao().plusDays(QUANTIDADE_DIAS_PARA_RETORNO));
		
		return locacao;
	}
}