package br.com.jupiter.displayname;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DisplayNameParameterizedName {
	
	@DisplayName("A negative value for year is not supported by the leap year computation.")
	@ParameterizedTest(name = "For example, year {0} is not supported.")
	@ValueSource(ints = { -1, -4 })
	void if_it_is_negative(int year) {
		Assertions.assertTrue(year < 0);
	}
}