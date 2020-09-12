package com.softplan.exercicio2.model;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ComposicaoTest {

    private static final ItemInsumo PEDREIRO = ItemInsumo.of(10, "Mão de Obra de Pedreiro", TipoUnidade.H, BigDecimal.valueOf(30.00));
    private static final ItemInsumo SERVENTE = ItemInsumo.of(11, "Mão de Obra de Servente", TipoUnidade.H, BigDecimal.valueOf(18.00));
    private static final ItemInsumo CIMENTO = ItemInsumo.of(12, "Saco de Cimento", TipoUnidade.UN, BigDecimal.valueOf(30.00));
    private static final ItemInsumo AREIA = ItemInsumo.of(13, "Areia", TipoUnidade.KG, BigDecimal.valueOf(20.00));
    private static final ItemInsumo CAL = ItemInsumo.of(14, "Cal", TipoUnidade.KG, BigDecimal.valueOf(9.00));
    private static final ItemInsumo TIJOLO = ItemInsumo.of(15, "Tijolo 6 furos", TipoUnidade.UN, BigDecimal.valueOf(0.34));

    @Test
    public void calculaComposicaoSimples() {
        Composicao preparoArgamassa =
                Composicao.of(1, "Preparo de argamassa para assentamento", TipoUnidade.M3);

        preparoArgamassa.adicionaInsumo(PEDREIRO, BigDecimal.valueOf(0.5));
        preparoArgamassa.adicionaInsumo(SERVENTE, BigDecimal.ONE);
        preparoArgamassa.adicionaInsumo(CIMENTO, BigDecimal.valueOf(0.1));
        preparoArgamassa.adicionaInsumo(AREIA, BigDecimal.valueOf(5));
        preparoArgamassa.adicionaInsumo(CAL, BigDecimal.ONE);

        assertEquals(BigDecimal.valueOf(145.00).setScale(2), preparoArgamassa.calculaCusto(BigDecimal.ONE));
        assertEquals(BigDecimal.valueOf(435.00).setScale(2), preparoArgamassa.calculaCusto(BigDecimal.valueOf(3)));
    }

    @Test
    public void calculaComposicaoComplexa() {
        Composicao preparoArgamassa =
                Composicao.of(1, "Preparo de argamassa para assentamento", TipoUnidade.M3);

        preparoArgamassa.adicionaInsumo(PEDREIRO, BigDecimal.valueOf(0.5));
        preparoArgamassa.adicionaInsumo(SERVENTE, BigDecimal.ONE);
        preparoArgamassa.adicionaInsumo(CIMENTO, BigDecimal.valueOf(0.1));
        preparoArgamassa.adicionaInsumo(AREIA, BigDecimal.valueOf(5));
        preparoArgamassa.adicionaInsumo(CAL, BigDecimal.ONE);

        Composicao construirParede =
                Composicao.of(2, "Construção de paredes", TipoUnidade.M2);

        construirParede.adicionaInsumo(PEDREIRO, BigDecimal.valueOf(0.5));
        construirParede.adicionaInsumo(SERVENTE, BigDecimal.ONE);
        construirParede.adicionaInsumo(TIJOLO, BigDecimal.TEN);
        construirParede.adicionaInsumo(preparoArgamassa, BigDecimal.valueOf(3));

        assertEquals(BigDecimal.valueOf(471.4).setScale(2), construirParede.calculaCusto(BigDecimal.ONE));
    }

    @Test
    public void calculaComposicao_AtualizandoQuantidade() {

        Composicao preparoArgamassa =
                Composicao.of(1, "Preparo de argamassa para assentamento", TipoUnidade.M3);

        preparoArgamassa.adicionaInsumo(PEDREIRO, BigDecimal.valueOf(0.5));
        preparoArgamassa.adicionaInsumo(SERVENTE, BigDecimal.ONE);
        preparoArgamassa.adicionaInsumo(SERVENTE, BigDecimal.ONE);
        preparoArgamassa.adicionaInsumo(PEDREIRO, BigDecimal.valueOf(1));
        preparoArgamassa.adicionaInsumo(SERVENTE, BigDecimal.valueOf(3));

        assertEquals(BigDecimal.valueOf(135.00).setScale(2), preparoArgamassa.calculaCusto(BigDecimal.ONE));
    }

}
