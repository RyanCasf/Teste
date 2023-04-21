package br.com.DPilha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Pilha")
class PilhaTest {
	
	private Pilha pilha;
	
	@BeforeEach
	void novo() {
		pilha = new Pilha(new FakePilhaDAO());
	}
	
	@Test @DisplayName("Construtor fake.")
	void construtorFake() {
		assertDoesNotThrow(() -> pilha.push(null));
	}
}