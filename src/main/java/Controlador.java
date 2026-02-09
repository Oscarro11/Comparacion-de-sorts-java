package main.java;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.time.*;

public class Controlador {
    private List<Integer> numerosOrdenar;

    public void generarListaDesordenada(int tamano) throws IOException{
        try {
            GeneradorNumeros.crearArchivoAleatorio(tamano);
            numerosOrdenar = LectorNumeros.obtenerNumeros();    
        } catch (IOException e) {
            throw e;
        }
    }

    public void generarListaOrdenada(int tamano) throws IOException{
        try {
            generarListaDesordenada(tamano);    
        } catch (IOException e) {
            throw e;
        }

        Collections.sort(numerosOrdenar);
    }

    public String generarReporte() throws NullPointerException{

        if (numerosOrdenar == null) {
            throw new NullPointerException("Debe generar un conjunto de numeros antes de poder usar el comparador de sorts");
        }

        ArrayList<ISort<Integer>> sorts = new ArrayList<ISort<Integer>>();
        StringBuilder builder = new StringBuilder();

        sorts.add(new MergeSort<Integer>());
        sorts.add(new QuickSort<Integer>());
        sorts.add(new RadixSort<Integer>());
        sorts.add(new GnomeSort<Integer>());
        sorts.add(new ShellSort<Integer>());

        for (ISort<Integer> sort : sorts) {
            builder.append("El tiempo de ejecucion del sort '" + sort.toString() + "' es: \n");
            builder.append(calcularTiempoSort(sort) + " nanosegundos\n\n");
        }

        return builder.toString();
    }

    private int calcularTiempoSort(ISort<Integer> sort){
        Instant inicio = Instant.now();

        List<Integer> copiaNumerosOrdenar = new ArrayList<Integer>(numerosOrdenar);
        sort.ordenar(copiaNumerosOrdenar);

        Instant fin = Instant.now();
        Duration diferenciaTiempo = Duration.between(inicio, fin);

        return diferenciaTiempo.toNanosPart();
    }
}
