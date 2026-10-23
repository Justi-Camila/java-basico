package utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Leitor {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int QUANTIDADE_MAXIMA = 100;

    public static int lerInteiro(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.\n");
            }
        }
    }

    public static int lerInteiroPositivo(String mensagem) {
        while (true) {
            int numero = lerInteiro(mensagem);
            if (numero > 0) {
                return numero;
            }
            System.out.println("O número deve ser maior que 0.\n");
        }
    }

    public static BigDecimal lerBigDecimalPositivo(String mensagem) {
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

    public static boolean limiteInvalido(int quantidadeAtual, int quantidadeAdicionada) {
        if ((long) quantidadeAtual + quantidadeAdicionada > QUANTIDADE_MAXIMA) {
            System.out.println("Não é possível adicionar mais itens, a quantidade máxima é " + QUANTIDADE_MAXIMA);
            System.out.println();
            return true;
        }
        return false;
    }

    public static String lerNome(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            String nome = scanner.nextLine().trim();
            if (!nome.isEmpty()) {
                return nome;
            }
            System.out.println("O nome não pode ser vazio.\n");
        }
    }
}
