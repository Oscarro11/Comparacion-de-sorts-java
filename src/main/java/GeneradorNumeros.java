package main.java;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class GeneradorNumeros {
    private static Random RNG = new Random();

    public static void crearArchivoAleatorio(int cantidad) throws IOException {
        try {
            guardarNumeros(generarNumeros(cantidad));
        } catch (IOException e) {
            throw e;
        }
    }

    private static List<Integer> generarNumeros(int cantidadNumeros){
        List<Integer> listaIntegers = new ArrayList<Integer>();

        for (int i = 0; i < cantidadNumeros; i++) {
            listaIntegers.add(RNG.nextInt(10000));
        }

        return listaIntegers;
    }

    private static void guardarNumeros(List<Integer> numeros) throws IOException{
        Path path = Paths.get("src/main/resources/numerosAleatorios.txt");
        StringBuilder builder = new StringBuilder();

        for (Integer integer : numeros) {
            builder.append(integer);
            builder.append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());

        try {
            Files.writeString(path, builder.toString());    
        } catch (IOException e) {
            throw new IOException("La ruta del archivo en donde se guardaran los numeros es invalida");
        }
    }
}
