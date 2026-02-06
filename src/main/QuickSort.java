package main;

import java.util.List;
import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> implements ISort<T>{
    
    public List<T> ordenar(List<T> estructura) {

        if (estructura.size() == 1 || estructura.size() == 0) {
            return estructura;
        }
        else {
            T pivote = estructura.remove(estructura.size() / 2);
            List<T> mitadMenor = new ArrayList<T>();
            List<T> mitadMayor = new ArrayList<T>();
            List<T> union = new ArrayList<T>();

            for (int i = 0; i < estructura.size(); i++) {
                int comparacion = estructura.get(i).compareTo(pivote);

                if (comparacion < 0) {
                    mitadMenor.add(estructura.get(i));
                }
                else {
                    mitadMayor.add(estructura.get(i));
                }
            }

            union = ordenar(mitadMenor);
            union.add(pivote);
            
            union.addAll(ordenar(mitadMayor));

            return union;
        }
    }
}
