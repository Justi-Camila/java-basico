package POO.endereco;

public class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public Endereco(String pais, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco" +
                "\npais: " + pais +
                "\nestado: " + estado +
                "\ncidade: " + cidade +
                "\nbairro: " + bairro +
                "\nrua: " + rua +
                "\nnumero: " + numero +
                "\ncomplemento: " + complemento;
    }
}
