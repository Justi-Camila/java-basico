package POO.musica;

import POO.musica.enums.EstiloMusical;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Musica musica = new Musica("Paradise", "4:17");
        Musica musica1 = new Musica("Obssesive", "03:59");
        Musica musica2 = new Musica("Moonlight", "04:12");

        List<Musica> musicas = new ArrayList<>();
        musicas.add(musica);
        musicas.add(musica1);
        musicas.add(musica2);

        Album album = new Album("Paradise", "2016", new Artista("Chase Atlantic", "Australianos", EstiloMusical.INDIE), musicas);
        System.out.println(album);
    }
}
