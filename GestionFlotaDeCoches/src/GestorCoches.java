/*
 * Portfolio Programación II
 * Proyecto: Gestión de flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class GestorCoches {
    ArrayList<Coche> misCoches;

    public GestorCoches() {
        misCoches = new ArrayList<>();
    }

    public void annadirCoche(Coche coche) {
        misCoches.add(coche);
    }

    public void escribirTodos() {
        for(Coche coche : misCoches){
            System.out.println(coche);
        }
    }

    public Coche buscarPorMatricula(String matricula) {
        for (Coche coche : misCoches){
            if(coche.getMatricula().equals(matricula)){
                return coche;
            }
        }

        return null;
    }

    public void eliminarCoche(Coche coche) {
        misCoches.remove(coche);
    }

    public void escribirAntiguos(int annos) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaCorte = fechaActual.minusYears(annos);

        for(Coche coche : misCoches){
            if( ! coche.getFechaFabricacion().isAfter(fechaCorte)){
                System.out.println(coche);
            }
        }
    }

    public void escribirPorAnno(int anno) {
        for(Coche coche : misCoches){
            if(coche.getFechaFabricacion().getYear() == anno){
                System.out.println(coche);
            }
        }
    }

    public void escribeNumeroCochesPorMarca() {
        // saco las marcas que tengo
        ArrayList<String> marcas = new ArrayList<>();
        for(Coche coche : misCoches){
            if( ! marcas.contains(coche.getMarca())){
                marcas.add(coche.getMarca());
            }
        }

        // Las quiero por orden alfabético....
        Collections.sort(marcas);

        for(String marca : marcas){
            System.out.println("Hay " + numeroCoches(marca) + " coches " + marca);
        }
    }

    private int numeroCoches(String marca) {
        int cuenta = 0;
        for(Coche coche : misCoches){
            if(coche.getMarca().compareToIgnoreCase(marca) == 0){
                cuenta++;
            }
        }
        return cuenta;
    }


    public void escribirEnArchivo(String nombreArchivo) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

            oos.writeObject(misCoches);

            oos.close();
        } catch (IOException e) {
            System.out.println("No se ha podrchivoido crear el archivo.");
            System.out.println(e);
        }
    }

    public void leerDeArchivo(String nombreArchivo) {

        try {
            FileInputStream archivo = new FileInputStream(nombreArchivo);
            ObjectInputStream ois = new ObjectInputStream(archivo);

            Object objeto = ois.readObject();
            misCoches = (ArrayList<Coche>) objeto;

            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");;
        } catch (IOException e) {
            System.out.println("Error al leer del archivo.");;
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer.");;
        }


    }

    public void informeTodosLosCoches() {
        try {
            PrintWriter pw = new PrintWriter("informe.txt");

            pw.println("Informe de la flota de coches.");
            pw.println("Con fecha " + LocalDate.now());
            pw.println();
            pw.println("-----------------------------------------------");
            for(Coche coche : misCoches){
                pw.println(coche);
            }
            pw.println("-----------------------------------------------");
            pw.println("Fin del informe.");

            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido crear el archivo con el informe.");
        }


    }
}






