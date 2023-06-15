package br.com.DID.pilha;

public class Pilha {
	
	private PilhaInterface pDAO;
	
	public Pilha(PilhaInterface pDAO) {
		if (pDAO == null) {
			throw new NullPointerException("pDAO is null");
		}
		
		this.pDAO = pDAO;
	}
}