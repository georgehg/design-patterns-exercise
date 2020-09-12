package com.softplan.exercicio2;

import com.softplan.exercicio2.json.ComposicaoDto;
import com.softplan.exercicio2.model.TipoItem;
import com.softplan.exercicio2.model.TipoUnidade;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputHelperTest {

    private static final String USER_DIR = System.getProperty("user.dir");

    @Test
    public void shouldReturn_ListaComposicao() throws IOException {
        File inputFile = InputHelper.getInputFile(
                new String[]{USER_DIR + "/src/test/resources/input-items-composicoes.json"});
        List<ComposicaoDto> composicoes = InputHelper.parseListaComposicao(inputFile);

        System.out.println(composicoes);

        ComposicaoDto composicaoDto1 = composicoes.get(0);
        assertEquals((Integer) 94793, composicaoDto1.getCodigoComposicao());
        assertEquals("REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, " +
                "INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO " +
                "FORNECIMENTO E INSTALAÇÃO. AF_06/2016", composicaoDto1.getDescricaoComposicao());
        assertEquals(TipoUnidade.UN, composicaoDto1.getUnidadeComposicao());
        assertEquals(TipoItem.INSUMO, composicaoDto1.getTipoItem());
        assertEquals((Integer) 3148, composicaoDto1.getCodigoItem());
        assertEquals("FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)", composicaoDto1.getDescricaoItemComposicao());
        assertEquals(TipoUnidade.UN, composicaoDto1.getUnidadeItem());
        assertEquals("0.0190000", composicaoDto1.getQuantidadeComposicao().toString());
        assertEquals("9.40", composicaoDto1.getValorUnitario().toString());

        ComposicaoDto composicaoDto2 = composicoes.get(5);
        assertEquals((Integer) 87286, composicaoDto2.getCodigoComposicao());
        assertEquals(TipoUnidade.M3, composicaoDto2.getUnidadeComposicao());
        assertEquals(TipoItem.COMPOSICAO, composicaoDto2.getTipoItem());
        assertEquals((Integer) 88830, composicaoDto2.getCodigoItem());
        assertEquals(TipoUnidade.CHP, composicaoDto2.getUnidadeItem());
        assertEquals("1.1900000", composicaoDto2.getQuantidadeComposicao().toString());
        assertEquals(BigDecimal.ZERO, composicaoDto2.getValorUnitario());
    }

}
