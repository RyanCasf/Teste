package br.com.DID.pilha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Pilha")
class PilhaTeste {
	
	@Test @DisplayName("Construtor nulo.")
	void construtorNulo() {
		assertThrows(NullPointerException.class, () -> new Pilha(null));
	}
	
	@Test @DisplayName("Construtor injetado.")
	void construtorInjetado() {
		assertDoesNotThrow(() -> new Pilha(new FakePilhaDAO()));
	}
	
	@Test @DisplayName("Construtor mocado.")
	void construtorMocado() {
		PilhaInterface pDAO = Mockito.mock(PilhaInterface.class);	
		assertDoesNotThrow(() -> new Pilha(pDAO));
	}
}