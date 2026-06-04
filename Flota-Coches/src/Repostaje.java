/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Repostaje {
    private int kilometros;
    private double litros;

    public Repostaje(int kilometros, double litros) {
        this.kilometros = kilometros;
        this.litros = litros;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return "Repostaje{" +
                "kilometros=" + kilometros +
                ", litros=" + litros +
                '}';
    }
}
