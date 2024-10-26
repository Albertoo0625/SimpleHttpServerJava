package com.example;

public class Driver {
    public static void main(String args[]){
        System.out.println("Hello World");

        ConfigurationManager.getInstance().loadConfigurationManager("src/main/resources/http.json");
        Configuration conf=ConfigurationManager.getInstance().getMyCurrentConfiguration();

        System.out.println("Using Port "+ conf.getPort());
        System.out.println("Using Webroot "+ conf.getWebroot());
    }
}
