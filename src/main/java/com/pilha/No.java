package com.pilha;

public class No {

    //Declaração das variáveis
    private int dado;
    private No refNo = null;

    //Criação construtor vazio da classe
    public No() {
    }

    //Criação do construtor da classe
    public No(int dado) {
        this.dado = dado;
    }

    //Criação de getters e setters
    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    //Criação método de sobrescrita

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
