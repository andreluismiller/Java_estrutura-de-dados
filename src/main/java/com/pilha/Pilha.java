package com.pilha;

public class Pilha {

    private No refEntradaPilha;

    //Criação do construtor vazio da pilha
    public Pilha() {
        this.refEntradaPilha = null;
    }

    /**
     * Implementação método push()
     * Acrescenta nó no topo da pilha
     */
    public void push(No novoNo) {
        //Variável para guardar referência de entrada na pilha
        No refAuxiliar = refEntradaPilha;
        //Setar nova referência de topo
        refEntradaPilha = novoNo;
        //A nova referência de nó é a antiga referência de topo
        refEntradaPilha.setRefNo(refAuxiliar);
    }


    /**
     * Implementação método pop()
     * Exclui o último elemento da pilha
     */
    public No pop() {
        if(!this.isEmpty()) {
            No noPoped = refEntradaPilha;
            refEntradaPilha = refEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }


    /**
     * Implementação método top()
     * Simplesmente retorna a referência do nó no topo da pilha
     */
    public No top() {
        return refEntradaPilha;
    }


    /**
     * Implementação método isEmpty()
     * Verifica se a pilha de fato existe
     */
    public boolean isEmpty() {
        if(refEntradaPilha == null) {
            return true;
        }
        return false;
        //Sintaxe equivalente if: return refEntradaPilha == null? true : false;
    }

    //Implementação método toString da classe Pilha
    @Override
    public String toString() {

        String stringRetorno = "------------\n";
        stringRetorno += "      Pilha\n";
        stringRetorno += "------------\n";

        No noAuxiliar = refEntradaPilha;

        while (true) {
            if (noAuxiliar != null) {
                //Concatenar dado do primeiro nó com a string
                stringRetorno += "[No{dado= " + noAuxiliar.getDado() + "}]\n";
                //navegar para o próximo nó
                noAuxiliar = noAuxiliar.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "============\n";
        return stringRetorno;
    }

}
