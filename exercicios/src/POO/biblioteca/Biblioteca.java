package POO.biblioteca;

import javabasico.mercado.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static utils.Leitor.*;

public class Biblioteca {
    List<Livro> livros = new ArrayList<>();

    private void adicionar() {
        String titulo = lerNome("Qual o nome do livro que você deseja adicionar? ");
        String autor = lerNome("Qual o nome do autor deste livro? ");
        BigDecimal preco = lerBigDecimalPositivo("Qual seria o preço deste livro? ");
        int quantidade = lerInteiroPositivo("Quantos livros você deseja adicionar? ");

        Livro livro = buscarPorTitulo(titulo);

        if (livro == null) {
            if (limiteInvalido(0, quantidade)) return;

            livros.add(new Livro(titulo, autor, preco, quantidade));
            System.out.printf("Livro %s adicionado com sucesso!\n\n", titulo);
            return;
        }

        if (aumentarQuantidade(livro, quantidade)) {
            livro.setPreco(preco);
            System.out.printf("Valor atualizado para R$%.2f | Quantidade atual: %s\n\n", preco, livro.getQuantidadeEstoque());
        }

    }

    private void exibirDetalhesTodosLivros() {
        livros.forEach(Livro::exibirDetalhes);
    }

    private Livro buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    private Livro buscarPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }

    private void editarDadosLivro() {
        int opcao = lerInteiroPositivo("""
                Qual dado de um livro você deseja editar?
                1 - Titulo
                2 - Autor
                3 - Preço
                4 - Quantidade em estoque
                """);

        switch (opcao) {
            case 1 -> {
                editarTitulo();
            }
            case 2 -> {
                editarAutor();
            }
            case 3 -> {
                int escolha = getEscolha();
                if (escolha == 1) {
                    String titulo = lerNome("Qual o titulo do livro? ");
                    Livro editarPreco = buscarPorTitulo(titulo);
                    if (buscarPorTitulo(titulo) != null) {
                        assert editarPreco != null;
                        System.out.printf("O livro %s foi encontrado com sucesso!\n\n", editarPreco.getTitulo());
                        alterarValor(editarPreco);
                    }
                    System.out.println("O livro não foi encontrado\n");

                } else if (escolha == 2) {
                    String autor = lerNome("Qual o autor do livro? ");
                    Livro editarPreco = buscarPorAutor(autor);
                    if (buscarPorAutor(autor) != null) {
                        assert editarPreco != null;
                        System.out.printf("O livro %s foi encontrado com sucesso!\n\n", editarPreco.getTitulo());
                        alterarValor(editarPreco);
                    }
                    System.out.println("O livro não foi encontrado\n");

                } else {
                    System.out.println("Escolha inválida\n");
                }
            }
            case 4 -> {
                int escolha = getEscolha();
                if (escolha == 1) {
                    String titulo = lerNome("Qual o titulo do livro? ");
                    Livro editarQuantidade = buscarPorTitulo(titulo);
                    alterarQuantidade(editarQuantidade);

                } else if (escolha == 2) {
                    String autor = lerNome("Qual o autor do livro? ");
                    Livro editarQuantidade = buscarPorAutor(autor);
                    alterarQuantidade(editarQuantidade);

                } else {
                    System.out.println("Escolha inválida\n");
                }
            }
            default -> System.out.println("Escolha inválida\n");
        }
    }

    public void menu() {
        int opcao = -1;

        while (opcao != 6) {
            System.out.println("""
                    *****MENU*****
                    1 - Adicionar livro
                    2 - Exibir todos os livros
                    3 - Buscar livro pelo titulo
                    4 - Buscar livro pelo autor
                    5 - Editar dados do livro
                    6 - Sair
                    """);

            opcao = lerInteiroPositivo("Escolha a opção desejada: ");

            switch (opcao) {
                case 1 -> adicionar();
                case 2 -> exibirDetalhesTodosLivros();
                case 3 -> {
                    if (buscarTitulo() != null) {
                        System.out.println("O livro %s foi encontrado com sucesso!\n");
                        return;
                    }
                    System.out.println("O livro não foi encontrado\n");
                }
                case 4 -> {
                    if (buscarAutor() != null) {
                        System.out.println("O livro %s foi encontrado com sucesso!\n");
                        return;
                    }
                    System.out.println("O livro não foi encontrado\n");
                }
                case 5 -> editarDadosLivro();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida\n");
            }
        }
    }

    private static void alterarQuantidade(Livro editarQuantidade) {
        if (editarQuantidade != null) {
            int valor = lerInteiro("Qual será o novo estoque? ");
            editarQuantidade.setQuantidadeEstoque(valor);
            System.out.println("O estoque foi alterado com sucesso!\n");
            return;
        }

        System.out.println("O livro não foi encontrado\n");
    }

    private static int getEscolha() {
        return lerInteiroPositivo("""
                Você deseja buscar o livro a partir do seu nome ou autor?
                1 - Titulo
                2 - Autor
                """);
    }

    private static void alterarValor(Livro editarPreco) {
        if (editarPreco != null) {
            BigDecimal valor = lerBigDecimalPositivo("Qual será o novo preço? ");
            editarPreco.setPreco(valor);
            System.out.println("O valor foi alterado com sucesso\n");
            return;
        }

        System.out.println("O livro não foi encontrado\n");
    }

    private Livro buscarAutor() {
        String autor = lerNome("Qual o nome do autor que deseja editar? ");
        return buscarPorAutor(autor);
    }

    private void editarAutor() {
        String autor = buscarAutor().getAutor();
        buscarAutor().setAutor(autor);
        System.out.println("Autor editado com sucesso!\n");
    }

    private Livro buscarTitulo() {
        String titulo = lerNome("Qual o nome do autor que deseja editar? ");
        return buscarPorTitulo(titulo);
    }

    private void editarTitulo() {
        String titulo = buscarTitulo().getTitulo();
        buscarTitulo().setTitulo(titulo);
        System.out.println("Titulo editado com sucesso!\n");
    }

    private boolean aumentarQuantidade(Livro livro, int quantidade) {
        if (limiteInvalido(livro.getQuantidadeEstoque(), quantidade)) return false;
        livro.setQuantidadeEstoque(livro.getQuantidadeEstoque() + quantidade);
        return true;
    }
}
