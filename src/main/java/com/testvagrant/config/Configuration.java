package com.testvagrant.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class  Configuration {

    private static Configuration INSTANCE;
    private final Properties properties = new Properties();
    private Configuration() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("src/test/resources/application.properties");
        properties.load(fileInputStream);
    }

    public static Configuration getInstance() throws IOException {
        if(INSTANCE == null)
            INSTANCE = new Configuration();
        return INSTANCE;
    }

    public String getProperty(String key) {
        return INSTANCE.properties.getProperty(key);
    }

    public String baseURI() {
        return getProperty("api.base.uri");
    }

    public String basePath() {
        return getProperty("api.base.path");
    }

}
