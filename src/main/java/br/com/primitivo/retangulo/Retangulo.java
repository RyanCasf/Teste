package br.com.primitivo.retangulo;

public class Retangulo {

    private int base;
    private int altura;

    public int calcularArea() {
        return base * altura;
    }

    public int calcularPerimetro() {
        return (2 * base) + (2 * altura);
    }

    public Retangulo(final int base, final int altura) {
        this.base = base;
        this.altura = altura;
    }
}