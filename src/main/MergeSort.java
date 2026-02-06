package main;

import java.util.List;
import java.util.ArrayList;

public class MergeSort<T extends Comparable<T>> implements ISort<T>{

    public List<T> ordenar(List<T> estructura) {
        if (estructura.size() == 1) {
            return estructura;
        }
        else{
            List<T> mitad1 = ordenar(estructura.subList(0, (estructura.size() / 2)));
            List<T> mitad2 = ordenar(estructura.subList((estructura.size() / 2), estructura.size()));

            List<T> ordenada = unirMitades(mitad1, mitad2);

            return ordenada;
        }
    }

    private List<T> unirMitades(List<T> mitad1, List<T> mitad2) {
        int cont1 = 0;
        int cont2 = 0;
        List<T> union = new ArrayList<T>();

        while (cont1 < mitad1.size() && cont2 < mitad2.size()) {
            T elemento1 = mitad1.get(cont1);
            T elemento2 = mitad2.get(cont2);
            int comparacionMitad = elemento1.compareTo(elemento2);
            
            if (comparacionMitad < 0) {
                union.add(elemento1);
                cont1++;
            }
            else {
                union.add(elemento2);
                cont2++;
            }
        }

        while (cont1 < mitad1.size()) {
            union.add(mitad1.get(cont1));
            cont1++;
        }

        while (cont2 < mitad2.size()) {
            union.add(mitad2.get(cont2));
            cont2++;
        }

        return union;
    }
}
