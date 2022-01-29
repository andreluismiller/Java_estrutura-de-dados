package com.fila;

public class No<T> {

    private T object;
    private No<T> refNo;

    //Criação construtor vazio
    public No() {
    }

    //Criação construtor
    public No (T object) {

        this.refNo = null;
        this.object = object;
    }

    //Implementação getters and setters

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    //Implementação sobrescrita na classe

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
