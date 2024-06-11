package com.galleryview.com.gv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    private final String propertyFilePath = "src/main/resources/config.properties"; // Update the path accordingly
    private final String ArtWorkFilePath = "src/main/resources/config.properties"; // Update the path accordingly

    public ConfigReader() {
    	
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + propertyFilePath);
        }
        
//        This is for the Artwork File Configurations
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(ArtWorkFilePath);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file cannot be found at " + ArtWorkFilePath);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
