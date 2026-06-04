/*
 * Portfolio Programación II
 * Proyecto: Cono 2
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double PI = 3.14;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el diámetro de la base del cono en cm: ");
        double diametro = teclado.nextDouble();

        System.out.print("Introduzca la altura del cono en cm: ");
        double altura = teclado.nextDouble();

        double radio = diametro / 2;
        double area = PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));
        double volumen = (1.0/3.0) * PI * Math.pow(radio, 2) * altura;

        System.out.println("El área del cono es: " + area + " cm²");
        System.out.println("El volumen del cono es: " + volumen + " cm³");

        teclado.close();
    }
}