package com.softplan.exercicio1;

import java.util.Iterator;
import java.util.List;

public class SimpleNFList implements FormatableList {

    private static final String SEPARADOR = ", ";
    private static final String TERMINADOR = " e ";

    private final List<Integer> numerosNF;

    public SimpleNFList(List<Integer> numerosNF) {
        this.numerosNF = numerosNF;
    }

    @Override
    public String formataListaCodigos() {
        if (numerosNF.size() == 1) {
            return String.valueOf(numerosNF.get(0));
        }

        //Acha separador
        StringBuilder codigos = new StringBuilder();

        for (Iterator<Integer> iterator = numerosNF.iterator(); iterator.hasNext(); ) {
            Integer codigo = iterator.next();

            if (codigos.length() <= 0) {
                codigos.append(codigo);
            } else if (iterator.hasNext()) {
                codigos.append(SEPARADOR).append(codigo);
            } else {
                codigos.append(TERMINADOR).append(codigo);
            }
        }

        return codigos.toString();
    }

    @Override
    public int listSize() {
        return numerosNF.size();
    }

}
