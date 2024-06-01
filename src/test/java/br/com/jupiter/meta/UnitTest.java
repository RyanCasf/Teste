package br.com.jupiter.meta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

class UnitTest {
	
	@UnitShape
	@DisplayName("Meta.")
	void meta() {
		Assertions.assertTrue(1 == 1);
	}
}