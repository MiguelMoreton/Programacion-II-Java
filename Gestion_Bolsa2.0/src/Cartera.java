/*
 * Portfolio Programación II
 * Proyecto: Gestión Bolsa 2.0
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Cartera implements Serializable {
    private final String nombre;
    private ArrayList<Operacion> operaciones;
    private final Cuenta cuentaAsociada;

    public Cartera(String nombre, Cuenta cuentaAsociada) {
        this.nombre = nombre;
        operaciones = new ArrayList<>();
        this.cuentaAsociada = cuentaAsociada;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }

    public boolean comprar(Activo activo, LocalDate fecha, int numero, double precio, double comision){
        boolean valido = false;
        double saldoCuenta = cuentaAsociada.getSaldo();
        double precioTotal = numero*precio + comision;
        if(activo.getNegociable() && saldoCuenta >= precioTotal){
            valido = true;
            cuentaAsociada.setSaldo(saldoCuenta-precioTotal + comision);
            Operacion operacion = new Operacion(activo, fecha,precioTotal, numero, comision, TipoOperacion.COMPRA);
            operaciones.add(operacion);
        } else {
            System.out.println("No tiene dinero suficiente o el activo que intenta adquirir no es negociable.");
        }
        return valido;
    }

    public boolean vender(Activo activo, LocalDate fecha, int numero, double precio, double comision){
       boolean valido = false;
       double saldoCuenta = cuentaAsociada.getSaldo();
       double precioTotal = precio * numero;
        if(buscaActivo(activo.getSimbolo())){
            valido = true;
            cuentaAsociada.setSaldo(saldoCuenta + precioTotal - comision);
            Operacion operacion = new Operacion(activo, fecha, precioTotal, numero, comision, TipoOperacion.VENTA);
            operaciones.add(operacion);
        }else{
            System.out.println("No posee el activo que ha introducido");
        }
        return valido;
    }

    public void cobrarDividendos(Activo activo, LocalDate fecha, double valor, double comision) {
        int cantidad = 1;
            if(buscaActivo(activo.getSimbolo())){
                TipoOperacion tipoOperacion = TipoOperacion.DIVIDENDOS;
                Operacion nuevaOperacion = new Operacion(activo, fecha, valor, cantidad, comision, tipoOperacion);
                cuentaAsociada.setSaldo(cuentaAsociada.getSaldo() + (valor - comision));
                operaciones.add(nuevaOperacion);
            }else{
                System.out.println("No dispones de este activo");
            }
    }

    public double rentabilidad(LocalDate fecha) throws IOException {
        double rentabilidad, vCompras = 0, vDividendos = 0, vVentas = 0, vActualV = 0, vActualC = 0, vActualTot=0;
        double precioActual;
        String simbolo;
        for (Operacion operacion : operaciones){
            if (operacion.getTipoOperacion().equals(TipoOperacion.COMPRA)){
                vCompras += operacion.getPrecio() - operacion.getComision();
                simbolo = operacion.getActivo().getSimbolo();
                precioActual = Activo.buscaPrecio(simbolo,fecha);
                vActualC += precioActual * operacion.getNumA();
            } else if (operacion.getTipoOperacion().equals(TipoOperacion.VENTA)) {
                vVentas += operacion.getPrecio() - operacion.getComision();
                simbolo = operacion.getActivo().getSimbolo();
                precioActual = Activo.buscaPrecio(simbolo,fecha);
                vActualV += precioActual * operacion.getNumA();

            }else {
                vDividendos += operacion.getPrecio() - operacion.getComision();
            }
        vActualTot = vActualC - vActualV;

        }
        System.out.println("Valor a fecha " + fecha + " : " + vActualTot + "€");
        rentabilidad = (((vActualTot + vVentas +vDividendos)/vCompras) - 1)*100;
        return rentabilidad;
    }

    public boolean buscaActivo(String simbolo) {
        boolean encontrado = false;
        for (Operacion operacion : operaciones) {
            if (operacion.getActivo().getSimbolo().equals(simbolo)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Activo no encontrado");
        }
        return encontrado;
    }

    public Activo sacaActivo(String simbolo) {
        Activo activo = null;
        for (Operacion operacion : operaciones) {
            if (operacion.getActivo().getSimbolo().equals(simbolo)) {
                activo = operacion.getActivo();
            }

        }
        return activo;
    }

    public void escribirOperaciones (){
        String mensaje;
        LocalDate fecha = LocalDate.now();
        System.out.println("INFORME OPERACIONES HASTA LA FECHA " + fecha);
        for (Operacion operacion : operaciones){
            mensaje = operacion.toString();
            System.out.println(mensaje);
        }
    }

    public void escribirOperacionesEntreFechas (LocalDate fechaFinal, LocalDate fechaInicial){
       LocalDate sacaFecha;
       String mensaje;
        for (Operacion operacion : operaciones){
            sacaFecha = operacion.getFecha();
            if((sacaFecha.isAfter(fechaInicial)) && (sacaFecha.isBefore(fechaFinal))){
               mensaje = operacion.toString();
                System.out.println(mensaje);
            }
        }
    }

    public void escribeOrden(LocalDate fechaFinal, LocalDate fechaInicial) {
        ArrayList<String> simbolos = new ArrayList<>();
        ArrayList<Operacion> opOrdenadas = new ArrayList<>();

        for(Operacion operacion : operaciones){
            if( ! simbolos.contains(operacion.getActivo().getSimbolo())){
                simbolos.add( operacion.getActivo().getSimbolo());
            }
        }

        Collections.sort(simbolos);
        for(String marca : simbolos){
            for (Operacion operacion : operaciones){
                if(operacion.getActivo().getSimbolo().equals(marca) ){
                    opOrdenadas.add(operacion);
                }
            }
        }
        operaciones = opOrdenadas;

    }
    public static void escribirEnArchivo(LocalDate fechaInicial, LocalDate fechaFinal, Cartera cartera1){
        String nombre = "Informe_operaciones_" + cartera1.getNombre() + "_" + fechaInicial + "  -   " + fechaFinal + ".txt";
        String mensaje;
        String simboloOperacion;
        Activo activo;
        String nombreActivo;
        double TotCompra = 0, TotVentas =0, TotDividendos =0, Comisiones = 0;
        cartera1.escribeOrden(fechaInicial, fechaInicial);

        ArrayList<String> simbolos = new ArrayList<>();
        for(Operacion operacion : cartera1.getOperaciones()){
            if( ! simbolos.contains(operacion.getActivo().getSimbolo())){
                simbolos.add( operacion.getActivo().getSimbolo());
            }
        }
        Collections.sort(simbolos);

        try{
            PrintWriter pw = new PrintWriter(nombre);
            pw.write(nombre);
            pw.write("Fecha inicial: " + fechaInicial +"\n");
            pw.write("Fecha final: " + fechaFinal +"\n");
            pw.write("---------------------------------------------------------------------------\n");
            pw.write("| Fecha     | Op | Cantidad |  Precio | Comision |   Total  |\n");
            for(int i = 0; i< simbolos.size(); i++){
                activo = cartera1.sacaActivo(simbolos.get(i));
                nombreActivo = activo.getNombre();
                pw.write("-----------------------------------------------------------------------------" + "\n");
                pw.write("      " + simbolos.get(i) + " - " + nombreActivo + "\n");
                pw.write("-----------------------------------------------------------------------------\n");
                for(Operacion operacion: cartera1.operaciones){
                    simboloOperacion = operacion.getActivo().getSimbolo();
                    if(((operacion.getFecha().isBefore(fechaFinal) && operacion.getFecha().isAfter(fechaInicial)) || operacion.getFecha().equals(fechaInicial)) && simbolos.get(i).equals(simboloOperacion)) {
                        mensaje = operacion.toString();
                        pw.write(mensaje + "\n");

                        if (operacion.getTipoOperacion().equals(TipoOperacion.COMPRA)) {
                            TotCompra += operacion.getPrecio();
                        } else if (operacion.getTipoOperacion().equals(TipoOperacion.VENTA)) {
                            TotVentas += operacion.getPrecio();
                        } else {
                            TotDividendos += operacion.getPrecio();
                        }
                        Comisiones += operacion.getComision();
                    }
                }

                pw.write("Total compras: " + TotCompra + "$\n");
                pw.write("Total ventas: " + TotVentas + "$\n");
                pw.write("Total dividendos: " + TotDividendos + "$\n");
                pw.write("Total comisiones: " + Comisiones + "$\n");
                TotCompra=0;
                TotVentas = 0;
                TotDividendos = 0;
                Comisiones =0;
            }
            pw.write("---------------------------------------------------------------------------");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un problema con su archivo");
        }

    }

    public static void informeRentabilidad(LocalDate fechaInicial, LocalDate fechaFinal, Cartera cartera1){
        String nombre = "Informe_rentabilidad_" + cartera1.getNombre() + "_" + fechaInicial + "  -   " + fechaFinal + ".txt";
        String mensaje;
        String simboloOperacion;
        Activo activo;
        String nombreActivo;
        double TotCompra = 0, TotVentas =0, TotDividendos =0, Comisiones = 0,  rentabilidad = 0;
        double valorFechaI = 0, valorFechaF =0, vActualTot = 0;
        cartera1.escribeOrden(fechaInicial, fechaInicial);

        ArrayList<String> simbolos = new ArrayList<>();
        for(Operacion operacion : cartera1.getOperaciones()){
            if( ! simbolos.contains(operacion.getActivo().getSimbolo())){
                simbolos.add( operacion.getActivo().getSimbolo());
            }
        }
        Collections.sort(simbolos);

        try{
            PrintWriter pw = new PrintWriter(nombre);
            pw.write(nombre + "\n");
            pw.write("Fecha inicial: " + fechaInicial +"\n");
            pw.write("Fecha final: " + fechaFinal +"\n");
            for(int i = 0; i< simbolos.size(); i++){
                activo = cartera1.sacaActivo(simbolos.get(i));
                nombreActivo = activo.getNombre();
                pw.write("      " + simbolos.get(i) + " - " + nombreActivo + "\n");
                for(Operacion operacion: cartera1.operaciones){
                    simboloOperacion = operacion.getActivo().getSimbolo();
                    if(((operacion.getFecha().isBefore(fechaFinal) && operacion.getFecha().isAfter(fechaInicial)) || operacion.getFecha().equals(fechaInicial)) && simbolos.get(i).equals(simboloOperacion)) {
                        mensaje = operacion.toString();
                        pw.write(mensaje + "\n");

                        if (operacion.getTipoOperacion().equals(TipoOperacion.COMPRA)) {
                            TotCompra += operacion.getPrecio();
                        } else if (operacion.getTipoOperacion().equals(TipoOperacion.VENTA)) {
                            TotVentas += operacion.getPrecio();
                        } else {
                            TotDividendos += operacion.getPrecio();
                        }
                        Comisiones += operacion.getComision();

                        if (operacion.getTipoOperacion().equals(TipoOperacion.COMPRA)){
                            valorFechaI += operacion.getActivo().buscaPrecio(simboloOperacion, fechaInicial);
                            valorFechaF += operacion.getActivo().buscaPrecio(simboloOperacion, fechaFinal);
                        } else if (operacion.getTipoOperacion().equals(TipoOperacion.VENTA)){
                            valorFechaI -= operacion.getActivo().buscaPrecio(simboloOperacion, fechaInicial);
                            valorFechaF -= operacion.getActivo().buscaPrecio(simboloOperacion, fechaFinal);
                        }
                    }
                }
                rentabilidad = (((valorFechaF + TotVentas + TotDividendos)/TotCompra + valorFechaI) - 1)*100;

                pw.write("Valor de compras: " + TotCompra + "$\n");
                pw.write("Valor de ventas: " + TotVentas + "$\n");
                pw.write("Valor de dividendos: " + TotDividendos + "$\n");
                pw.write("Valor de comisiones: " + Comisiones + "$\n");
                pw.write("Valor de la rentabilidad: " + rentabilidad + "%\n");
                TotCompra=0;
                TotVentas = 0;
                TotDividendos = 0;
                Comisiones = 0;
                rentabilidad = 0;
                valorFechaI = 0;
                valorFechaF = 0;
            }
            pw.write("---------------------------------------------------------------------------");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un problema con su archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
