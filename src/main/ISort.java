package main;

import java.util.List;

public interface ISort<T extends Comparable<T>>{
    List<T> ordenar(List<T> estructura);
}