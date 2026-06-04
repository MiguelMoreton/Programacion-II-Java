/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Moto extends Vehiculo{
private int cilindrada;

    public Moto(String marca, String modelo, double precio, Consumo consumo, int cilindrada) {
        super(marca, modelo, precio, consumo);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean esCoche() {
        return false;
    }
}
