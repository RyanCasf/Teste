package br.com.primitivo.retangulo;

public class RetanguloTeste {

    private Retangulo retangulo;

    public void testeCalcularArea() {
        retangulo = new Retangulo(10, 10);

        final int RESULTADO_ESPERADO = 100;
        final int RESULTADO_ENCONTADO = retangulo.calcularArea();

        if (RESULTADO_ESPERADO == RESULTADO_ENCONTADO) {
            System.out.println("C�lculo da �rea do ret�ngulo CORRETO!");
        }
        else {
            System.err.println("C�lculo da �rea do ret�ngulo INCORRETO!");
        }
    }

    public void testeCalcularPerimetro() {
        retangulo = new Retangulo(10, 10);

        final int RESULTADO_ESPERADO = 40;
        final int RESULTADO_ENCONTADO = retangulo.calcularPerimetro();

        if (RESULTADO_ESPERADO == RESULTADO_ENCONTADO) {
            System.out.println("C�lculo do per�metro do ret�ngulo CORRETO!");
        }
        else {
            System.err.println("C�lculo do per�metro do ret�ngulo INCORRETO!");
        }
    }
}