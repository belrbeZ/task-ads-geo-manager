package com.keeper.util.validation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by AlexVasil on 30.04.2017.
 *
 * @author AlexVasil
 */
public class Deserializer {

    public static class StringIntegerDeserializer extends JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String valueAsString = "";
            try {
                valueAsString = jsonParser.getValueAsString();
            } catch (Exception e) {
                System.out.println(e);
            }
            int integer = (int) Double.parseDouble(valueAsString);
            return integer;
        }
    }

}
