package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

import main.java.GeneradorNumeros;
import main.java.LectorNumeros;

public class LectorNumerosTest {
    
    //This test should be commented in order to try and use the numberReading test
    
    /*@Before
    public void crearNumeros(){
        try {
            GeneradorNumeros.crearArchivoAleatorio(10);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }*/

    @Test
    public void leerNumeros(){
        Path path = Paths.get("src/main/resources/numerosAleatorios.txt");
        List<Integer> numeros = new ArrayList<Integer>(); 
        for (int i = 0; i < 7; i++) {
            numeros.add(i + 1);
        }

        try {
            Files.writeString(path, "1, 2, 3, 4, 5, 6, 7");    
            Assert.assertEquals(numeros, LectorNumeros.obtenerNumeros());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }   
    }
}
