package POO.musica;

public class Musica {
    private String nome;
    private String duracao;

    public Musica(String nome, String duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return nome + " (" + duracao + " min)";
    }
}
