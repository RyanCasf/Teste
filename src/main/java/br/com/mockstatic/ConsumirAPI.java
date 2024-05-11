package br.com.mockstatic;

public class ConsumirAPI {
	
	private ConsumirAPI() {
		throw new IllegalStateException("Classe utilit�ria!");
	}
	
	public static boolean enviar() {
		return VersaoID.incrementar();
	}
}