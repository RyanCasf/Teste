package br.com.GMoeda;

import java.util.List;

interface MoedaInterface {

    Long salvar(Moeda moeda);
    Moeda obter(Long chave);

    List<Moeda> pesquisar();
    int quantidadeLinha();
}