package br.com.IDAO;

public class SalaNegocio {
	
	private Sala sala;
	
	public void salvar() {
		if (sala.getDescricao() == null || sala.getDescricao().trim().isEmpty()) {
			return;
		}
		
		SalaDAO sDAO = IDAO.criarSalaDAO();
		sDAO.salvar(sala);
	}
}