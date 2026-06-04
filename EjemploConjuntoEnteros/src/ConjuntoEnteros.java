/*
 * Portfolio Programación II
 * Proyecto: Ejemplo conjunto de enteros
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.util.ArrayList;

/**
 * Implementación del TAD Conjunto de enteros
 * @author Jesús Sánchez Allende
 * @version 1.0 del 16 de marzo de 2023
 */

public class ConjuntoEnteros {
    private ArrayList<Integer> conjunto;

    /**
     * Crea un conjunto vacío.
     */
    public ConjuntoEnteros(){
        conjunto = new ArrayList<>();
    }

    /**
     * Añade un entero al conjunto. Si el entero
     * ya está en el conjunto no hace nada.
     *
     * @param x el entero que se desea añadir.
     */
    public void annadirEntero(int x){
        if( ! conjunto.contains(x)){
            conjunto.add(x);
        }
    }

    /**
     * Elimina el elemento del conjunto.
     * @param x el entero que se desea eliminar.
     */
    public void eliminarEntero(int x){
        conjunto.remove((Integer) x);
    }

    /**
     * Crea un nuevo conjunto con la unión de los dos.
     * @param c2 el segundo de los conjuntos.
     * @return el conjunto unión de ambos.
     */
    public ConjuntoEnteros union(ConjuntoEnteros c2){
        ConjuntoEnteros nuevo = new ConjuntoEnteros();

        for(Integer i : this.conjunto){
            nuevo.annadirEntero(i);
        }
        for(int i : c2.conjunto){
            nuevo.annadirEntero(i);
        }

        return nuevo;
    }

    /**
     * Hace la intersección de dos conjuntos.
     * @param c2 el segundo conjunto.
     * @return un conjunto intersección de ambos.
     */
    public ConjuntoEnteros interseccion(ConjuntoEnteros c2){
        ConjuntoEnteros nuevo = new ConjuntoEnteros();

        for(Integer n : this.conjunto){
            if(c2.conjunto.contains(n)){
                nuevo.annadirEntero(n);
            }
        }

        return nuevo;
    }

    /**
     * Indica si un entero pertenece al conjunto.
     * @param n el entero que se desea saber si está en el conjunto.
     * @return true si el entero está en el conjunto y false en caso
     * contrario.
     */
    public boolean pertenece(int n){
        return conjunto.contains(n);
    }

    /**
     * Devuelve la cardinalidad del conjunto.
     * @return el número de elementos del conjunto.
     */
    public int cardinal(){
        return conjunto.size();
    }

    /**
     * Devuelve un String con la representación del conjunto.
     * @return el conjunto de valores.
     */
    @Override
    public String toString() {
        String texto = "{";

        for (int i = 0; i < this.conjunto.size() - 1; i++) {
            texto += this.conjunto.get(i) + ", ";
        }
        if(! this.conjunto.isEmpty()){
            texto += this.conjunto.get(this.cardinal() - 1);
        }
        texto += "}";

        return texto;
    }
}
