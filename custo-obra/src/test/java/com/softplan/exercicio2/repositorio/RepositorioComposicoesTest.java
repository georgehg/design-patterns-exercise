package com.softplan.exercicio2.repositorio;

import com.softplan.exercicio2.model.Composicao;
import com.softplan.exercicio2.model.ItemInsumo;
import com.softplan.exercicio2.model.TipoUnidade;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class RepositorioComposicoesTest {

    private RepositorioComposicoes repositorioComposicoes = RepositorioComposicoes.getInstance();
    private RepositorioInsumos repositorioInsumos = RepositorioInsumos.getInstance();

    @Before
    public void setup() {
        repositorioComposicoes.limpar();
        repositorioInsumos.limpar();
    }

    @Test
    public void guardaComposicao() {
        repositorioComposicoes.salva(Composicao.of(10, "Composicao Simples", TipoUnidade.M3));
        repositorioComposicoes.salva(Composicao.of(20, "Composicao Complexa", TipoUnidade.M2));

        assertEquals(2, repositorioComposicoes.retornaTodos().size());

        Composicao composicao = repositorioComposicoes.retornaTodos().get(1);
        assertEquals((Integer) 20, composicao.getCodigo());
        assertEquals("Composicao Complexa", composicao.getDescricao());
        assertEquals(TipoUnidade.M2, composicao.getUnidade());
    }

    @Test
    public void guardaInsumo() {
        repositorioInsumos.salva(ItemInsumo.of(10, "Areia", TipoUnidade.KG, BigDecimal.TEN));
        repositorioInsumos.salva(ItemInsumo.of(20, "Pedreiro", TipoUnidade.H, BigDecimal.TEN));

        assertEquals(2, repositorioInsumos.retornaTodos().size());

        ItemInsumo itemInsumo = repositorioInsumos.retornaTodos().get(0);
        assertEquals((Integer) 10, itemInsumo.getCodigo());
        assertEquals("Areia", itemInsumo.getDescricao());
        assertEquals(TipoUnidade.KG, itemInsumo.getUnidade());
        assertEquals(BigDecimal.TEN, itemInsumo.getValor());
    }

}
