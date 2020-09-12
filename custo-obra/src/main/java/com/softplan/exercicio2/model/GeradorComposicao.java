package com.softplan.exercicio2.model;

import com.softplan.exercicio2.json.ComposicaoDto;
import com.softplan.exercicio2.repositorio.Repositorio;

import java.util.List;

public class GeradorComposicao {

    private final Repositorio<Composicao, Integer> composicoes;
    private final Repositorio<ItemInsumo, Integer> insumos;

    public GeradorComposicao(Repositorio composicoes, Repositorio insumos) {
        this.composicoes = composicoes;
        this.insumos = insumos;
    }

    public void geraComposicoes(List<ComposicaoDto> dtos) {
        for (ComposicaoDto dto : dtos) {
            composicoes.salva(ComposicaoMapper.composicaoFromDto(dto));

            if (dto.getTipoItem().equals(TipoItem.INSUMO)) {
                insumos.salva(ComposicaoMapper.insumoFromDto(dto));
            }
        }

        for (ComposicaoDto dto : dtos) {
            composicoes.procura(dto.getCodigoComposicao())
                    .adicionaInsumo(
                            dto.getTipoItem().equals(TipoItem.INSUMO)
                                    ? insumos.procura(dto.getCodigoItem())
                                    : composicoes.procura(dto.getCodigoItem()),
                            dto.getQuantidadeComposicao());
        }
    }

}
