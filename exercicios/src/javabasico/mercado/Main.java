package javabasico.mercado;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Mercado mercado;

    public static void main(String[] args) {
        mercado = new Mercado(scanner);

        int escolha;

        do {
            escolha = mercado.lerInteiro(Mercado.MENU + "Escolha a opção desejada: ");

            switch (escolha) {
                case 1 -> mercado.adicionarItem();
                case 2 -> mercado.consultarLista();
                case 3 -> System.out.printf("O valor total é de R$%.2f\n\n", mercado.valorTotal());
                case 4 -> mercado.removerItem();
                case 5 -> mercado.alterarQuantidadeItem();
                case 6 -> mercado.encerrarLista();
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida, escolha um dos valores disponíveis\n");
            }

        }while (escolha != 7);
    }
}
