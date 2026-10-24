package POO.biblioteca;

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
        }
    }

    private void exibirDetalhesTodosLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado!\n");
            return;
        }
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

    private List<Livro> buscarPorAutor(String autor) {
        List<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
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
            case 1 -> editarTitulo();
            case 2 -> editarAutor();
            case 3 -> alterarValor(buscarLivroEscolha());
            case 4 -> alterarQuantidade(buscarLivroEscolha());
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
                case 3 -> buscarLivroPeloTitulo(buscarTitulo());
                case 4 -> buscarLivroPeloTitulo(buscarAutor());
                case 5 -> editarDadosLivro();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida\n");
            }
        }
    }

    private void buscarLivroPeloTitulo(Livro titulo) {
        if (titulo != null) {
            titulo.exibirDetalhes();
        } else {
            System.out.println("O livro não foi encontrado\n");
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
        String autor = lerNome("Qual o nome do autor? ");
        return selecionarLivroAutor(autor);
    }

    private void editarAutor() {
        Livro autor = buscarTitulo();
        if (autor == null) {
            System.out.println("O autor não foi encontrado\n");
            return;
        }
        autor.setAutor(lerNome("Qual o novo autor? "));
        System.out.println("Autor editado com sucesso!\n");
    }

    private Livro buscarTitulo() {
        String titulo = lerNome("Qual o nome do titulo? ");
        return buscarPorTitulo(titulo);
    }

    private void editarTitulo() {
        Livro livro = buscarTitulo();
        if (livro == null) {
            System.out.println("O livro não foi encontrado\n");
            return;
        }
        livro.setTitulo(lerNome("Qual o novo titulo? "));
        System.out.println("Titulo editado com sucesso!\n");
    }

    private Livro selecionarLivroAutor(String autor) {
        List<Livro> encontrados = buscarPorAutor(autor);

        if (encontrados.isEmpty()) return null;
        if (encontrados.size() == 1) return encontrados.getFirst();

        System.out.println("\nEsse autor tem mais de um livro: ");
        for (int i = 0; i < encontrados.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, encontrados.get(i).getTitulo());
        }

        while (true) {
            int escolha = lerInteiroPositivo("Qual deles você deseja selecionar? ");
            if (escolha <= encontrados.size()) {
                return encontrados.get(escolha - 1);
            }
            System.out.println("Escolha inválida\n");
        }
    }

    private Livro buscarLivroEscolha() {
        int escolha = getEscolha();
        if (escolha == 1) {
            return buscarPorTitulo(lerNome("Qual o titulo do livro? "));
        } else if (escolha == 2) {
            return selecionarLivroAutor(lerNome("Qual o autor do livro"));
        } else {
            System.out.println("Escolha inválida\n");
        }
        return null;
    }
}
