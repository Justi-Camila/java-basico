package javabasico.mercado.enums;

import java.math.BigDecimal;

public enum Pagamento {

    PIX(new BigDecimal("0.95")),
    CARTAO(new BigDecimal("0.93"));

    private final BigDecimal fatorDesconto;

    Pagamento(BigDecimal fatorDesconto) {
        this.fatorDesconto = fatorDesconto;
    }

    public BigDecimal getFatorDesconto() {
        return fatorDesconto;
    }
}
