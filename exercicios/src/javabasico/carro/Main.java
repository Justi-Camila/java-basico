package javabasico.carro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = 0;

        Carro carro = new Carro();

        do {
            System.out.println("""
                *****MENU*****
                1 - Arrancar carro
                2 - Parar carro
                3 - Aumentar velocidade
                4 - Diminuir velocidade
                5 - Buzinar
                6 - Sair
                Escolha a opção desejada:\s
               \s""");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> carro.arrancarCarro();
                case 2 -> carro.pararCarro();
                case 3 -> carro.aumentarVelocidade();
                case 4 -> carro.diminuirVelocidade();
                case 5 -> carro.buzinar();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida, escolha um dos valores disponíveis");
            }


        } while (escolha != 6);
    }
}
