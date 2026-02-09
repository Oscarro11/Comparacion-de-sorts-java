package main.java;

import java.util.List;

public class ShellSort<T extends Comparable<T>> implements ISort<T>{
    
    public List<T> ordenar(List<T> estructura) {
        int n = estructura.size();

        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = estructura.get(i);
                int j = i; 

                while (j >= gap && estructura.get(j - gap).compareTo(temp) > 0) {
                    estructura.set(j, estructura.get(j - gap));
                    j -= gap;
                }

                estructura.set(j, temp);
            }
        }

        return estructura;
    }

    @Override
    public String toString() {
        return "ShellSort";
    }
}