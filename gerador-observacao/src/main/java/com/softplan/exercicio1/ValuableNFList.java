package com.softplan.exercicio1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class ValuableNFList implements FormatableList {

    private static final String SEPARADOR = ", ";
    private static final String TERMINADOR = " e ";
    private static final String TOTAL_FIELD = "Total = ";

    private static final NumberFormat formatter = new DecimalFormat("#,##0.00");

    private final List<Fatura> faturas;

    public ValuableNFList(List<Fatura> faturas) {
        this.faturas = faturas;
    }

    @Override
    public String formataListaCodigos() {
        if (faturas.size() == 1) {
            Fatura fatura = faturas.get(0);
            return fatura + resolveTotalMsg(fatura.valor);
        }

        //Acha separador
        StringBuilder valores = new StringBuilder();
        BigDecimal total = BigDecimal.ZERO;

        for (Iterator<Fatura> iterator = faturas.iterator(); iterator.hasNext(); ) {
            Fatura fatura = iterator.next();
            total = total.add(fatura.valor);

            if (valores.length() <= 0) {
                valores.append(fatura);
            } else if (iterator.hasNext()) {
                valores.append(SEPARADOR).append(fatura);
            } else {
                valores.append(TERMINADOR).append(fatura);
            }
        }

        return valores.append(resolveTotalMsg(total)).toString();
    }

    private String resolveTotalMsg(BigDecimal total) {
        return ". " + TOTAL_FIELD + formatter.format(total);
    }

    @Override
    public int listSize() {
        return faturas.size();
    }

    public static class Fatura {

        private static final String PREPOSICAO = " cujo valor é ";
        private static final String MOEDA = "R$ ";

        private final Integer codigo;
        private final BigDecimal valor;

        public Fatura(Integer codigo, BigDecimal valor) {
            this.codigo = codigo;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return codigo + PREPOSICAO + MOEDA + formatter.format(valor);
        }
    }

}
