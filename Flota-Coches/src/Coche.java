/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Coche extends Vehiculo{
private int numeroPuertas;

    public Coche(String marca, String modelo, double precio, Consumo consumo, int numeroPuertas) {
        super(marca, modelo, precio, consumo);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }


    public boolean esCoche() {
        return true;
    }
}
