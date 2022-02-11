package base.listaencadeada;

public class Main {

    public static void main(String[] args){
        //Declaração lista
        ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

        //Uso método add()
        minhaListaEncadeada.add("c1");
        minhaListaEncadeada.add("c2");
        minhaListaEncadeada.add("c3");
        minhaListaEncadeada.add("c4");
        minhaListaEncadeada.add("c5");
        minhaListaEncadeada.add("c6");
        minhaListaEncadeada.add("c7");

        System.out.println(minhaListaEncadeada);

        //Uso método remove()
        minhaListaEncadeada.remove(3);
        minhaListaEncadeada.add(3, "99");

        System.out.println(minhaListaEncadeada);

        //Imprimir conteúdo índice específico
        System.out.println(minhaListaEncadeada.get(3));

    }
}
