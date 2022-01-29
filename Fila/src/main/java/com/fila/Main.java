package com.fila;

public class Main {

    public static void main(String[] args) {

        Fila<String> minhaFila = new Fila<>();

        minhaFila.enqueue("primeiro");
        minhaFila.enqueue("segundo");
        minhaFila.enqueue("terceiro");
        minhaFila.enqueue("quarto");

        System.out.println(minhaFila);

        //Retirar elemento da fila
        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila);

        //Adicionar elemento à fila
        minhaFila.enqueue("último");
        System.out.println(minhaFila);

        //Retornar primeiro elemento da fila
        System.out.println(minhaFila.first());
    }
}
