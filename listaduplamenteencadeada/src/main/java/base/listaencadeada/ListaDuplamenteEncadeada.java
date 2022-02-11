package base.listaencadeada;

//Criação da classe lista encadeada de tipo genérico
public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    //Criação variável para que os métodos não tenham que percorrer toda a lista
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }


    /**
     * Implementação do método size(),
     * retorna o tamanho da lista
     */
    private int size() {
        return this.tamanhoLista;
    }


    /**
     * Implementação do método get()
     * retorna o elemento de índice n
     */
    public T get(int index) {
        return this.getNo(index).getConteudo();
    }


    /**
     * Implementação do método add(),
     * não possui retorno, adiciona elemento à lista
     */
    public void add(T elemento) {
        //Criação variável para guardar novo nó
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        //Adição novo nó ao final da lista
        novoNo.setNoPosterior(null);
        //NoAnterior agora aponta para o penúltimo nó
        novoNo.setNoAnterior(ultimoNo);

        if(primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setNoPosterior(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }


    /**
     * Implementação do método add(index)
     * adiciona elemento à lista por meio do índice
     */
    public void add(int index, T elemento) {
        //Variável para receber nó do índice passado
        NoDuplo<T> noAuxiliar = getNo(index);
        //Variável para receber nó a ser inserido
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoPosterior(noAuxiliar);

        //Inserção > condição caso o nó não seja o último
        if(novoNo.getNoPosterior() != null){
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getNoPosterior().setNoAnterior(novoNo);
            //Inserção > condição caso o nó seja o último
        } else {
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        //Inserção > condição caso a inserção seja no primeiro nó
        if(index == 0) {
            primeiroNo = novoNo;
        } else {
            novoNo.getNoAnterior().setNoPosterior(novoNo);
        }
        //Incrementar tamanho da lista após adição
        tamanhoLista++;
    }


    /**
     * Implementação do método remove()
     */
    public void remove(int index) {
        //Teste para verificar se o elemento é o primeiro da lista
        if(index == 0){
            primeiroNo = primeiroNo.getNoPosterior();
            //Verificar se primeiroNo existe na lista
            if(primeiroNo != null) {
                primeiroNo.setNoAnterior(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoAnterior().setNoPosterior(noAuxiliar.getNoPosterior());
            if(noAuxiliar != ultimoNo) {
                noAuxiliar.getNoPosterior().setNoAnterior(noAuxiliar.getNoAnterior());
            } else {
                ultimoNo = noAuxiliar;
            }
        }
        //Decrementar tamanho da lista após remoção
        this.tamanhoLista--;
    }


    /**
     * Implementação método toString()
     */
    @Override
    public String toString() {
        String strRetorno = "";

        //Correr a lista pelo primeiro nó
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{Conteudo=" + noAuxiliar.getConteudo() + "}]>>>";
            noAuxiliar = noAuxiliar.getNoPosterior();
        }
        strRetorno += "null";
        return strRetorno;
    }


    /**
     * Implementação do método getNo(),
     * de uso interno da classe
     */
    private NoDuplo<T> getNo(int index) {
        //Variável para percorrer lista
        NoDuplo<T> noAuxiliar = primeiroNo;

        //Declaração estrutura de repetição com duas condições de parada (entre os &&)
        //Enquanto o nó em questão não for o último, repetir a estrutura
        for(int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoPosterior();
        }
        return noAuxiliar;
    }







}
