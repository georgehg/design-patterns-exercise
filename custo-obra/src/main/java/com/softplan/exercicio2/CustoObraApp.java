package com.softplan.exercicio2;

import com.softplan.exercicio2.json.ComposicaoDto;
import com.softplan.exercicio2.model.Composicao;
import com.softplan.exercicio2.model.GeradorComposicao;
import com.softplan.exercicio2.repositorio.RepositorioComposicoes;
import com.softplan.exercicio2.repositorio.RepositorioInsumos;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static java.lang.System.exit;

public class CustoObraApp {

    private static final NumberFormat formatter = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        try {
            File inputFile = InputHelper.getInputFile(args);
            List<ComposicaoDto> composicaoDtos = InputHelper.parseListaComposicao(inputFile);

            RepositorioComposicoes repositorioComposicoes = RepositorioComposicoes.getInstance();
            RepositorioInsumos repositorioInsumos = RepositorioInsumos.getInstance();

            GeradorComposicao geradorComposicao =
                    new GeradorComposicao(repositorioComposicoes, repositorioInsumos);

            geradorComposicao.geraComposicoes(composicaoDtos);

            repositorioComposicoes.retornaTodos()
                    .forEach(composicao -> imprimeValorServico(composicao, BigDecimal.ONE));

        } catch (Exception ex) {
            System.out.println("Um erro inesperado ocorreu: " + ex.getMessage());
            exit(-1);
        }
    }

    private static void imprimeValorServico(Composicao composicao, BigDecimal quantidade) {
        System.out.println(composicao.getCodigo() + " " +
                composicao.getDescricao() + " " +
                composicao.getUnidade() + " " +
                formatter.format(composicao.calculaCusto(quantidade).setScale(2, RoundingMode.DOWN)));
    }

}
