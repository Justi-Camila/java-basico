package javabasico.mercado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercado {

    public Mercado(Scanner scanner) {
        this.scanner = scanner;
    }

    private final Scanner scanner;
    private final ArrayList<Item> lista = new ArrayList<>();
    private static final BigDecimal PIX = BigDecimal.valueOf(0.95);
    private static final BigDecimal CARTAO = BigDecimal.valueOf(0.93);
    private static final int QUANTIDADE_MAXIMA = 100;
    public static final String MENU = """
                *****MENU*****
                1 - Adicionar item
                2 - Consultar lista de itens
                3 - Valor total da compra
                4 - Excluir item
                5 - Alterar quantidade do item
                6 - Encerrar lista
                7 - Sair
                """;

    public void adicionarItem() {
        System.out.println("Digite o nome do item: ");
        String nome = scanner.nextLine().trim();

        if (nomeInvalido(nome)) return;

        BigDecimal valor = lerBigDecimal("Digite o valor do item: ");


        int quantidade = lerInteiroPositivo("Digite a quantidade do item: ");

        Item item = buscarItem(nome);

        int quantidadeAtual = (item != null) ? item.getQuantidade() : 0;

        if (limiteInvalido(quantidadeAtual, quantidade)) return;

        if (item != null) {
            item.setQuantidade(item.getQuantidade() + quantidade);
            item.setValor(valor);
            System.out.printf("Valor %.2f substituído e quantidade %s adicionada\n\n", valor, quantidade);
            return;
        }

        lista.add(new Item(nome, quantidade, valor));
        System.out.printf("Item %s adicionado com sucesso!\n\n", nome);
    }

    public void removerItem() {
        System.out.println("Digite o nome do item que deseja remover: ");
        String nome = scanner.nextLine().trim();

        if (nomeInvalido(nome)) return;

        Item item = buscarItem(nome);

        if (item != null) {
            lista.remove(item);
            System.out.println("O item foi removido com sucesso!\n");
        } else {
            System.out.println("O item digitado não existe\n");
        }
    }

    public void consultarLista() {
        if (lista.isEmpty()) {
            System.out.println("A lista de itens está vazia\n");
        }

        for (Item item : lista) {
            System.out.printf("Item: %s | Quantidade: %s | Valor Unitário: %.2f | Valor Total: %.2f\n\n", item.getNome(), item.getQuantidade(), item.getValor(), item.valorTotalItem());
        }
    }

    public BigDecimal valorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : lista) {
            total = total.add(item.valorTotalItem());
        }

        return total;
    }

    public void alterarQuantidadeItem() {

        System.out.println("Digite o nome do item que deseja alterar: ");
        String nome = scanner.nextLine().trim();

        if (nomeInvalido(nome)) return;

        Item item = buscarItem(nome);

        if (item != null) {

            int quantidade = lerInteiroPositivo("Digite a quantidade do item que deseja alterar: ");

            System.out.println("""
                Qual das opções você deseja realizar?
                1 - Aumentar a quantidade
                2 - Diminuir a quantidade
                """);

            int opcao = lerInteiro("Escolha a opção desejada: ");

            if (opcao == 1) {
                if (limiteInvalido(item.getQuantidade(), quantidade)) return;
                item.setQuantidade(item.getQuantidade() + quantidade);
                System.out.printf("A quantidade foi incrementada (%s)\n", item.getQuantidade());
            } else if (opcao == 2) {
                if ((item.getQuantidade() - quantidade) <= 0) {
                    System.out.println("Não é possível que a quantidade seja 0 ou menor\n");
                } else {
                    item.setQuantidade(item.getQuantidade() - quantidade);
                    System.out.printf("A quantidade foi decrementada (%s)\n", item.getQuantidade());
                }
            } else {
                System.out.println("Escolha inválida!\n");
            }
        } else {
            System.out.println("O item digitado não existe\n");
        }
    }

    public void encerrarLista() {

        if (lista.isEmpty()) {
            System.out.println("A lista está vazia\n");
            return;
        }

        System.out.printf("Valor total da compra R$%.2f\n\n", valorTotal());
        System.out.println("""
                Qual será a forma de pagamento?
                1 - Pagamento à vista (Pix/Dinheiro)
                2 - Cartão da loja
                """);

        int opcao = lerInteiro("Escolha a opção desejada: ");
        BigDecimal fatorDesconto;

        if (opcao == 1) {
            fatorDesconto = PIX;
        } else if (opcao == 2) {
            fatorDesconto = CARTAO;
        } else {
            System.out.println("Opção inválida\n");
            return;
        }

        BigDecimal total = valorTotal().multiply(fatorDesconto);

        System.out.printf("Valor total para pagar R$%.2f\n\n", total);

    }

    private Item buscarItem(String nome) {
        for (Item item : lista) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    private static boolean nomeInvalido(String nome) {
        if (nome.isEmpty()) {
            System.out.println("O nome não pode ser vazio");
            return true;
        }
        return false;
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.\n");
            }
        }
    }

    private int lerInteiroPositivo(String mensagem) {
        while (true) {
            int numero = lerInteiro(mensagem);
            if (numero > 0) {
                return numero;
            }
            System.out.println("O número deve ser maior que 0.\n");
        }
    }

    private BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                BigDecimal numero = new BigDecimal(scanner.nextLine().trim().replace(",", "."));
                if (numero.compareTo(BigDecimal.ZERO) > 0) {
                    return numero;
                }
                System.out.println("O valor deve ser maior que 0.\n");
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.\n");
            }
        }
    }

    private static boolean limiteInvalido(int quantidadeAtual, int quantidadeAdicionada) {
        if ((long) quantidadeAtual + quantidadeAdicionada > QUANTIDADE_MAXIMA) {
            System.out.println("Não é possível adicionar mais itens, a quantidade máxima é " + QUANTIDADE_MAXIMA);
            return true;
        }
        return false;
    }
}
