package dev.eduperezn.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;
import dev.eduperezn.screenmatch.exception.ErrorEnConversionDeDuracionException;

public class Titulo implements Comparable<Titulo>{

    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvalucaiones;
    private int totalDeLasEvaluaciones;

     public Titulo(String nombre, int fechaDeLanzamiento){
         this.nombre = nombre;
         this.fechaDeLanzamiento = fechaDeLanzamiento;
     }

    public Titulo(TituloOmdb miTituloOmdb) {
         this.nombre = miTituloOmdb.title();
         this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
         if(miTituloOmdb.runtime().contains("N/A")){
             throw new ErrorEnConversionDeDuracionException("No pude convertir la duración" +
                     "porque contiene un N/A");
         }
         this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ","")
         );
    }

    //**********Setters**********
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento){
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos){
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan){
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    //**********Getters**********

    //Encapsulación

    public String getNombre(){
        return nombre;
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }

    public int getFechaDeLanzamiento(){
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos(){
        return duracionEnMinutos;
    }

    //Metodo sin retorno de datos
    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: "+nombre);
        System.out.println("Su fecha de lanzamiento es: "+fechaDeLanzamiento);
        System.out.println("Duración en minutos: "+getDuracionEnMinutos());
    }

    //Metodo con entrada de datos
    public void evalua(double nota){
        sumaDeLasEvalucaiones += nota;
        totalDeLasEvaluaciones ++;
    }

    //metodo con retorno de datos
    public double calculaMeida(){
        return sumaDeLasEvalucaiones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "Titulo:" +
                "nombre='" + nombre + '\'' +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento+
                ", duración="+duracionEnMinutos;
    }
}
