package main.java;

import java.util.Scanner;

public class App {
    public static Controlador controlador = new Controlador();
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        boolean continuar = true;
        String opcion = "";

        escribir("Bienvenido al programa de comparacion de sorts\n");
        while (continuar) {
            escribir("""
                Elija una de las siguientes opciones:
                1. Generar lista aleatoria de numeros
                2. Generar lista ordenada de numeros
                3. Realizar comparacion de sorts
                4. Salir
            """);

            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    escribir("Ingrese el numero de elementos a generar");
                    int tamano = teclado.nextInt();
                    teclado.next();

                    try {
                        controlador.generarListaDesordenada(tamano);
                        escribir("Numeros generados con exito");
                    } catch (Exception e) {
                        escribir(e.getLocalizedMessage());
                    }
                    break;

                case "2":
                    escribir("Ingrese el numero de elementos a generar");
                    int tamanoOrden = teclado.nextInt();
                    teclado.next();

                    try {
                        controlador.generarListaOrdenada(tamanoOrden);;
                        escribir("Numeros generados y ordenados con exito");
                    } catch (Exception e) {
                        escribir(e.getLocalizedMessage());
                    }
                    break;

                case "3":
                    try {
                        escribir(controlador.generarReporte());
                    } catch (Exception e) {
                        escribir(e.getLocalizedMessage());
                    }
                    break;

                case "4":
                    escribir("Gracias por usar el programa, esperamos verlo nuevamente");
                    continuar = false;
            
                default:
                    escribir("La opcion ingresada no coincide con ninguna del menu. Intentelo de nuevo\n");
                    break;
            }
        }
    }

    public static void escribir(String texto) {
        System.out.println(texto);
    }
}
