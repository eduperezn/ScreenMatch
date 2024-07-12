package dev.eduperezn.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.eduperezn.screenmatch.exception.ErrorEnConversionDeDuracionException;
import dev.eduperezn.screenmatch.modelos.Titulo;
import dev.eduperezn.screenmatch.modelos.TituloOmdb;

import javax.sound.midi.Soundbank;
import javax.swing.tree.ExpandVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de la pelicula");
        var busqueda = lectura.nextLine();

        String direccion = "https://www.omdbapi.com/?t="+
                busqueda.replace(" ","+")+
                "&apikey=7ec80d6c";

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);


            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Titulo ya convertido: " + miTitulo);

        }catch (NumberFormatException e){
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la direccion");
        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMensaje());
        }

        System.out.println("Finalizó la ejecución del programa");


    }
}
