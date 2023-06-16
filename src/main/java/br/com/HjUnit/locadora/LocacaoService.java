package br.com.HjUnit.locadora;

import java.time.LocalDate;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		if (usuario == null)
			throw new NullPointerException("Param usuario is null");
		
		if (filme == null) 
			throw new NullPointerException("Param filme is null");
		
		if (filme.getEstoque() == null || filme.getEstoque() == 0)
			throw new ValidacaoException("Filme sem estoque");
		
		Locacao locacao = new Locacao();
		final int QUANTIDADE_DIAS_PARA_RETORNO = 1;
		
		locacao.setUsuario(usuario);
		locacao.setFilme(filme);
		locacao.setDataLocacao(LocalDate.now());
		locacao.setValor(filme.getPrecoLocacao());
		locacao.setDataRetorno(locacao.getDataLocacao().plusDays(QUANTIDADE_DIAS_PARA_RETORNO));
		
		return locacao;
	}
}