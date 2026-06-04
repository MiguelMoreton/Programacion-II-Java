/*
 * Portfolio Programación II
 * Proyecto: Polinomios
 * Archivo revisado y organizado para presentación en GitHub.
 */

import java.util.SortedMap;

public class Polinomio {
    private double [] coeficientes;


    //CONSTRUCTOR POLINOMIO GRADO 4
    public Polinomio(double g1,double g2, double g3, double g4, double libre) {
        coeficientes = new double []{g4, g3, g2, g1, libre};
    }

    //CONSTRUCTOR POLINOMIO GRADO 2
    public Polinomio(double g2, double g1, double libre){
       coeficientes = new double[]{0,0,g2, g1, libre};
    }
    //CONSTRUCTOR TODOS LOS TERMINOS 0
    public Polinomio(){
        coeficientes = new double []{0,0,0,0,0};
    }
    //METODOS GETTER Y SETTER
    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    //METODO SUMA
    public Polinomio sumaPolinomios(Polinomio p1, Polinomio p2){
        Polinomio p3 = new Polinomio(0,0,0,0,0);
        for(int i =0; i < p1.coeficientes.length; i++){
            p3.coeficientes[i] = p1.coeficientes[i] +p2.coeficientes[i];
        }
        return p3;
    }
    //METODO RESTA
    public Polinomio restaPolinomios(Polinomio p1, Polinomio p2){
        Polinomio p3 = null;
        for(int i =0; i < p1.coeficientes.length; i++){
            p3.coeficientes[i] = p2.coeficientes[i] - p1.coeficientes[i];
        }
        return p3;
    }

    public void anadirTermino(int grado, int nuevoTermino, Polinomio p1){
        switch (grado){
            case 0:
                p1.coeficientes[grado] += nuevoTermino;
                break;
            case 1:
                p1.coeficientes[grado] += nuevoTermino;
                break;
            case 2:
                p1.coeficientes[grado] += nuevoTermino;
                break;
            case 3:
                p1.coeficientes[grado] += nuevoTermino;
                break;
            case 4:
                p1.coeficientes[grado] += nuevoTermino;
                break;
            default:
                System.out.println("El grado maximo es 4");
                break;
        }
    }

    //METODO GRADO
    public  void gradoPolinomio(Polinomio p1){
        if(p1.coeficientes[0] != 0){
            System.out.println("Tu polinomio tiene grado 4");
        } else if (p1.coeficientes[1] != 0) {
            System.out.println("tu polinomio tiene grado 3");
        } else if (p1.coeficientes[2] != 0) {
            System.out.println("Tu polinomio tiene grado 2");
        } else if (p1.coeficientes[3] != 0 ) {
            System.out.println("Tu polinomio tiene grado 1");
        }else{
            System.out.println("Tu polinomio tiene grado 0");
        }
    }

    ///RESOLVER POLINOMIO
    public void resolverPolinomio(Polinomio p1){
        boolean grado2 = true;
        double solucion1, solucion2,  solucion3 =0;
        for(int i = 0; i < 2; i++){
            if(p1.coeficientes[i] != 0){
                grado2 = false;
            }
        }
        if(grado2){
            if(p1.coeficientes[3] * p1.coeficientes[3] >= 4 * p1.coeficientes[2] * p1.coeficientes[4]){
                solucion1 = ((-p1.coeficientes[3]) + Math.sqrt((Math.pow(p1.coeficientes[3],2)- 4* p1.coeficientes[4]*p1.coeficientes[2])))/(2* p1.coeficientes[4]);
                solucion2 = ((-p1.coeficientes[3]) - Math.sqrt((Math.pow(p1.coeficientes[3],2)- 4* p1.coeficientes[4]*p1.coeficientes[2])))/(2* p1.coeficientes[4]);
                System.out.printf("[x1= " + solucion1 + "x2= " + solucion2 + "]");
            }else{
                solucion1 = Math.sqrt((Math.pow(p1.coeficientes[3],2)- 4* p1.coeficientes[4]*p1.coeficientes[2])* -1)/(2* p1.coeficientes[4]);
                System.out.printf("[x1= " + -p1.coeficientes[3] + "+" + solucion1 + "i" + " x2= " + -p1.coeficientes[3] + "-" + solucion1 + "i ]");
            }
        }else{
            System.out.println("Tu polinomio tiene un grado mayor a 2");
        }
    }

    //REPRESENTAR POLINOMIO
    public void representarPolinomio(Polinomio p1){
        if(p1.coeficientes[0] != 0){
            System.out.printf(p1.coeficientes[0] + "x^4 ");
        }
        if(p1.coeficientes[1] != 0){
            System.out.printf(p1.coeficientes[1] + "x^3 ");
        }
        if(p1.coeficientes[2] != 0){
            System.out.printf(p1.coeficientes[2] + "x^2 ");
        }
        if(p1.coeficientes[3] != 0){
            System.out.printf(p1.coeficientes[3] + "x ");
        }
        if(p1.coeficientes[4] != 0){
            System.out.println(p1.coeficientes[4] + "  ");
        }
    }


}
