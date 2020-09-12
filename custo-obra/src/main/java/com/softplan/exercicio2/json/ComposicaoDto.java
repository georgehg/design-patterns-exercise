package com.softplan.exercicio2.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.softplan.exercicio2.model.TipoItem;
import com.softplan.exercicio2.model.TipoUnidade;

import java.math.BigDecimal;

public class ComposicaoDto {

    private final Integer codigoComposicao;

    private final String descricaoComposicao;

    private final TipoUnidade unidadeComposicao;

    private final TipoItem tipoItem;

    private final Integer codigoItem;

    private final String descricaoItemComposicao;

    private final TipoUnidade unidadeItem;

    @JsonDeserialize(using = BigDecimalCustomDeserializer.class)
    private final BigDecimal quantidadeComposicao;

    @JsonDeserialize(using = BigDecimalCustomDeserializer.class)
    private final BigDecimal valorUnitario;

    private ComposicaoDto(Integer codigoComposicao, String descricaoComposicao, TipoUnidade unidadeComposicao,
                          TipoItem tipoItem, Integer codigoItem, String descricaoItemComposicao, TipoUnidade unidadeItem,
                          BigDecimal quantidadeComposicao, BigDecimal valorUnitario) {
        this.codigoComposicao = codigoComposicao;
        this.descricaoComposicao = descricaoComposicao;
        this.unidadeComposicao = unidadeComposicao;
        this.tipoItem = tipoItem;
        this.codigoItem = codigoItem;
        this.descricaoItemComposicao = descricaoItemComposicao;
        this.unidadeItem = unidadeItem;
        this.quantidadeComposicao = quantidadeComposicao;
        this.valorUnitario = valorUnitario;
    }

    protected ComposicaoDto() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public Integer getCodigoComposicao() {
        return codigoComposicao;
    }

    public String getDescricaoComposicao() {
        return descricaoComposicao;
    }

    public TipoUnidade getUnidadeComposicao() {
        return unidadeComposicao;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public String getDescricaoItemComposicao() {
        return descricaoItemComposicao;
    }

    public TipoUnidade getUnidadeItem() {
        return unidadeItem;
    }

    public BigDecimal getQuantidadeComposicao() {
        return quantidadeComposicao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    @Override
    public String toString() {
        return "Composicao{" +
                "codigoComposicao=" + codigoComposicao +
                ", descricaoComposicao='" + descricaoComposicao + '\'' +
                ", unidadeComposicao=" + unidadeComposicao +
                ", tipoItem=" + tipoItem +
                ", codigoItem=" + codigoItem +
                ", descricaoItemComposicao='" + descricaoItemComposicao + '\'' +
                ", unidadeItem=" + unidadeItem +
                ", quantidadeComposicao=" + quantidadeComposicao +
                ", valorUnitario=" + valorUnitario +
                '}';
    }

}
