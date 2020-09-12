package com.softplan.exercicio2.repositorio;

import com.softplan.exercicio2.model.ItemInsumo;

import java.util.*;

public class RepositorioInsumos implements Repositorio<ItemInsumo, Integer> {

    private static final RepositorioInsumos INSTANCE = new RepositorioInsumos();

    private Map<Integer, ItemInsumo> itensInsumos = new LinkedHashMap<>();

    private RepositorioInsumos() {
    }

    public static RepositorioInsumos getInstance() {
        return INSTANCE;
    }

    @Override
    public void salva(ItemInsumo itemInsumo) {
        itensInsumos.putIfAbsent(itemInsumo.getCodigo(), itemInsumo);
    }

    @Override
    public List<ItemInsumo> retornaTodos() {
        return Collections.unmodifiableList(new ArrayList<>(itensInsumos.values()));
    }

    @Override
    public ItemInsumo procura(Integer codigoItem) {
        return itensInsumos.get(codigoItem);
    }

    @Override
    public void limpar() {
        itensInsumos.clear();
    }

}
