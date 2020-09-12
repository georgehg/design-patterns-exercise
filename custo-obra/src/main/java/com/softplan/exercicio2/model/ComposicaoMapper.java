package com.softplan.exercicio2.model;

import com.softplan.exercicio2.json.ComposicaoDto;

public class ComposicaoMapper {

    private ComposicaoMapper() {
    }

    public static Composicao composicaoFromDto(ComposicaoDto dto) {
        return Composicao.of(dto.getCodigoComposicao(),
                dto.getDescricaoComposicao(),
                dto.getUnidadeComposicao());
    }

    public static ItemInsumo insumoFromDto(ComposicaoDto dto) {
        return ItemInsumo.of(dto.getCodigoItem(),
                dto.getDescricaoItemComposicao(),
                dto.getUnidadeItem(),
                dto.getValorUnitario());
    }

}
