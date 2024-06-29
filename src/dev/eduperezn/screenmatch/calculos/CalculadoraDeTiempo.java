package dev.eduperezn.screenmatch.calculos;
import  dev.eduperezn.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal(){
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracionEnMinutos();
    }

}
