/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public abstract class Vehiculo{
    private String marca;
    private String modelo;
    private double precio;
    private Consumo consumo;

    public Vehiculo(String marca, String modelo, double precio, Consumo consumo) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.consumo = consumo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public abstract boolean esCoche();

    public double consumoMedio(){
    return consumo.consumoMedio();
    }

    public void anndeRepostaje(int kilometros, double litros){
        consumo.annadirRepostaje(kilometros, litros);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", consumo=" + consumo.toString() + " " + consumo.consumoMedio() + " " +
                '}';
    }
}
