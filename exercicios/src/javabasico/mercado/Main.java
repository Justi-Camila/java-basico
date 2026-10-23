package javabasico.mercado;

import static utils.Leitor.lerInteiro;

public class Main {
    static Mercado mercado =  new Mercado();

    public static void main(String[] args) {

        int escolha;

        do {
            escolha = lerInteiro(Mercado.MENU + "Escolha a opção desejada: ");

            switch (escolha) {
                case 1 -> mercado.adicionarItem();
                case 2 -> mercado.consultarLista();
                case 3 -> System.out.printf("O valor total é de R$%.2f\n\n", mercado.valorTotal());
                case 4 -> mercado.removerItem();
                case 5 -> mercado.alterarQuantidadeItem();
                case 6 -> {
                    if (mercado.encerrarLista()) {
                        System.exit(0);
                    }
                }
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida, escolha um dos valores disponíveis\n");
            }

        } while (escolha != 7);
    }
}
