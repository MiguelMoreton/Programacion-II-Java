/*
 * Portfolio Programación II
 * Proyecto: Gestión de flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.Serializable;
import java.time.LocalDate;

public class Coche implements Serializable {
    private String matricula;
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private double precioCompra;
    private int potencia; // en CV
    private int kilometros;
    private CalificacionAmbiental calificacionAmbiental;

    public Coche(String matricula, String marca, String modelo,
                 LocalDate fechaFabricacion, double precioCompra,
                 int potencia, int kilometros,
                 CalificacionAmbiental calificacionAmbiental) throws Exception {
        if(kilometros < 0 || potencia <= 0 ||
                matricula == null || marca == null || modelo == null ||
                fechaFabricacion.isAfter(LocalDate.now()) ){
            throw new Exception();
        }
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.precioCompra = precioCompra;
        this.potencia = potencia;
        this.kilometros = kilometros;
        this.calificacionAmbiental = calificacionAmbiental;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws Exception {
        if(matricula == null){
            throw new Exception();
        }
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) throws Exception {
        if(kilometros < this.kilometros){
            throw new Exception();
        }
        this.kilometros = kilometros;
    }

    public CalificacionAmbiental getCalificacionAmbiental() {
        return calificacionAmbiental;
    }

    @Override
    public String toString() {
        return  "matricula=" + matricula +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", fechaFabricacion=" + fechaFabricacion +
                ", precioCompra=" + precioCompra +
                ", potencia=" + potencia +
                ", kilometros=" + kilometros +
                ", calificacionAmbiental=" + calificacionAmbiental;
    }
}
