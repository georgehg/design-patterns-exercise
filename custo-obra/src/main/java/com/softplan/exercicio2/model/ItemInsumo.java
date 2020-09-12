package com.softplan.exercicio2.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemInsumo implements ComposableInsumo{

    private final Integer codigo;

    private final String descricao;

    private final TipoUnidade unidade;

    private final BigDecimal valor;

    private ItemInsumo(Integer codigo, String descricao, TipoUnidade unidade, BigDecimal valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.valor = valor;
    }

    public static ItemInsumo of(Integer codigo, String descricao, TipoUnidade unidade, BigDecimal valor) {
        return new ItemInsumo(codigo, descricao, unidade, valor);
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

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public BigDecimal calculaCusto(BigDecimal quantidade) {
        return valor.multiply(quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInsumo that = (ItemInsumo) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "ItemInsumo{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", unidade=" + unidade +
                ", valor=" + valor +
                '}';
    }
}
