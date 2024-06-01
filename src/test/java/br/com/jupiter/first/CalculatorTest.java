package br.com.jupiter.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private Calculator calculator = new Calculator();
	
	@Test
	void addition() {
		assertEquals(2, calculator.add(1, 1));
	}
	
	public class Calculator {
		public int add(int number1, int number2) {
			return number1 + number2;
		}
	}
}