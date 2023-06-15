package br.com.CjUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.CjUnit.calculadora.Calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Calculadora")
class CalculadoraTeste {

    @Test @DisplayName("Não somar por ausência ser null.")
    void somarNull() {
        assertThrows(IllegalArgumentException.class, () -> Calculadora.somar(null));
    }

    @Test @DisplayName("Somar zero.")
    void somarZero() {
        assertEquals(0, Calculadora.somar(0.0));
    }

    @Test @DisplayName("Somar contendo valores null.")
    void somarContendoNull() {
        assertEquals(10, Calculadora.somar(null, null, 1l, 5.5d, 0.5f, null, 2, 1, null));
    }
}