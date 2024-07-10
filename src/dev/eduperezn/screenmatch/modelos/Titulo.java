package dev.eduperezn.screenmatch.modelos;

public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvalucaiones;
    private int totalDeLasEvaluaciones;

     public Titulo(String nombre, int fechaDeLanzamiento){
         this.nombre = nombre;
         this.fechaDeLanzamiento = fechaDeLanzamiento;
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
}
