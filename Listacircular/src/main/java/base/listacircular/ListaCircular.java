package base.listacircular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    //Construtor padrão
    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }


    /**
     * Implementação do método add()
     */
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        //Testar se lista está vazia
        if(this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }


    /**
     * Implementação método remove()
     */
    public void remove(int index){
        //Testar se o índice existe
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice não existe.");
        No<T> noAuxiliar = this.cauda;
        //Se o nó a ser removido é a cauda da lista
        if(index == 0){
            //Transformar o próximo nó na cauda da lista
            this.cauda = this.cauda.getNoProximo();
            //Ajustar a referência de memória da cabeça da lista
            this.cabeca.setNoProximo(this.cauda);
        //Se o índice for 1
        } else if(index == 1){
            //Seta a cauda como o nó 2
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        //Se o índice não for nem 0 ou 1, correr lista até encontrá-lo
        } else {
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }



    /**
     * Implementação método getNo(),
     * interno da classe
     */
    private No<T> getNo(int index) {
        //Testar se lista está vazia
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia.");
        //Para elemento na primeira posição
        if(index == 0){
            return this.cauda;
        }
        //Caso o elemento não seja o de índice 0, percorrer a lista
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }


    /**
     * Implementação método isEmpty()
     */

    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }


    /**
     * Implementação método size
     */
    public int size(){
        return this.tamanhoLista;
    }


    /**
     * Implementação método toString()
     */
    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;

        for(int i = 0; i < this.size(); i++){
            strRetorno += "[No{Conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += this.size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;
    }
}
