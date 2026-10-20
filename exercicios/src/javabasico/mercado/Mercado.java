package javabasico.mercado;

import javabasico.mercado.enums.Pagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static javabasico.mercado.Leitor.*;
import static javabasico.mercado.enums.Pagamento.CARTAO;
import static javabasico.mercado.enums.Pagamento.PIX;

public class Mercado {

    private final ArrayList<Item> itens = new ArrayList<>();
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
        String nome = lerNome("Digite o nome do item: ");
        BigDecimal valor = lerBigDecimalPositivo("Digite o valor do item: ");
        int quantidade = lerInteiroPositivo("Digite a quantidade do item: ");

        Item item = buscarItem(nome);

        if (item == null) {
            if (limiteInvalido(0, quantidade)) return;

            itens.add(new Item(nome, quantidade, valor));
            System.out.printf("Item %s adicionado com sucesso!\n\n", nome);
            return;
        }

        if (aumentarQuantidade(item, quantidade)) {
            item.setValor(valor);
            System.out.printf("Valor atualizado para R$%.2f | Quantidade atual: %s\n\n", valor, item.getQuantidade());
        }
    }

    public void removerItem() {
        String nome = lerNome("Digite o nome do item que deseja remover: ");

        Item item = buscarItem(nome);

        if (item != null) {
            itens.remove(item);
            System.out.println("O item foi removido com sucesso!\n");
        } else {
            System.out.println("O item digitado não existe\n");
        }
    }

    public void consultarLista() {
        if (itens.isEmpty()) {
            System.out.println("A lista de itens está vazia\n");
            return;
        }

        for (Item item : itens) {
            System.out.printf("Item: %s | Quantidade: %s | Valor Unitário: %.2f | Valor Total: %.2f\n\n", item.getNome(), item.getQuantidade(), item.getValor(), item.subTotal());
        }
    }

    public BigDecimal valorTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Item item : itens) {
            total = total.add(item.subTotal());
        }

        return total;
    }

    public void alterarQuantidadeItem() {

        String nome = lerNome("Digite o nome do item que deseja alterar: ");

        Item item = buscarItem(nome);

        if (item == null) {
            System.out.println("O item digitado não existe\n");
            return;
        }

        int quantidade = lerInteiroPositivo("Digite a quantidade do item que deseja alterar: ");

        System.out.println("""
            Qual das opções você deseja realizar?
            1 - Aumentar a quantidade
            2 - Diminuir a quantidade
            """);

        int opcao = lerInteiro("Escolha a opção desejada: ");

        switch (opcao) {
            case 1 -> {
                if (aumentarQuantidade(item, quantidade)) {
                    System.out.printf("A quantidade foi incrementada (%s)\n\n", item.getQuantidade());
                }
            }
            case 2 -> diminuirQuantidade(item, quantidade);
            default -> System.out.println("Escolha inválida\n");
        }
    }

    public boolean encerrarLista() {
        if (itens.isEmpty()) {
            System.out.println("A lista está vazia\n");
            return false;
        }

        BigDecimal totalCompra = valorTotal();

        System.out.printf("Valor total da compra R$%.2f\n\n", totalCompra);
        System.out.println("""
                Qual será a forma de pagamento?
                1 - Pagamento à vista (Pix/Dinheiro)
                2 - Cartão da loja
                """);

        int opcao = lerInteiro("Escolha a opção desejada: ");

        Pagamento forma = switch (opcao) {
            case 1 -> PIX;
            case 2 -> CARTAO;
            default -> null;
        };

        if (forma == null) {
            System.out.println("Opção inválida!\n");
            return false;
        }

        BigDecimal total = totalCompra.multiply(forma.getFatorDesconto()).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Valor total para pagar R$ " + total);

        return true;
    }

    private Item buscarItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    private boolean aumentarQuantidade(Item item, int quantidade) {
        if (limiteInvalido(item.getQuantidade(), quantidade)) return false;
        item.setQuantidade(item.getQuantidade() + quantidade);
        return true;
    }

    private void diminuirQuantidade(Item item, int quantidade) {
        if (item.getQuantidade() - quantidade <= 0) {
            System.out.println("A quantidade precisa continuar maior que 0\n");
            return;
        }
        item.setQuantidade(item.getQuantidade() - quantidade);
        System.out.printf("A quantidade foi decrementada (%s)\n\n", item.getQuantidade());
    }
}
