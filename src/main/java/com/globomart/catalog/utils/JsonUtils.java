package com.globomart.catalog.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtils {
	
	private static ObjectMapper MAPPER=new ObjectMapper();
	
    public static <T> T jsonToClass(String json, Class<T> classType) 
    {
        T object = null;
        try
        {
            object = MAPPER.readValue(json, classType);
        }
        catch (IOException e)
        {
        	System.out.println("Exception while Json Parsing");
        }
        return object;
    }
    
    public static String readValueAsString(Object object) throws JsonProcessingException {
		return MAPPER.writeValueAsString(object);
	}
}