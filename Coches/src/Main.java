/*
 * Portfolio Programación II
 * Proyecto: Coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {

        Coche coche1 = null;
        Coche coche2 = null;
        Coche coche3 = null;

        coche1 = new Coche("Seat", "Ibiza", "3447LXR", "MiguelM", 2022, "C", true);
        coche2 = new Coche("Audi" , "A4", "6625HGP", "Pablo G", 2011, "B" , true);
        coche3 = coche1;

        coche1.nombreProp = "Juan Gomez";
        coche1.seguro = true;
        coche2.seguro = true;

        System.out.println(coche2);
        System.out.println(coche3);

    }
}