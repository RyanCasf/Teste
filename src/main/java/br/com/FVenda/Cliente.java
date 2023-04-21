package br.com.FVenda;

public class Cliente {
	
	private String cpf;
	private String nome;
	
	public Cliente(final String cpf, final String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
}