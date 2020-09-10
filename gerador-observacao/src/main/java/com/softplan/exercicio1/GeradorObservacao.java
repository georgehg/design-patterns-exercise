package com.softplan.exercicio1;

public class GeradorObservacao {

    //Textos pré-definidos
    private static final String UMA_NOTA_MSG = "Fatura da nota fiscal de simples remessa: %s.";
    private static final String VARIAS_NOTAS_MSG = "Fatura das notas fiscais de simples remessa: %s.";

    private GeradorObservacao() {
    }

    public static String geraObservacao(FormatableList listaNF) {
        if (listaNF.listSize() <= 0) {
            return "";
        }

        String mensagem = resolveMensagem(listaNF.listSize());
        String codigos = listaNF.formataListaCodigos();

        return String.format(mensagem, codigos);
    }

    private static String resolveMensagem(int listSize) {
        if (listSize >= 2) {
            return VARIAS_NOTAS_MSG;
        } else {
            return UMA_NOTA_MSG;
        }
    }

}
