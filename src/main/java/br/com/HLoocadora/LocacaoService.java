package br.com.HLoocadora;

import java.time.LocalDate;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		final int QUANTIDADE_DIAS_PARA_RETORNO = 1;
		
		locacao.setUsuario(usuario);
		locacao.setFilme(filme);
		locacao.setDataLocacao(LocalDate.now());
		locacao.setValor(filme != null ? filme.getPrecoLocacao() : null);
		locacao.setDataRetorno(locacao.getDataLocacao().plusDays(QUANTIDADE_DIAS_PARA_RETORNO));
		
		return locacao;
	}
}