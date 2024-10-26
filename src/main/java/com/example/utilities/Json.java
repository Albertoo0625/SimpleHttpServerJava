package com.example.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class Json {

    private static ObjectMapper myObjectMapper = defaultMapper();

    public static ObjectMapper defaultMapper(){
        ObjectMapper om= new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return om;
    }

    public static JsonNode parse(String JsonSrc) throws JsonProcessingException {
      return myObjectMapper.readTree(JsonSrc);
    }

    public static <A> A fromJson(JsonNode node, Class<A> struct) throws JsonProcessingException {
     return myObjectMapper.treeToValue(node,struct);
    }

    public static JsonNode toJson(Object obj){
        return myObjectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
      return generateJson(node,false);
    }

    public static String stringifyPretty(JsonNode node) throws JsonProcessingException {
        return generateJson(node,true);
    }

    public static String generateJson(Object obj,boolean pretty) throws JsonProcessingException {
        ObjectWriter objectWriter=myObjectMapper.writer();
        if(pretty){
            objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }
        return objectWriter.writeValueAsString(obj);
    }
}
