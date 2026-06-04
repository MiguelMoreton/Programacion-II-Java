/*
 * Portfolio Programación II
 * Proyecto: Gestión de flota de coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorCoches flota = new GestorCoches();
        String nombreArchivo = "miscoches.che";
        // rellenaFlota(flota);

        int opcion;
        do {
            // Escribimos un menú de opciones
            escribirMenu();
            opcion = pedirNumero(0, 10);
            switch (opcion) {
                // Operaciones
                case 1:
                    // Añadir un coche a la flota.
                    annadirCoche(flota);
                    break;
                case 2:
                    // Eliminar un coche de la flota.
                    eliminarCoche(flota);
                    break;
                case 3:
                    // Ver la lista de todos los coches.
                    flota.escribirTodos();
                    break;
                case 4:
                    // Buscar un coche por su matricula.
                    buscarPorMatricula(flota);
                    break;
                case 5:
                    // Listar los coches más antiguos.
                    escribirAntiguos(flota);
                    break;
                case 6:
                    // Buscar los coches de un año.
                    escribirPorAnno(flota);
                    break;
                case 7:
                    // número de coches de cada marca.
                    flota.escribeNumeroCochesPorMarca();
                    break;
                case 8:
                    // leer de un archivo
                    flota.leerDeArchivo(nombreArchivo);
                    break;
                case 9:
                    // escribir en un archivo
                    flota.escribirEnArchivo(nombreArchivo);
                    break;
                case 10:
                    // informe de toda la flota de coches.
                    flota.informeTodosLosCoches();
                    break;
                case 0:
                    System.out.println("Termina el programa.");
                    System.out.println("Hasta la próxima vez!!!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }while(opcion != 0);
    }

    private static void escribirPorAnno(GestorCoches flota) {
        System.out.println("Escriba el año del que desea ver los coches: ");
        int anno = pedirNumero(1900, LocalDate.now().getYear());

        flota.escribirPorAnno(anno);
    }

    private static void escribirAntiguos(GestorCoches flota) {
        System.out.println("Introduzca el número de años de antiguedad: ");
        int annos = pedirNumero(1, 100);

        flota.escribirAntiguos(annos);
    }

    private static void buscarPorMatricula(GestorCoches flota) {
        Scanner teclado = new Scanner(System.in);
        // pedir la matricula
        System.out.print("Introduzca la matrícula del coche que desea buscar: ");
        String matricula = teclado.nextLine();

        // Buscar el coche con esa matricula
        Coche coche = flota.buscarPorMatricula(matricula);

        // si existe lo escribo
        if(coche != null){
            System.out.println(coche);
            System.out.println();
        }else{
            System.out.println("No existe un coche con matricula " + matricula);
            System.out.println();
        }
    }

    private static void eliminarCoche(GestorCoches flota) {
        Scanner teclado = new Scanner(System.in);
        // pedir la matricula
        System.out.print("Introduzca la matrícula del coche a eliminar: ");
        String matricula = teclado.nextLine();

        // Buscar el coche con esa matricula
        Coche coche = flota.buscarPorMatricula(matricula);

        // si existe lo elimino
        if(coche != null){
            flota.eliminarCoche(coche);
            System.out.println("Coche eliminado.");
            System.out.println();
        }else{
            System.out.println("No existe un coche con matricula " + matricula);
            System.out.println();
        }
    }

    private static void rellenaFlota(GestorCoches flota) {
        try {
            flota.annadirCoche(new Coche("1111", "VW", "Golf",
                    LocalDate.of(2021, 2, 14), 7000,
                    110, 12000, CalificacionAmbiental.B));
            flota.annadirCoche(new Coche("2222", "Audi", "A1",
                    LocalDate.of(2020, 2, 14), 300,
                    110, 12000, CalificacionAmbiental.B));
            flota.annadirCoche(new Coche("3333", "Seat", "León",
                    LocalDate.of(2010, 2, 14), 7000,
                    110, 12000, CalificacionAmbiental.A));
            flota.annadirCoche(new Coche("4444", "Volvo", "Grande",
                    LocalDate.of(2021, 2, 14), 70000,
                    110, 12000, CalificacionAmbiental.ECO));
            flota.annadirCoche(new Coche("5555", "VW", "Golf",
                    LocalDate.of(2021, 2, 14), 7000,
                    110, 12000, CalificacionAmbiental.CERO));
            flota.annadirCoche(new Coche("6666", "VW", "Pequeño",
                    LocalDate.of(2001, 2, 14), 898000,
                    110, 120000, CalificacionAmbiental.C));
            flota.annadirCoche(new Coche("7777", "VW", "Golf",
                    LocalDate.of(2013, 4, 20), 7000,
                    110, 12000, CalificacionAmbiental.A));
        } catch (Exception e) {
            System.out.println("Error al crear los coches.");
        }
    }

    private static void annadirCoche(GestorCoches flota) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca los datos del coche.");
        System.out.print("Matrícula: ");
        String matricula = teclado.nextLine();
        System.out.print("Marca: ");
        String marca = teclado.nextLine();
        System.out.print("Modelo: ");
        String modelo = teclado.nextLine();
        System.out.println("Fecha de fabricación:");
        LocalDate fecha = pedirFecha();
        System.out.println("Precio de compra: ");
        double precio = teclado.nextDouble();
        System.out.println("Potencia: ");
        int cv = pedirNumero(1, 2000);
        System.out.println("Kilómetros: ");
        int kilometros = pedirNumero(0, 10_000_000);
        System.out.println("Calificación ambiental");
        CalificacionAmbiental calificacion = pedirCalificacionAmbiental();

        try {
            Coche coche = new Coche(matricula, marca, modelo, fecha,
                    precio, cv, kilometros, calificacion);
            flota.annadirCoche(coche);
        }catch (Exception e){
            System.out.println("No se pudo crear el coche con los datos introducidos.");
            System.out.println();
        }
    }

    private static CalificacionAmbiental pedirCalificacionAmbiental() {
        System.out.println("1. A");
        System.out.println("2. B");
        System.out.println("3. C");
        System.out.println("4. ECO");
        System.out.println("5. CERO");
        int opcion = pedirNumero(1, 5);
        CalificacionAmbiental cal = switch (opcion){
            case 1 -> CalificacionAmbiental.A;
            case 2 -> CalificacionAmbiental.B;
            case 3 -> CalificacionAmbiental.C;
            case 4 -> CalificacionAmbiental.ECO;
            case 5 -> CalificacionAmbiental.CERO;
            default -> null;
        };
        return cal;
    }

    private static LocalDate pedirFecha() {
        System.out.println("Dia: ");
        int dia = pedirNumero(1, 31);
        System.out.println("Mes: ");
        int mes = pedirNumero(1, 12);
        System.out.println("Año: ");
        int anno = pedirNumero(1945, LocalDate.now().getYear());

        return LocalDate.of(anno, mes, dia);
    }

    private static void escribirMenu() {
        System.out.println("Seleccione una de las operaciones.");
        System.out.println("1. Añadir un coche a la flota.");
        System.out.println("2. Eliminar un coche de la flota.");
        System.out.println("3. Ver la lista de todos los coches.");
        System.out.println("4. Buscar un coche por su matricula.");
        System.out.println("5. Listar los coches más antiguos.");
        System.out.println("6. Buscar los coches de un año.");
        System.out.println("7. Número de coches de cada marca.");
        System.out.println("8. Leer los coches de un archivo.");
        System.out.println("9. Escribir los coches en un archivo.");
        System.out.println("10. Informe de toda la flota de coches.");
        System.out.println("0. Terminar el programa.");
    }

    private static int pedirNumero(int a, int b) {
        Scanner teclado = new Scanner(System.in);
        int n;

        do{
            try {
                System.out.print("Introduzca un número entre " + a + " y " + b + ": ");
                n = teclado.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Debe introducir un número");
                teclado.nextLine();
                n = a - 1;
            }
        }while(n < a || n > b);

        return n;
    }

}