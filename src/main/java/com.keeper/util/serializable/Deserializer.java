package com.keeper.util.serializable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by AlexVasil on 30.04.2017.
 *
 * @author AlexVasil
 */
public class Deserializer {

    private static final Logger logger = LoggerFactory.getLogger(Deserializer.class);

    public static class StringIntegerDeserializer extends JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            String valueAsString = "";
            try {
                valueAsString = jsonParser.getValueAsString();
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
            return (int) Double.parseDouble(valueAsString);
        }
    }

}
