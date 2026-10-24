package POO.endereco;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Brasil", "Parana", "Curitiba", "Xaxim", "AAAAAAAAAAAAA", "123", "casa");
        Documento documento = new Documento("RG", "123456789", "Receita Federal");
        Pessoa pessoa = new Pessoa("Camila", "11/11/1111", new Pessoa("Rosane", "11/11/1111"),
                new Pessoa("Elton", "11/11/1111"));
        Banco banco = new Banco("12345", "AAAAAAAAAAA", "1234.5678/12");
        Agencia agencia = new Agencia("1234", "AAAAAAAAAA", endereco);
        Cliente cliente = new Cliente(pessoa, documento, endereco, "99999-9999", "AAAAAAAAAA", new BigDecimal("5000.00"));
        Conta conta = new Conta(banco, agencia, cliente, "12345567", new BigDecimal("10000"));

        System.out.println(conta);
    }
}
