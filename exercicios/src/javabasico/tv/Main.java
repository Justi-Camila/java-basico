package javabasico.tv;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Tv tv;

    public static void main(String[] args) {

        tv = new Tv();

        int escolha;

        do {
            System.out.println("""
                *****MENU*****
                1 - Ligar TV
                2 - Desligar TV
                3 - Alterar volume
                4 - Alterar canal
                5 - Alterar para canal específico
                6 - Mutar
                7 - Sair
                """);

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> tv.ligarTv();
                case 2 -> tv.desligarTv();
                case 3 -> alterarVolume();
                case 4 -> alterarCanal();
                case 5 -> alterarCanalEspecifico();
                case 6 -> tv.mutar();
            }

        } while (escolha != 7);
    }

    private static void alterarVolume() {
        if (tv.isLigada()) {
            System.out.println("""
                1 - Aumentar volume
                2 - Diminuir Volume
                Escolha a opção que você deseja
                """);

            int escolha = scanner.nextInt();

            System.out.println("Digite o valor que deseja");

            int valor = scanner.nextInt();

            tv.alterarVolume(escolha, valor);
        } else {
            System.out.println("A TV está desligada");
        }

    }

    private static void alterarCanal() {
        if (tv.isLigada()) {
            System.out.println("""
                1 - Próximo canal
                2 - Canal anterior
                Escolha a opção que você deseja
                """);

            int escolha = scanner.nextInt();

            tv.alterarCanal(escolha);
        } else {
            System.out.println("A TV está desligada");
        }

    }

    private static void alterarCanalEspecifico() {
        if (tv.isLigada()) {
            System.out.println("Digite o número do canal que deseja ir");

            int escolha = scanner.nextInt();

            tv.alterarCanalEspecifico(escolha);
        } else {
            System.out.println("A TV está desligada");
        }

    }

}
