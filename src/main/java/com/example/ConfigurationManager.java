package com.example;

import com.example.exception.HttpConfigurationException;
import com.example.utilities.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager==null){
            myConfigurationManager= new ConfigurationManager();
            return myConfigurationManager;
        }
        return myConfigurationManager;
    }

    public void loadConfigurationManager(String filepath) {
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            throw new HttpConfigurationException(e);
        }
        StringBuffer sb= new StringBuffer();
        int i;
        while(true){
            try {
                if (!((i=fileReader.read()) != -1)) break;
            } catch (IOException e) {
                throw new HttpConfigurationException(e);
            }
            sb.append((char)i);
        }
        JsonNode conf= null;
        try {
            conf = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing the configuration file",e);
        }
        try {
            myCurrentConfiguration =Json.fromJson(conf,Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfigurationException("Error parsing the configuration file,To Configuration Class from Json",e);
        }
    }

    public Configuration getMyCurrentConfiguration(){
        if(myCurrentConfiguration ==null){
            throw new HttpConfigurationException("No current configuration set");
        }
      return myCurrentConfiguration;
    }
}
