/*
 * Portfolio Programación II
 * Proyecto: Ejemplo conjunto de enteros
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {
        ConjuntoEnteros c1 = new ConjuntoEnteros();
        c1.annadirEntero(238);
        c1.annadirEntero(23);
        c1.annadirEntero(44);
        c1.annadirEntero(-5);
        System.out.println(c1);

        ConjuntoEnteros c2 = new ConjuntoEnteros();
        c2.annadirEntero(22);
        c2.annadirEntero(23);
        c2.annadirEntero(8);
        System.out.println(c2);

        System.out.println("La unión");
        ConjuntoEnteros union = c1.union(c2);
        System.out.println(union);

        System.out.println("La intersección.");
        System.out.println(c1.interseccion(c2));
    }
}