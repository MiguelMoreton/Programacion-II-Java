/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.Serializable;

public class ETF extends Activo implements Serializable {

    private String categoria;

    public ETF(String simbolo, String nombre, Boolean negociable, String categoria) {
        super(simbolo, nombre, negociable);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}