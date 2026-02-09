package main.java;

import java.util.List; 

public class GnomeSort <T extends Comparable<T>> implements ISort<T>{
    
    public List<T> ordenar(List<T> estructura) {
        int index = 0;
        while (index < estructura.size()){
            if (index == 0){
                index++;
            }
            else if (estructura.get(index).compareTo(estructura.get(index - 1)) >= 0){
                index++;
            } 
            else {
                T temp = estructura.get(index);
                estructura.set(index, estructura.get(index - 1));
                estructura.set(index - 1, temp);
                index--;
            }
                
        }
        return estructura;
    }
}