package POO.musica;

import POO.musica.enums.EstiloMusical;

public class Artista {
    private String nome;
    private String nacionalidade;
    private EstiloMusical estiloMusical;

    public Artista(String nome, String nacionalidade, EstiloMusical estiloMusical) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.estiloMusical = estiloMusical;
    }

    @Override
    public String toString() {
        return nome +
                "\n  Nacionalidade: " + nacionalidade +
                "\n  Estilo Musical: " + estiloMusical;
    }
}
