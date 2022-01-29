package com.fila;

public class Fila<T> {

    private No<T> refNoEntradaFila;

    //Geração construtor
    public Fila() {
        this.refNoEntradaFila = null;
    }

    /**
     * Implementação enqueue
     * Método para enfileirar
     */
    public void enqueue(T object) {
        No novoNo = new No(object);
        //Setar novo nó como referência de entrada da fila
        novoNo.setRefNo(refNoEntradaFila);
        //Tornar o novo nó como referência de entrada
        refNoEntradaFila = novoNo;
    }

    /**
     * Implementação método First
     * Retorna o primeiro nó da fila
     */
    public T first() {
        //Testar se fila não está vazia
        if(!this.isEmpty()) {
            //Nó para receber referência de entrada da fila
            No primeiroNo = refNoEntradaFila;
            //Loop para fazer o primeiroNo virar de fato o primeiro caso a fila tenha mais de um elemento
            while(true) {
                if(primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                break;
                }
            }
            return (T) primeiroNo.getObject();

        }
        return null;
    }


    /**
     * Implementação método dequeue
     *
     */
    public T dequeue() {
        //Testar se fila não está vazia
        if(!this.isEmpty()) {
            //Nó para receber referência de entrada da fila
            No primeiroNo = refNoEntradaFila;
            //Criação de variável para pegar penúltimo elemento
            No noAuxiliar = refNoEntradaFila;
            //Loop para fazer o primeiroNo virar de fato o primeiro caso a fila tenha mais de um elemento
            while(true) {
                if(primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                } else {
                    //Transforma nó auxiliar no primeiro da fila
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }


    /**
     * Implementação isEmpty()
     * Verifica se fila está vazia
     */
    public boolean isEmpty(){
        return refNoEntradaFila == null? true : false;
    }

    /**
     * Implementação método toString()
     */
    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto = " + noAuxiliar.getObject() + "}]--->";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
