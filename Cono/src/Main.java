/*
 * Portfolio Programación II
 * Proyecto: Cono
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {
        double PI = 3.14;
        double diametro = 15.5;
        double altura = 42.4;

        double radio = diametro / 2;
        double area = PI * radio * (radio + Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)));
        double volumen = (1.0/3.0) * PI * Math.pow(radio, 2) * altura;

        System.out.println("El área del cono es: " + area + " cm²");
        System.out.println("El volumen del cono es: " + volumen + " cm³");
    }
}