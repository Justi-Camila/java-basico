package POO.endereco;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    private Pessoa mae;
    private Pessoa pai;

    public Pessoa(String nome, String dataNascimento, Pessoa mae, Pessoa pai) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.mae = mae;
        this.pai = pai;
    }

    public Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.mae = new Pessoa();
        this.pai = new Pessoa();
    }

    public Pessoa() {
        this.nome = " ";
        this.dataNascimento = " ";
        this.mae = null;
        this.pai = null;
    }

    @Override
    public String toString() {
        return "Pessoa " +
                "\nnome: " + nome +
                "\ndataNascimento: " + dataNascimento +
                "\nmae: " + mae +
                "\npai: " + pai;
    }
}
