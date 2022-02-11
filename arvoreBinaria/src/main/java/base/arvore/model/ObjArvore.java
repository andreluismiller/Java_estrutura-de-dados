package base.arvore.model;

public abstract class ObjArvore<T extends Comparable<T>> {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract int compareTo(T outro);
    public abstract String toString();


}
