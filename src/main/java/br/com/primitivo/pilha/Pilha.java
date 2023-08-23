package br.com.primitivo.pilha;

public class Pilha<E> {

    private Node<E> first;
    private final int LIMITE;

    public Pilha(final int LIMITE) throws IllegalArgumentException {
        if (LIMITE <= 0) {
            throw new IllegalArgumentException("limit is illegal");
        }

        this.LIMITE = LIMITE;
    }

    public void push(E e) {
        if (tamanho() >= LIMITE) {
            return;
        }

        Node<E> old = first;
        first = new Node<E>();
        first.item = e;
        first.next = old;
    }

    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }

    private int tamanho() {
        if (first == null || first.item == null) {
            return 0;
        }

        Node<E> temp = first;
        int quantidade = 1;
        while (temp.next != null) {
            temp = temp.next;
            quantidade++;
        }

        return quantidade;
    }
}