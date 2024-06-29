package dev.eduperezn.screenmatch.modelos;

import dev.eduperezn.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int)calculaMeida()/2;
    }
}
