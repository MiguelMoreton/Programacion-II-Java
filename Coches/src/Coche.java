/*
 * Portfolio Programación II
 * Proyecto: Coches
 * Archivo revisado y organizado para presentación en GitHub.
 */

public class Coche {
    String marca;
    String modelo;
    String matricula;
    String nombreProp;
    int annoFabric;
    String catAmbi;
    Boolean seguro;

    //Constructor
    Coche(String marca, String modelo, String matricula, String nombreProp, int annofabric, String catAmbi, Boolean seguro){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.nombreProp = nombreProp;
        this.annoFabric = annofabric;
        this.catAmbi = catAmbi;
        this.seguro = seguro;
    }

    public String getMarca(){return marca;}

    public void setMarca(String nuevaMarca){marca = nuevaMarca;}

    public String getModelo(){return modelo;}

    public void setModelo(String nuevoModelo){modelo = nuevoModelo;}

    public String getMatricula(){return matricula;}

    public void setMatricula(String nuevaMatricula){matricula = nuevaMatricula;}

    public int getAnnoFabric(){return annoFabric;}

    public void setannoFabric(int nuevoannoFabric){annoFabric = nuevoannoFabric;}

    public String getcatAmbi(){return catAmbi;}

    public void setcatAmbi(String nuevacatAmbi){catAmbi = nuevacatAmbi;}

    public Boolean getSeguro(){return seguro;}

    public void setSeguro(boolean nuevoSeguro){seguro = nuevoSeguro;}


    public String toString(){
        return "Coche:" + "marca = " + marca + ", modelo = " + modelo + ",matricula = " + matricula + ",propietario = " + nombreProp + ", año de frabricacion = " + annoFabric + ", categoria ambiental = " + catAmbi + ",seguro todo riesgo = " + seguro;
    }
}
