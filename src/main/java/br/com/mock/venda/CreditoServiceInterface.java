package br.com.mock.venda;

import java.math.BigDecimal;

public interface CreditoServiceInterface {
	
	/*
	 * @param String cpf identificador do cliente
	 * @return BigDecimal positivo para qualquer valor válido encontrado e null aos demais
	 */
	BigDecimal getLimiteCredito(String cpf);
}