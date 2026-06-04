/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException{
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicial, fechaFinal;
        String simbolo;
        int opcion, seleccion, numero, d, m, yr;
        double cantidad, precio, comision;
        Activo activo = null;
        Cuenta cuenta = null;
        Cartera cartera1 = null;
        Scanner teclado = new Scanner(System.in);
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 1:
                    String nombre, entidad, iban;
                    double saldo;
                    System.out.println("Introduce el nombre de tu cartera: ");
                    nombre = teclado.next();
                    System.out.println("Introduce la entidad bancaria de tu cuenta: ");
                    entidad = teclado.next();
                    System.out.println("Introduce el IBAN de tu cuenta: ");
                    iban = teclado.next();
                    System.out.println("¿Cual es el saldo inicial de tu cuenta?");
                    saldo = teclado.nextDouble();

                    cuenta = new Cuenta(entidad, iban, saldo);
                    cartera1 = new Cartera(nombre, cuenta);
                    break;
                case 2:
                    System.out.println("¿Que cantidad desea ingresar en la cuenta?");
                    cantidad = teclado.nextDouble();
                    assert cuenta != null;
                    cuenta.ingresarEnCuenta(cantidad);
                    break;
                case 3:
                    System.out.println("¿Que cantidad deseas retirar de tu cuenta?");
                    cantidad = teclado.nextDouble();
                    assert cuenta != null;
                    cuenta.retirarDeCuenta(cantidad);
                    break;
                case 4:
                    String datos;
                    assert cuenta != null;
                    datos = cuenta.toString();
                    System.out.println(datos);
                    break;
                case 5:
                    String merCat;
                    System.out.println("Introduce el simbolo de tu activo: ");
                    simbolo = teclado.next();
                    assert cartera1 != null;
                    if (cartera1.buscaActivo(simbolo)) {
                        System.out.println("Su activo se ha encontrado");
                        activo = cartera1.sacaActivo(simbolo);
                    } else {
                        System.out.println("Introduce el nombre de tu nuevo activo: ");
                        nombre = teclado.next();

                        System.out.println("Selecciona el tipo de activo que vs a crear: \n 1- Accion \n 2- ETF \n 3- Fondo de inversion");
                        seleccion = teclado.nextInt();
                        switch (seleccion) {
                            case 1 -> {
                                System.out.println("¿En que mercado está tu activo?");
                                merCat = teclado.next();
                                activo = new Accion(simbolo, nombre, true, merCat);
                            }
                            case 2 -> {
                                System.out.println("¿Cual es la categoria de tu ETF?");
                                merCat = teclado.next();
                                activo = new Accion(simbolo, nombre, true, merCat);
                            }
                            case 3 -> {
                                System.out.println("¿Cual es la categoria de tu fondo de inverison?");
                                merCat = teclado.next();
                                activo = new FondoInversion(simbolo, nombre, true, merCat);
                            }
                        }
                    }
                    System.out.println("Introduce el numero de activos que deseas comprar: ");
                    numero = teclado.nextInt();
                    System.out.println("¿A que precio vas a comprar?");
                    precio = teclado.nextDouble();
                    System.out.println("¿Que comision vas a pagar?");
                    comision = teclado.nextDouble();
                    assert activo != null;
                    cartera1.comprar(activo, fechaActual, numero, precio, comision);
                    break;
                case 6:
                    System.out.println("Introduce el simbolo del activo que quieres vender: ");
                    simbolo = teclado.next();
                    assert cartera1 != null;
                    activo = cartera1.sacaActivo(simbolo);
                    System.out.println("¿Cual es el numero de acciones que desea vender?");
                    numero = teclado.nextInt();
                    System.out.println("¿A que precio quieres vender tus acciones?");
                    precio = teclado.nextDouble();
                    System.out.println("¿Que comision vas a pagar?");
                    comision = teclado.nextInt();

                    if (activo != null) {
                        cartera1.vender(activo, fechaActual, numero, precio, comision);
                    } else {
                        System.out.println("No posee ese activo");
                    }
                    break;
                case 7:
                    System.out.println("¿Cual es el simbolo de su activo?");
                    simbolo = teclado.next();
                    assert cartera1 != null;
                    activo = cartera1.sacaActivo(simbolo);
                    System.out.println("¿Cual es el valor de los dividendos?");
                    precio = teclado.nextDouble();
                    System.out.println("¿Que comisión va a pagar?");
                    comision = teclado.nextInt();
                    cartera1.cobrarDividendos(activo, fechaActual, precio, comision);
                    break;
                case 8:
                    assert cartera1 != null;
                    cartera1.escribirOperaciones();
                    break;
                case 9:

                    System.out.println("Ingrese la fecha inicial");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }
                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }
                    System.out.println("Ingrese el anio");
                    yr = teclado.nextInt();

                    fechaInicial = LocalDate.of(yr, m, d);

                    System.out.println("Ingrese la fecha final");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }

                    System.out.println("Ingrese el anio");
                    yr = teclado.nextInt();

                    fechaFinal = LocalDate.of(yr, m, d);

                    assert cartera1 != null;
                    cartera1.escribirOperacionesEntreFechas(fechaInicial,fechaFinal);
                    break;
                case 10:
                    double rentabilidad;
                    System.out.println("Informe de rentabilidad de la cartera en fecha" + fechaActual);
                    System.out.println("Operaciones en el periodo: ");
                    assert cartera1 != null;
                    cartera1.escribirOperaciones();
                    try {
                        rentabilidad = cartera1.rentabilidad(fechaActual);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Rentabilidad en el periodo: " + rentabilidad + " %");
                    break;
                case 11:
                    System.out.println("Ingrese la fecha final");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }

                    System.out.println("Ingrese el anio");
                    yr = teclado.nextInt();

                    fechaFinal = LocalDate.of(yr, m, d);
                    try {
                        assert cartera1 != null;
                        cartera1.rentabilidad(fechaFinal);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 12:
                    assert cartera1 != null;
                    guardarEnDisco(cartera1, cartera1.getNombre());
                    break;
                case 13:
                    System.out.println("Introduce el nombre de la cartera que deseas leer : ");
                    nombre  = teclado.next();
                    cartera1 = leerDelDisco(nombre);
                    cartera1.escribirOperaciones();

                    break;
                case 14:
                    System.out.println("Ingrese la fecha inicial");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }
                    System.out.println("Ingrese el anio");
                    yr = teclado.nextInt();


                    fechaInicial = LocalDate.of(yr, m, d);

                    System.out.println("Ingrese la fecha final");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }

                    System.out.println("Ingrese el año");
                    yr = teclado.nextInt();

                    fechaFinal = LocalDate.of(yr, m, d);

                    assert cartera1 != null;
                    Cartera.escribirEnArchivo(fechaInicial, fechaFinal, cartera1);

                    break;
                case 15:

                    System.out.println("Ingrese la fecha inicial");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }

                    System.out.println("Ingrese el anio");
                    yr = teclado.nextInt();


                    fechaInicial = LocalDate.of(yr, m, d);

                    System.out.println("Ingrese la fecha final");
                    System.out.println("Ingrese el dia");
                    d = teclado.nextInt();
                    while( d<1 || d>31){
                        System.out.println("Por favor ingrese una fecha valida");
                        d = teclado.nextInt();
                    }

                    System.out.println("Ingrese el mes");
                    m = teclado.nextInt();
                    while( m<1 || m>12){
                        System.out.println("Por favor ingrese una fecha valida");
                        m = teclado.nextInt();
                    }

                    System.out.println("Ingrese el año");
                    yr = teclado.nextInt();

                    fechaFinal = LocalDate.of(yr, m, d);

                    assert cartera1 != null;
                    Cartera.informeRentabilidad(fechaInicial, fechaFinal, cartera1);

                    break;
            }
        } while (opcion != 16);
    }


    private static int menu(Scanner teclado) {
        int seleccion;
        System.out.println("""
                1- Crear una Cartera.
                2- Ingresar dinero en cuenta.\s
                3- Retirar dinero de la cuenta.
                4- Obtener informacion de la cuenta y su saldo.
                5- Realizar la compra de un activo.
                6- Realizar una venta.
                7- Cobrar dividendos.
                8- Informe de las operaciones realizadas.
                9- Informe de operaciones entre fechas.
                10- Calcular rentabilidad.
                11- Calcular rentabilidad hasta una fecha.
                12- Guardar en archivo
                13- Leer archivo
                14- Obtener informe operaciones entre dos fechas
                15- Obtener informe con calculo de rentabilidad de cada uno de los activos entre dos fechas\s
                16- Finalizar.\s""");

        seleccion = pedirNumero(teclado);
        return seleccion;

    }

    private static int pedirNumero(Scanner teclado) {
        int seleccion;

        do {
            try {
                System.out.print("Introduzca un número entre " + 0 + " y " + 16 + ": ");
                seleccion = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Debe introducir un número");
                teclado.nextLine();
                seleccion = -1;
            }
        } while (seleccion < 0 || seleccion > 16);

        return seleccion;
    }

    private static void guardarEnDisco(Cartera cartera, String nombre){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre));
            oos.writeObject(cartera);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo. ");
        }
    }

    private static Cartera  leerDelDisco(String nombre){
       Cartera cartera = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre));
            cartera = (Cartera) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("No se puede abrir el archivo");
        } catch (ClassNotFoundException e) {
            System.out.println("El archivo no contiene información de Operaciones");
        }
        return cartera;
    }

}