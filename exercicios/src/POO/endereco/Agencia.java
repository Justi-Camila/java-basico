package POO.endereco;

public class Agencia {
    private String numero;
    private String nome;
    private Endereco endereco;

    public Agencia(String numero, String nome, Endereco endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Agencia" +
                "\nnumero: " + numero +
                "\nnome: " + nome +
                "\nendereco: " + endereco;
    }
}
