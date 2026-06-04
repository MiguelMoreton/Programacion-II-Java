/*
 * Portfolio Programación II
 * Proyecto: Prueba de subarchivos
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Main {
    public static void main(String[] args) {
        alumno alumno1 = null;
        alumno alumno2;

        alumno1 = new alumno();
        alumno1.nombre = "Ana";
        alumno1.apellidos = "López";
        alumno1.annodenacimiento = 2001;
        alumno1.horario = Horario.TARDE;

        alumno2 = new alumno();

        System.out.println(alumno1.nombre);


    }
}