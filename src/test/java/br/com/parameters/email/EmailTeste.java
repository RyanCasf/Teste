package br.com.parameters.email;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.util.StringNullAndEmptySource;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("E-mail")
class EmailTeste {
	
	@ParameterizedTest(name = "Valor: ''{0}''.")
    @ValueSource(strings = {"dale", "dale@", "dale@gmail.com", "@"})
	@DisplayName("Valid��o com e-mails v�lidos.")
    void validarEmailValido(String email) {
        assertTrue(Email.validar(email));
    }
	
	@ParameterizedTest(name = "Valor: ''{0}''.")
	@ArgumentsSource(StringNullAndEmptySource.class)
    @DisplayName("Valid��o com e-mails inv�lidos.")
    void validarEmailInvalido(String email) {
        assertFalse(Email.validar(email));
    }
}