package com.softplan.exercicio2.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Composicao implements ComposableInsumo {

    private final Integer codigo;

    private final String descricao;

    private final TipoUnidade unidade;

    private Map<ComposableInsumo, BigDecimal> insumos = new HashMap<>();

    private Composicao(Integer codigo, String descricao, TipoUnidade unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
    }

    public static Composicao of(Integer codigo, String descricao, TipoUnidade unidade) {
        return new Composicao(codigo, descricao, unidade);
    }

    public void adicionaInsumo(ComposableInsumo insumo, BigDecimal quantidade) {
        insumos.merge(insumo, quantidade, BigDecimal::add);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoUnidade getUnidade() {
        return unidade;
    }

    @Override
    public BigDecimal calculaCusto(BigDecimal quantidade) {
        return insumos.entrySet().stream()
                .map((entry) -> entry.getKey().calculaCusto(entry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .multiply(quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composicao that = (Composicao) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Composicao{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", unidade=" + unidade +
                ", insumos=" + insumos +
                '}';
    }

}
