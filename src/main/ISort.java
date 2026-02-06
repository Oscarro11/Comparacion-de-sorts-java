package main;

import java.util.List;

public interface ISort<T>{
    List<Comparable<T>> ordenar(List<Comparable<T>> estructura);
}