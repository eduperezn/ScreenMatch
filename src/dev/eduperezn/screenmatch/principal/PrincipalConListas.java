package dev.eduperezn.screenmatch.principal;

import dev.eduperezn.screenmatch.modelos.Pelicula;
import dev.eduperezn.screenmatch.modelos.Serie;
import dev.eduperezn.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("matrix", 1998);
        otraPelicula.evalua(6);
        var peliculaDeEduardo = new Pelicula("El señor de los anillos",2001);
        peliculaDeEduardo.evalua(10);
        Serie lost = new Serie("lost", 2022);

        Pelicula p1 = peliculaDeEduardo;


        List<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeEduardo);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNombre());

            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                ((Pelicula) item).getClasificacion();
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");
        System.out.println(listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada"+listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista ordenada de titulos: "+ lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: "+lista);


    }
}
