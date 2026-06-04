/*
 * Portfolio Programación II
 * Proyecto: Cambio de temperatura
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double temperatura1 = 50;
        double temperatura2;
        temperatura2 = (temperatura1 - 32) * 5 / 9;
        System.out.println(temperatura1 + " ºF equivale a " + temperatura2 + " ºC");

        temperatura1 = temperatura2 * 9 / 5 + 32;
        System.out.printf(temperatura2 + "ºC equivale a " + temperatura1 + "F");
    }
}