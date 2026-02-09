package main.java;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class LectorNumeros {
    
    
    public static List<Integer> obtenerNumeros() throws IOException{
        List<String> contenido;
        List<Integer> numeros = new ArrayList<Integer>();
        Path path = Paths.get("src/main/resources/numerosAleatorios.txt");

        try {
           contenido = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IOException("La ruta del archivo a leer es invalida");
        }

        for (String linea : contenido) {
            String[] numerosLinea = linea.split(",");

            for (String numeroActual : numerosLinea) {
                numeroActual = numeroActual.strip();
                numeros.add(Integer.parseInt(numeroActual));
            }
        }

        return numeros;
    }
}
