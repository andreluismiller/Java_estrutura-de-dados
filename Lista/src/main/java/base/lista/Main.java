package base.lista;

public class Main {

    /**
     * Criação método de entrada da aplicação
     */
    public static void main(String[] args) {

        //Declaração da lista
        listaEncadeada<String> minhaListaEncadeada = new listaEncadeada<>();

        //Adição do conteúdo a lista
        minhaListaEncadeada.add("teste1");
        minhaListaEncadeada.add("teste2");
        minhaListaEncadeada.add("teste3");
        minhaListaEncadeada.add("teste4");

        //Verificar se o método add está correto através do conteúdo do índice
        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));

        //Impressão de toda a lista pelo método toString()
        System.out.println(minhaListaEncadeada);

        //remover último item da lista, exibindo seu conteúdo
        System.out.println(minhaListaEncadeada.remove(3));


    }
}
