package br.com.ITDD.calculadora;

public class Calculadora {

	public int somar(int... valores) {
		if (valores == null || valores.length == 0)  
			return 0;
		
		int total = 0;
		for (int valor : valores) {
			total += valor;
		}
		
		return total;
	}
}