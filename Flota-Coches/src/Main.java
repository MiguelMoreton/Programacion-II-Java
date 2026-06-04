/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Consumo consumoC = new Consumo(1);
        Consumo consumoM = new Consumo(12);
        Coche coche1 = new Coche("Seat", "Ibiza", 200000, consumoC, 5);
        Moto moto1 = new Moto("Yamaha", "wr250", 4000, consumoM, 250);
        vehiculos.add(coche1);
        vehiculos.add(moto1);

        coche1.anndeRepostaje(150, 12);
        moto1.anndeRepostaje(100, 2);

        System.out.println(coche1.toString());
        System.out.println(moto1.toString());
    }

    public void escribirSerializado(String nombre){

    }
}