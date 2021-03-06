package com.infoshareacademy.jjdd6.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private Properties properties = new Properties();

    public void loadAppProperties() throws IOException {
        properties.load(new FileInputStream("data/dataConfig.properties"));
    }

    public void getProperties() {
        properties.list(System.out);
    }

    public String getDistanceUnit() {
        return properties.getProperty("distanceUnit", "km");
    }
}
