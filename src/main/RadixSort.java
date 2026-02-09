package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort<T extends Number & Comparable<T>> implements ISort<T>{
    
    public List<T> ordenar(List<T> estructura) {
        int max = maxElemento(estructura).intValue();

        for (int exponente = 1; max / exponente > 0; exponente = exponente * 10) {
            estructura = countSort(estructura, exponente);
        }

        return estructura;
    }


    private List<T> countSort(List<T> lista, int exponente){
        List<T> resultado = new ArrayList<T>();
        int[] cuenta = new int[10];
        Arrays.fill(cuenta, 0);

        for (int i = 0; i < lista.size(); i++) {
            cuenta[(lista.get(i).intValue() / exponente) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            cuenta[i] = cuenta[i] + cuenta[i - 1];
        }

        for (int i = 0; i < lista.size(); i++) {
            resultado.add(null);
        }

        for (int i = lista.size() - 1; i >= 0; i--) {
            resultado.set(cuenta[(lista.get(i).intValue() / exponente) % 10] - 1, lista.get(i));
            cuenta[(lista.get(i).intValue() / exponente) % 10]--;
        }

        return resultado;
    }
    
    private T maxElemento(List<T> estructura) {
        T elementoMax = estructura.getFirst();
        T elementoActual;
        for (int i = 1; i < estructura.size(); i++) {
            elementoActual = estructura.get(i);
            
            if (elementoMax.compareTo(elementoActual) < 0) {
                elementoMax = elementoActual;
            }
        }

        return elementoMax;
    }
}