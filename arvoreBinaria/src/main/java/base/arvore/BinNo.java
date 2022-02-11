package base.arvore;

public class BinNo<T extends Comparable<T>> {

    //Declaração variáveis
    private T conteudo;
    private BinNo<T> noEsquerdo;
    private BinNo<T> noDireito;

    //Criação construtor do conteúdo
    public BinNo(T conteudo) {
        this.conteudo = conteudo;
         noEsquerdo = noDireito = null;
    }

    public BinNo() {

    }

    //Construção métodos get e set
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public BinNo<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(BinNo<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public BinNo<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(BinNo<T> noDireito) {
        this.noDireito = noDireito;
    }

    //Construção toString() somente para conteúdo
    @Override
    public String toString() {
        return "BinNo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
