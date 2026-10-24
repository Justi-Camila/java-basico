package POO.endereco;

import java.math.BigDecimal;

public class Cliente {
    private Pessoa pessoa;
    private Documento documento;
    private Endereco endereco;
    private String telefoneParaContato;
    private String profissao;
    private BigDecimal rendaMensal;

    public Cliente(Pessoa pessoa, Documento documento, Endereco endereco, String telefoneParaContato, String profissao, BigDecimal rendaMensal) {
        this.pessoa = pessoa;
        this.documento = documento;
        this.endereco = endereco;
        this.telefoneParaContato = telefoneParaContato;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }

    @Override
    public String toString() {
        return "Cliente" +
                "\npessoa: " + pessoa +
                "\ndocumento: " + documento +
                "\nendereco: " + endereco +
                "\ntelefoneParaContato: " + telefoneParaContato +
                "\nprofissao: " + profissao +
                "\nrendaMensal: " + rendaMensal;
    }
}
