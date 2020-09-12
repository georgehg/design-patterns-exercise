package com.softplan.exercicio2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softplan.exercicio2.json.ComposicaoDto;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputHelper {

    private static final ObjectMapper mapper =
            new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    private InputHelper() {
    }

    public static File getInputFile(String... args) {
        if (args.length > 0) {
            return new File(args[0]);
        }

        try (Scanner console = new Scanner(System.in)) {
            System.out.println("Insira nome e diretório do arquivo de dados: ");
            String inputFileName = console.nextLine();
            return new File(inputFileName);
        } catch (Exception ex) {
            System.out.println("Não foi possível ler o arquivo: " + ex.getMessage());
            throw ex;
        }
    }

    public static List<ComposicaoDto> parseListaComposicao(File file) throws IOException {
        try {
            return mapper.readValue(file, new TypeReference<List<ComposicaoDto>>() {
            });
        } catch (IOException ex) {
            System.out.println("Não foi possível ler o arquivo: " + file.getPath());
            throw ex;
        }
    }

}
