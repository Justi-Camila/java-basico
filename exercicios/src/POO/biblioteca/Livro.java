package POO.biblioteca;

import java.math.BigDecimal;

public class Livro {
    private String titulo;
    private String autor;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, BigDecimal preco, int quantidadeEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirDetalhes() {
        System.out.printf("""
                Titulo: %s
                Autor: %s
                Preço: %.2f
                Quantidade em estoque: %s
                
                """, titulo, autor, preco, quantidadeEstoque);
    }
}
