package base.lista;

/**
 * Criação da classe nó
 * com wildcard pois será utilizado index
 */
public class No<T> {

    //Definição variável do tipo genérico
    private T conteudo;
    private No proximoNo;

    //Criação do construtor vazio
    public No() {
        this.proximoNo = null;
    }

    //Criação construtor conteudo
    public No(T conteudo) {
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    //Criação construtor com ambos os parâmetros da classe
    public No(T conteudo, No proximoNo) {
        this.conteudo = conteudo;
        this.proximoNo = proximoNo;
    }

    //Criação de métodos get e set
    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }

    //Criação método toString para "conteúdo"
    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    //Criação método toString personalizado para teste
    public String toStringEncadeado() {
        String str = "No{" +
                "conteudo=" + conteudo +
                '}';

        if (proximoNo != null) {
            str += "-->" + proximoNo.toString();
        } else {
            str += "--> null";
        }
        return str;
    }
}
