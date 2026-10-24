package POO.endereco;

import java.math.BigDecimal;

public class Conta {
    private Banco banco;
    private Agencia agencia;
    private Cliente cliente;
    private String numero;
    private BigDecimal saldo;

    public Conta(Banco banco, Agencia agencia, Cliente cliente, String numero, BigDecimal saldo) {
        this.banco = banco;
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta" +
                "\nbanco: " + banco +
                "\nagencia: " + agencia +
                "\ncliente: " + cliente +
                "\nnumero: " + numero +
                "\nsaldo: " + saldo;
    }
}
