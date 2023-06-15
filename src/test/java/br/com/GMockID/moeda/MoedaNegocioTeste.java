package br.com.GMockID.moeda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Moeda Negócio")
class MoedaNegocioTeste {
	
	private MoedaDAO mDAO = Mockito.mock(MoedaDAO.class);
	private MoedaNegocio negocio;
	
	@BeforeEach
	void novo() {
		negocio = new MoedaNegocio(mDAO);
	}
	
	@Test @DisplayName("Salvar com símbolo nulo.")
    void salvarSimboloNulo() throws Exception {
		negocio.getMoeda().setSimbolo(null);
		assertNull(negocio.salvar());
    }
	
	@Test @DisplayName("Salvar com símbolo vazio.")
    void salvarSimboloVazio() throws Exception {
		negocio.getMoeda().setSimbolo("   ");
		assertNull(negocio.salvar());
    }
	
	@Test @DisplayName("Salvar com exceção de acesso.")
    void salvarExceptionAcesso() {
		negocio.getMoeda().setSimbolo("Teste");
		
		when(mDAO.salvar(negocio.getMoeda())).thenThrow(new RuntimeException());
		
		assertThrows(RuntimeException.class, () -> negocio.salvar());
		verify(mDAO).salvar(negocio.getMoeda());
    }
	
	@Test @DisplayName("Salvar.") 
    void salvar() throws Exception {
		negocio.getMoeda().setChave(1l);
		negocio.getMoeda().setSimbolo("Teste");
		
		when(mDAO.salvar(negocio.getMoeda())).thenReturn(1l);
		
		assertEquals(1l, negocio.salvar());
		verify(mDAO).salvar(negocio.getMoeda());
    }
}