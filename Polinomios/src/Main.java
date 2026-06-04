/*
 * Portfolio Programación II
 * Proyecto: Polinomios
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {

        Polinomio prueba = new Polinomio(1, 3,0,2,5);
        Polinomio prueba2 = new Polinomio(2,0,5,1,3);
        Polinomio suma;
        prueba.representarPolinomio(prueba);

        prueba.gradoPolinomio(prueba);

        suma = prueba.sumaPolinomios(prueba, prueba2);
       prueba.representarPolinomio(suma);

       Polinomio gr2 = new Polinomio(2,4,5);
       prueba.resolverPolinomio(gr2);




    }
}