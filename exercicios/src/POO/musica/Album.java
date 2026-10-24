package POO.musica;

import java.util.List;
import java.util.stream.Collectors;

public class Album {
    private String nome;
    private String anoLancamento;
    private Artista artista;
    private List<Musica> musicas;

    public Album(String nome, String anoLancamento, Artista artista, List<Musica> musicas) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        String lista =  musicas.stream()
                .map(m -> " - " + m)
                .collect(Collectors.joining("\n"));

        return "Album: " + nome +
                "\nAno de lançamento: " + anoLancamento +
                "\nArtista: " + artista +
                "\nMúsicas:\n" + lista;
    }
}
