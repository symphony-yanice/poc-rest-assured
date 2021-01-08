package com.symphony.qa.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    protected Properties configProperties;

    public Config() throws IOException {
        this.configProperties = new Properties();

        // API Environment setup
        String apiConfigFilePath = "configuration/environment/api.properties";
        this.loadPropertiesFile(apiConfigFilePath);

        // Data setup
        String dataConfigFilePath = "configuration/environment/data.properties";
        this.loadPropertiesFile(dataConfigFilePath);
    }

    private void loadPropertiesFile(String filepath) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(filepath).getFile());
        FileInputStream configFileInputStream = new FileInputStream(file);
        this.configProperties.load(configFileInputStream);
        configFileInputStream.close();
    }

    public String getProperty(String name) {
        return configProperties.getProperty(name);
    }
}
