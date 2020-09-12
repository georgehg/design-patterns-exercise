package com.softplan.exercicio2.repositorio;

import com.softplan.exercicio2.model.ComposableInsumo;

import java.util.List;

public interface Repositorio<T extends ComposableInsumo, ID> {

    void salva(T entrada);

    List<T> retornaTodos();

    T procura(ID id);

    void limpar();

}
