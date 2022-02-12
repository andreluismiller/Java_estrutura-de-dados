package base.implementacao;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Carro> listaCarros = new ArrayList<>();

        listaCarros.add(new Carro("ford"));
        listaCarros.add(new Carro("fiat"));
        listaCarros.add(new Carro("bmw"));

        System.out.println(listaCarros.contains(new Carro("ford")));

        System.out.println(new Carro("ford").hashCode());

        Carro carro1 = new Carro("ford");
        Carro carro2 = new Carro("fiat");

        System.out.println(carro1.equals(carro2));




    }

}
