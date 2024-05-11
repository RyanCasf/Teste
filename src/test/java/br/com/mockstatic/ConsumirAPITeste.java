package br.com.mockstatic;

import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.MockedStatic;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Consumir API")
class ConsumirAPITeste {
	
	@Test @DisplayName("Enviar com retorno falso.")
	void enviarComRetornoFalso() {
		try (MockedStatic<VersaoID> versaoID = mockStatic(VersaoID.class)) {
			versaoID.when(() -> VersaoID.incrementar()).thenReturn(false);
			Assertions.assertFalse(ConsumirAPI.enviar());
		}
	}
	
	@Test @DisplayName("Enviar.")
	void enviar() {
		try (MockedStatic<VersaoID> versaoID = mockStatic(VersaoID.class)) {
			versaoID.when(() -> VersaoID.incrementar()).thenReturn(true);
			Assertions.assertTrue(ConsumirAPI.enviar());
		}
	}
}