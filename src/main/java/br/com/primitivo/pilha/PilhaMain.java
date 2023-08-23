package br.com.primitivo.pilha;

public class PilhaMain {

    public static void main(String[] args) {
        PilhaTeste teste = new PilhaTeste();

        System.out.println("Teste de pilha com limite negativo: " + teste.testeLimiteNegativo());
        System.out.println("Teste de pilha com limite zerado: " + teste.testeLimiteZerado());
        System.out.println("Teste de pilha com pop do �ltimo valor: " + teste.testeRetiraUltimoValor());
        System.out.println("Teste de pilha de n�o adicionar al�m do limite: " + teste.testeNaoAdicionaAlemDoLimite());
    }
}