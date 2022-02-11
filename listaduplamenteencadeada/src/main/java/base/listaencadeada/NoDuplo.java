package base.listaencadeada;

//Criação classe genérica
public class NoDuplo<T> {

    private T conteudo;
    private NoDuplo<T> noPosterior;
    private NoDuplo<T> noAnterior;

    //Criação de construtor para a classe
    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    //Criação getters e setters
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoPosterior() {
        return noPosterior;
    }

    public void setNoPosterior(NoDuplo<T> noPosterior) {
        this.noPosterior = noPosterior;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    //Criação do método toString para impressão do conteúdo

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }

}
