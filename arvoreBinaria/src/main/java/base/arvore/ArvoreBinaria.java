package base.arvore;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    //Construtor padrão da classe
    public ArvoreBinaria() {
        //Setar raiz como nula
        this.raiz = null;
    }



    /**
     *Construção do método inserir nó
     */
    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }
    /**
    *Construção do método inserir nó a ser instanciado
    */
     private BinNo<T> inserir(BinNo<T> noAtual, BinNo<T> novoNo){
        //Se o nó atual for nulo (raiz), retornar o novo nó
        if(noAtual == null){
            return novoNo;
        //Comparar conteúdo do novo nó com o nó atual para verificar se é menor
        } else if(novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0) {
            noAtual.setNoEsquerdo(inserir(noAtual.getNoEsquerdo(), novoNo));
        //Se o conteúdo do novo nó for maior ou igual ao do nó atual
        } else{
            noAtual.setNoDireito(inserir(noAtual.getNoDireito(), novoNo));
        }
        return noAtual;
    }


    /**
     * Implementação dos métodos de exibição
     * inOrdem()
     */
    public void exibirInOrdem(){
        System.out.println("\n Exibindo inOrdem");
        exibirInOrdem(this.raiz);
    }
    private void exibirInOrdem(BinNo<T> atual) {
        if(atual != null) {
            exibirInOrdem(atual.getNoEsquerdo());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDireito());
        }
    }

    /**
     * Implementação dos métodos de exibição
     * posOrdem()
     */
    public void exibirPosOrdem(){
        System.out.print("\n Exibindo posOrdem");
        exibirPosOrdem(this.raiz);
    }
    private void exibirPosOrdem(BinNo<T> atual) {
        if(atual != null) {
            exibirPosOrdem(atual.getNoEsquerdo());
            exibirPosOrdem(atual.getNoDireito());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    /**
     * Implementação dos métodos de exibição
     * preOrdem()
     */
    public void exibirPreOrdem(){
        System.out.print("\n Exibindo preOrdem");
        exibirPreOrdem(this.raiz);
    }
    private void exibirPreOrdem(BinNo<T> atual) {
        if(atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsquerdo());
            exibirPreOrdem(atual.getNoDireito());
        }
    }



    /**
     * Implementação do método remove()
     */
    public void remover(T conteudo){
        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while(atual != null && !atual.getConteudo().equals(conteudo)) {
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo()) < 0) {
                    atual = atual.getNoEsquerdo();
                } else{
                    atual = atual.getNoDireito();
                }
            }

            if(atual == null){
                System.out.println("Conteúdo não encontrado (bloco try)");
            }

            if(pai == null) {
                if(atual.getNoDireito() == null) {
                    this.raiz = atual.getNoEsquerdo();
                } else if(atual.getNoEsquerdo() == null){
                    this.raiz = atual.getNoDireito();
                } else{
                    for(temp = atual, filho = atual.getNoEsquerdo();
                        filho.getNoDireito() != null;
                        temp = filho, filho = filho.getNoEsquerdo()
                    ) {
                        if(filho != atual.getNoEsquerdo()) {
                            temp.setNoDireito(filho.getNoEsquerdo());
                            filho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }
                    }
                    filho.setNoDireito(raiz.getNoDireito());
                    raiz = filho;
                }
            } else if(atual.getNoDireito() == null) {
                if(pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoEsquerdo());
                } else {
                    pai.setNoDireito(atual.getNoEsquerdo());
                }
            } else if(atual.getNoEsquerdo() == null) {
                if(pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoDireito());
                } else {
                    pai.setNoDireito(atual.getNoDireito());
                }
            } else {
                for(
                        temp = atual, filho = atual.getNoEsquerdo();
                        filho.getNoEsquerdo() != null;
                        temp = filho, filho = filho.getNoDireito()
                ) {
                    if(filho != atual.getNoEsquerdo()) {
                        temp.setNoDireito(filho.getNoEsquerdo());
                        filho.setNoEsquerdo(atual.getNoEsquerdo());
                    }
                    filho.setNoDireito(atual.getNoDireito());
                    if(pai.getNoEsquerdo() == atual) {
                        pai.setNoEsquerdo(filho);
                    } else {
                        pai.setNoDireito(filho);
                    }
                }
            }

        } catch (NullPointerException erro) {
            System.out.println("Conteúdo não encontrado (bloco catch)");
        }

    }


}
