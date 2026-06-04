/*
 * Portfolio Programación II
 * Proyecto: Flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.util.ArrayList;

public class Consumo {
    private int kilometrosIniciales;
    private ArrayList<Repostaje> repostajes;

    public Consumo(int kilometrosIniciales) {
        this.kilometrosIniciales = kilometrosIniciales;
        repostajes = new ArrayList<Repostaje>();
    }

    public int getKilometrosIniciales() {
        return kilometrosIniciales;
    }

    public void setKilometrosIniciales(int kilometrosIniciales) {
        this.kilometrosIniciales = kilometrosIniciales;
    }

    public ArrayList<Repostaje> getRepostajes() {
        return repostajes;
    }

    public void setRepostajes(ArrayList<Repostaje> repostajes) {
        this.repostajes = repostajes;
    }

    /**
     * Esto es parlaksdfj lskdjfa sdlkfj flkajsd fñlakjfalsdk
     * a sdkfjsdklfj añsdlj lskdfj sñdfj asdlkf
     * a sldkfjdlkfj sdlfkjsdlkfj sdl
     *  sldfkj asldkfj ld
     *
     * @return devuelslkaf jasdfj alsdkjfadslkfja sdlfakjdlkdf j
     */
    public double consumoMedio(){
        double litros = 0, kilometros = 0;
        double resultado = 0;
        Repostaje ultimo;
        if(!repostajes.isEmpty()) {
            for (Repostaje repostaje : repostajes) {
                litros += repostaje.getLitros();
            }
            ultimo = repostajes.get(repostajes.size()-1);
            kilometros = ultimo.getKilometros() - kilometrosIniciales;

            resultado = kilometros / litros;
        } else {
            System.out.println("No tiene repostajes registrados");
        }
        return resultado;
    }


    public void annadirRepostaje(int kilometros, double litros){
        Repostaje repostaje = new Repostaje(kilometros, litros);
        repostajes.add(repostaje);
    }

    @Override
    public String toString() {
        return "Consumo{" +
                "kilometrosIniciales=" + kilometrosIniciales +
                ", repostajes=" + repostajes +
                '}';
    }
}
