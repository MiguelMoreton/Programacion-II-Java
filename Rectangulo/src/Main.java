/*
 * Portfolio Programación II
 * Proyecto: Rectángulo
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {
        double lado = 15;
        double altura =25;

        double perimetro = 2 * (lado + altura);
        double area = lado * altura;

        System.out.println("Longitud del lado es: " + lado + "cm");
        System.out.println("Longitud de la altura: " + altura + "cm");
        System.out.println("Perímetro del rectángulo: " + perimetro + "cm");
        System.out.println("Área del rectángulo: " + area + "cm^2");
    }
}