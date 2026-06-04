/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.Serializable;

public class Accion extends Activo implements Serializable {

    private final String mercado;

    public Accion(String simbolo, String nombre, Boolean negociable, String mercado) {
        super(simbolo, nombre, negociable);
        this.mercado = mercado;
    }

}