package com.example;

public class Configuration {
    private Integer port;
    private String webroot;

    public Configuration() {};

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getWebroot() {
        return webroot;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }
}
