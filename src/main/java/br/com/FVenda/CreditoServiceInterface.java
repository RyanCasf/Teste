package br.com.FVenda;

import java.math.BigDecimal;

interface CreditoServiceInterface {
	
	/*
	 * @param String cpf identificador do cliente
	 * @return BigDecimal positivo para qualquer valor válido encontrado e null aos demais
	 */
	BigDecimal getLimiteCredito(String cpf);
}