/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.Serializable;
import java.time.LocalDate;

public class Operacion implements Serializable {
    private final Activo activo;
    private final LocalDate fecha;
    private final double precio;
    private final int numA;
    private final double comision;
    private final TipoOperacion tipoOperacion;

    public Operacion(Activo activo, LocalDate fecha, double precio, int numA, double comision, TipoOperacion tipoOperacion) {
        this.activo = activo;
        this.fecha = fecha;
        this.precio = precio;
        this.numA = numA;
        this.comision = comision;
        this.tipoOperacion = tipoOperacion;
    }



    public Activo getActivo() {
        return activo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumA() {
        return numA;
    }

    public double getComision() {
        return comision;
    }

    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    @Override
    public String toString() {
        return tipoOperacion + " " + fecha + " " + numA + " de " + activo.getSimbolo() + " " + precio/numA + " Total: " + precio;
    }
}
