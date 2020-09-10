package com.softplan.exercicio1;

import com.softplan.exercicio1.ValuableNFList.Fatura;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

    private static final String SINGULAR_MESSAGE = "Fatura da nota fiscal de simples remessa: %s.";
    private static final String PLURAL_MESSAGE = "Fatura das notas fiscais de simples remessa: %s.";

    @Test
    public void shouldReturn_SimpleList_SingularMessage() {
        final Integer nfNumber = 100;
        SimpleNFList simpleNFList = new SimpleNFList(Collections.singletonList(nfNumber));
        String message = GeradorObservacao.geraObservacao(simpleNFList);

        assertEquals(String.format(SINGULAR_MESSAGE, nfNumber), message);
    }

    @Test
    public void shouldReturn_SimpleList_PluralMessage_TwoNumbers() {
        final String expectedList = "100 e 200";

        SimpleNFList simpleNFList = new SimpleNFList(Arrays.asList(100, 200));
        String message = GeradorObservacao.geraObservacao(simpleNFList);

        assertEquals(String.format(PLURAL_MESSAGE, expectedList), message);
    }

    @Test
    public void shouldReturn_SimpleList_PluralMessage_SeveralNumbers() {
        final String expectedList = "100, 200, 300 e 400";

        SimpleNFList simpleNFList = new SimpleNFList(Arrays.asList(100, 200, 300, 400));
        String message = GeradorObservacao.geraObservacao(simpleNFList);

        assertEquals(String.format(PLURAL_MESSAGE, expectedList), message);
    }

    @Test
    public void shouldReturn_SimpleList_EmptyMessage() {
        String message = GeradorObservacao.geraObservacao(new SimpleNFList(Collections.EMPTY_LIST));

        assertEquals("", message);
    }

    @Test
    public void shouldReturn_ValuableList_SingularMessage() {
        final Fatura fatura = new Fatura(100, BigDecimal.TEN);
        final String expectedList = "100 cujo valor é R$ 10,00. Total = 10,00";

        ValuableNFList valuableNFList = new ValuableNFList(Collections.singletonList(fatura));
        String message = GeradorObservacao.geraObservacao(valuableNFList);

        assertEquals(String.format(SINGULAR_MESSAGE, expectedList), message);
    }

    @Test
    public void shouldReturn_ValuableList_PluralMessage_TwoNumbers() {
        final Fatura fatura1 = new Fatura(100, BigDecimal.TEN);
        final Fatura fatura2 = new Fatura(200, BigDecimal.valueOf(35));
        final String expectedList = "100 cujo valor é R$ 10,00 e 200 cujo valor é R$ 35,00. Total = 45,00";

        ValuableNFList valuableNFList = new ValuableNFList(Arrays.asList(fatura1, fatura2));
        String message = GeradorObservacao.geraObservacao(valuableNFList);

        assertEquals(String.format(PLURAL_MESSAGE, expectedList), message);
    }

    @Test
    public void shouldReturn_ValuableLis_PluralMessage_SeveralNumbers() {
        final Fatura fatura1 = new Fatura(100, BigDecimal.TEN);
        final Fatura fatura2 = new Fatura(200, BigDecimal.valueOf(35));
        final Fatura fatura3 = new Fatura(300, BigDecimal.valueOf(5));
        final Fatura fatura4 = new Fatura(400, BigDecimal.valueOf(1500));
        final Fatura fatura5 = new Fatura(500, BigDecimal.valueOf(0.30));
        final String expectedList = "100 cujo valor é R$ 10,00, 200 cujo valor é R$ 35,00, 300 cujo valor é R$ 5,00,"
                + " 400 cujo valor é R$ 1.500,00 e 500 cujo valor é R$ 0,30. Total = 1.550,30";

        ValuableNFList valuableNFList = new ValuableNFList(Arrays.asList(fatura1, fatura2, fatura3, fatura4, fatura5));
        String message = GeradorObservacao.geraObservacao(valuableNFList);

        assertEquals(String.format(PLURAL_MESSAGE, expectedList), message);
    }

    @Test
    public void shouldReturn_ValuableList_EmptyMessage() {
        String message = GeradorObservacao.geraObservacao(new ValuableNFList(Collections.EMPTY_LIST));

        assertEquals("", message);
    }

}
