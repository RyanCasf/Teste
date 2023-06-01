package br.com.IDAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Sala Negócio IDAO")
class SalaNegocioTeste {
	
	private SalaNegocio negocio;
	
	@BeforeEach
	void novo() {
		negocio = new SalaNegocio();
	}
	
	@Test @DisplayName("Salvar sem descrição.")
	void savlarSemDescricao() {
		negocio.salvar();
	}
}