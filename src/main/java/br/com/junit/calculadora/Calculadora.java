package br.com.junit.calculadora;

public class Calculadora {

    private Calculadora() {
        throw new IllegalStateException("Utility class");
    }

    public static double somar(Number... numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers is null");
        }

        if (numbers.length <= 0) {
            return 0.0d;
        }

        double total = 0.0d;
        for (Number number : numbers) {
            total += number != null ? number.doubleValue() : 0.0d;
        }

        return total;
    }
}