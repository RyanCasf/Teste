package br.com.primitivo.retangulo;

public class RetanguloTeste {

    private Retangulo retangulo;

    public void testeCalcularArea() {
        retangulo = new Retangulo(10, 10);

        final int RESULTADO_ESPERADO = 100;
        final int RESULTADO_ENCONTADO = retangulo.calcularArea();

        if (RESULTADO_ESPERADO == RESULTADO_ENCONTADO) {
            System.out.println("Cálculo da área do retângulo CORRETO!");
        }
        else {
            System.err.println("Cálculo da área do retângulo INCORRETO!");
        }
    }

    public void testeCalcularPerimetro() {
        retangulo = new Retangulo(10, 10);

        final int RESULTADO_ESPERADO = 40;
        final int RESULTADO_ENCONTADO = retangulo.calcularPerimetro();

        if (RESULTADO_ESPERADO == RESULTADO_ENCONTADO) {
            System.out.println("Cálculo do perímetro do retângulo CORRETO!");
        }
        else {
            System.err.println("Cálculo do perímetro do retângulo INCORRETO!");
        }
    }
}