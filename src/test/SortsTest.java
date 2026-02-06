package test;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

import main.MergeSort;

public class SortsTest {
    List<Integer> lista = new ArrayList<Integer>();
    List<Integer> listaOrdenada = new ArrayList<Integer>();

    @BeforeEach
    public void generarLista() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int numeroGenerado = random.nextInt(10);
            lista.add(numeroGenerado);
            listaOrdenada.add(numeroGenerado);
        }

        Collections.sort(listaOrdenada);
    }

    @Test
    public void mergeSortTest() {
        MergeSort<Integer> sort = new MergeSort<Integer>();
        Assert.assertEquals(listaOrdenada, sort.ordenar(lista));
    }
}
