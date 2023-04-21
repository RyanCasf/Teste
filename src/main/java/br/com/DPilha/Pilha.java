package br.com.DPilha;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
	
	private List<String> pilha;
	private PilhaInterface pDAO;
	
	public Pilha(PilhaInterface pDAO) {
		pilha = new ArrayList<String>();
		this.pDAO = pDAO;
	}
	
	public void push(final String result) {
		pilha.add(result);
		pDAO.salvar(this);
	}
}