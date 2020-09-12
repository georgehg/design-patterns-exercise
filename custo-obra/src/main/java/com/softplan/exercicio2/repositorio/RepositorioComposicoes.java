package com.softplan.exercicio2.repositorio;

import com.softplan.exercicio2.model.Composicao;

import java.util.*;

public class RepositorioComposicoes implements Repositorio<Composicao, Integer> {

    private static final RepositorioComposicoes INSTANCE = new RepositorioComposicoes();

    private Map<Integer, Composicao> composicoes = new LinkedHashMap<>();

    private RepositorioComposicoes() {
    }

    public static RepositorioComposicoes getInstance() {
        return INSTANCE;
    }

    @Override
    public void salva(Composicao composicao) {
        composicoes.putIfAbsent(composicao.getCodigo(), composicao);
    }

    @Override
    public List<Composicao> retornaTodos() {
        return Collections.unmodifiableList(new ArrayList<>(composicoes.values()));
    }

    @Override
    public Composicao procura(Integer codigoComposicao) {
        return composicoes.get(codigoComposicao);
    }

    @Override
    public void limpar() {
        composicoes.clear();
    }

}
