/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.Serializable;

public class Cuenta implements Serializable {
    private String entidad;
    private String iban;
    private double saldo;

    public Cuenta(String entidad, String iban, double saldo) {
        this.entidad = entidad;
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Boolean retirarDeCuenta (double cantidad){
        if(cantidad > saldo){
            return false;
        }else{
            saldo -= cantidad;
            System.out.println("Tu nuevo saldo tras la retiradas es de : " + saldo);
            return true;
        }
    }

    public void ingresarEnCuenta(double cantidad){
        saldo += cantidad;
        System.out.printf("Su dinero se ha ingresado correctamente ");
    }

    @Override
    public String toString() {
        return "Cuenta:" + "entidad='" + entidad + '\'' + ", iban='" + iban + '\'' + ", saldo=" + saldo;
    }
}
