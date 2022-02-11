package base.lista;

//Criação classe com tipo genético
public class listaEncadeada<T> {

    //Criação de referência de nó de entrada da lista
    No<T> referenciaEntrada;

    //Criação do construtor padrão
    public listaEncadeada() {
        this.referenciaEntrada = null;
    }

    /**
     * Declaração método add()
     * recebe conteúdo e adiciona um novo nó à lista
     */
    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        //Primeiro testa se lista está vazia
        if(this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;

        }
        //Nó para receber referência de entrada
        No<T> noAuxiliar = referenciaEntrada;
        //Percorrer lista
        for (int i = 0; i < this.size()-1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();

        }
        //Quando chega no último nó, noAuxiliar é setado como novo nó
        noAuxiliar.setProximoNo(novoNo);
    }


    /**
     * Implementação do método get(),
     * que não retorna o nó, mas sim o conteúdo do nó
     */
    public T get(int index) {
        return getNo(index).getConteudo();
    }



    /**
     * Implementação do método getNo(),
     * útil aos métodos get() e remove()
     * Como é interno da classe, trata-se de um método privado
     */
    private No<T> getNo(int index) {
        //Validar se o indice passado de fato existe na lista
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;

    }


    /**
     * Implementação do método remove(),
     * retorna o conteúdo do nó removido
     */
    public T remove(int index) {
        //Declaração do nó a ser removido, utilizando o método getNo()
        No<T> noPivo = this.getNo(index);

        //Condição para a remoção do primeiro nó
        if(index == 0) {
            //Passa a referência do noPivo do nó 0 para o nó 1
            referenciaEntrada = noPivo.getProximoNo();
            return noPivo.getConteudo();
        }
        //Caso o nó especificado não seja o primeiro
        //Considera tanto o nó especificado quanto o nó anterior a ele
        No<T> noAnterior = getNo(index - 1);
        //Liga o no referência ao nó dois índices acima
        noAnterior.setProximoNo(noPivo.getProximoNo());
        //Como não existe referência de noPivo neste ponto, a JVM o deletará
        return noPivo.getConteudo();

    }




    /**
     * Declaração do método size()
     * retorna o tamanho da lista
     */
    public int size() {
        //Criação variável para guardar tamanho da lista
        int tamanhoLista = 0;
        No<T> referenciaAuxiliar = referenciaEntrada;

        while(true) {
            //Se a lista não for vazia, incrementar o tamanho da lista
            if (referenciaAuxiliar != null) {
                tamanhoLista++;
                //Se houver um próximo nó, apontar variável de referência do nó para ele
                if (referenciaAuxiliar.getProximoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;


    }




    /**
     * Método para validar índice passado como parâmetro
     */
    public void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = size() - 1;
            //Lançar exceção
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + "desta lista. Tal lista vai até o índice " + ultimoIndice);
        }

    }



    /**
     * Declaração do método isEmpty()
     * verifica se lista está ou não vazia
     */
    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }




    /**
     * Declaração do método toString(),
     * útil para a visualização
     */
    @Override
    public String toString() {
        //Declaração variável que guardará conteúdo a ser retornado
        String strRetorno = "";

        //Declaração estrutura para percorrer a lista
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size(); i++) {
            strRetorno +=  "[No{conteudo=" + noAuxiliar.getConteudo() + "}---->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        //Último nó, cujo valor é nulo
        strRetorno += "null";
        return strRetorno;
    }

}
