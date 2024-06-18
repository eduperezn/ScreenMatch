public class Principal {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula();
        miPelicula.nombre = "Encanto";
        miPelicula.fechaDeLanzamiento = 2021;
        miPelicula.duracionEnMinutos = 120;

        System.out.println("Mi pelicula es: "+miPelicula.nombre);
        System.out.println("Su fecha de lanzamiento es: "+miPelicula.fechaDeLanzamiento);

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.nombre = "Matrix";
        otraPelicula.fechaDeLanzamiento = 1999;
        otraPelicula.duracionEnMinutos = 260;

        System.out.println(miPelicula);
        System.out.println(otraPelicula);
    }
}
