package com.pilha;

public class Main {

    public static void main(String[] args) {

        Pilha minhaPilha = new Pilha();

        //Realizar empilhamento
        minhaPilha.push(new No(1));
        minhaPilha.push(new No(2));
        minhaPilha.push(new No(3));
        minhaPilha.push(new No(4));
        minhaPilha.push(new No(5));
        minhaPilha.push(new No(6));

        //Exibir pilha
        System.out.println(minhaPilha);

        //Retirar nó da pilha
        System.out.println(minhaPilha.pop());
        System.out.println(minhaPilha);

        //Inserir nó na pilha
        System.out.println(new No(99));
        System.out.println(minhaPilha);
    }
}
