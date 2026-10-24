package POO.endereco;

public class Banco {
    private String numero;
    private String nome;
    private String cnpj;

    public Banco(String numero, String nome, String cnpj) {
        this.numero = numero;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Banco" +
                "\nnumero: " + numero +
                "\nnome: " + nome +
                "\ncnpj: " + cnpj;
    }
}
