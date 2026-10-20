package javabasico.mercado;

import java.math.BigDecimal;

public class Item {
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Item(String nome, int quantidade, BigDecimal valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    private String nome;
    private int quantidade;
    private BigDecimal valor;

    public BigDecimal subTotal() {
        return getValor().multiply(BigDecimal.valueOf(getQuantidade()));
    }

}
