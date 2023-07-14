package br.com.HjUnit.locadora;

import java.math.BigDecimal;
import java.time.DayOfWeek;
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
		final int QUANTIDADE_FILMES = filmes.size();
		
		for (int i=0; i<QUANTIDADE_FILMES; i++) {
			BigDecimal valorFilme = filmes.get(i).getPrecoLocacao() != null ? filmes.get(i).getPrecoLocacao() : BigDecimal.ZERO;
			
			switch (i) {
				case 2: valorFilme = valorFilme.multiply(BigDecimal.valueOf(0.75)); break;
				case 3: valorFilme = valorFilme.multiply(BigDecimal.valueOf(0.50)); break;
				case 4: valorFilme = valorFilme.multiply(BigDecimal.valueOf(0.25)); break;
				case 5: continue;
				default:
			}
			
			valorFilmes = valorFilmes.add(valorFilme);
		}
		
		Locacao locacao = new Locacao();
		locacao.setUsuario(usuario);
		locacao.setFilmes(filmes);
		locacao.setDataLocacao(LocalDate.now());
		locacao.setValor(valorFilmes);
		
		locacao.setDataRetorno(locacao.getDataLocacao().plusDays(
				Locacao.getQuantidadeDiasParaRetorno(locacao.getDataLocacao().getDayOfWeek())));
		
		return locacao;
	}
}