package com.softplan.exercicio2.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class BigDecimalCustomDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String floatString = jsonParser.getText();

        if (Objects.isNull(floatString) || floatString.isEmpty()) {
            return BigDecimal.ZERO;
        }

        if (floatString.contains(",")) {
            String[] splitedFloatString = floatString.split(",");
            int decimalPlaces = splitedFloatString[splitedFloatString.length-1].length();

            String bigDecimalString = splitedFloatString[0] + "." + splitedFloatString[1];
            BigDecimal bigDecimalValue = BigDecimal.valueOf(Double.parseDouble(bigDecimalString));

            return bigDecimalValue.setScale(decimalPlaces);
        }

        return BigDecimal.valueOf(Double.parseDouble(floatString));
    }

}
