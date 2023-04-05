package br.com.Aprimitivo.pilha;

public class PilhaTeste {

    private Pilha pilha;

    public boolean testeLimiteNegativo() {
        try {
            pilha = new Pilha(-1);
            return false;
        }
        catch (IllegalArgumentException e) {
            return true;
        }
    }

    public boolean testeLimiteZerado() {
        try {
            pilha = new Pilha(0);
            return false;
        }
        catch (IllegalArgumentException e) {
            return true;
        }
    }

    public boolean testeRetiraUltimoValor() {
        pilha = new Pilha(5);
        pilha.push("1");
        pilha.push("2");
        pilha.push("3");

        final Object RESULTADO_ESPERADO = "3";
        final Object RESULTADO_ENCONTRADO = pilha.pop();

        return (RESULTADO_ESPERADO.equals(RESULTADO_ENCONTRADO));
    }

    public boolean testeNaoAdicionaAlemDoLimite() {
        pilha = new Pilha(5);
        pilha.push("1");
        pilha.push("2");
        pilha.push("3");
        pilha.push("4");
        pilha.push("5");
        pilha.push("6");
        pilha.push("7");

        final Object RESULTADO_ESPERADO = "5";
        final Object RESULTADO_ENCONTRADO = pilha.pop();

        return (RESULTADO_ESPERADO.equals(RESULTADO_ENCONTRADO));
    }
}