package com.softplan.exercicio2.model;

import com.softplan.exercicio2.InputHelper;
import com.softplan.exercicio2.repositorio.RepositorioComposicoes;
import com.softplan.exercicio2.repositorio.RepositorioInsumos;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class GeradorComposicaoTest {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String JSON_FILE_NAME = "/src/test/resources/input-items-composicoes.json";
    private static final File JSON_FILE = new File(USER_DIR + JSON_FILE_NAME);

    @Test
    public void guardaComposicoes_e_ItemsdeConsumo() throws IOException {
        RepositorioComposicoes repositorioComposicoes = RepositorioComposicoes.getInstance();
        RepositorioInsumos repositorioInsumos = RepositorioInsumos.getInstance();

        GeradorComposicao geradorComposicao = new GeradorComposicao(repositorioComposicoes, repositorioInsumos);

        geradorComposicao.geraComposicoes(InputHelper.parseListaComposicao(JSON_FILE));

        assertEquals(5, repositorioComposicoes.retornaTodos().size());
        assertEquals(6, repositorioInsumos.retornaTodos().size());

        assertEquals(BigDecimal.valueOf(100.5886),
                repositorioComposicoes.procura(94793)
                        .calculaCusto(BigDecimal.ONE).setScale(4));

        assertEquals(BigDecimal.valueOf(3.93889),
                repositorioComposicoes.procura(98561)
                        .calculaCusto(BigDecimal.ONE).setScale(5));
    }

}
