package core.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LoaderPropertiesFile {


    private  static final String URL_DRIVER_PROPERTIES = "driver.properties";
    private Map<String,String> properties = new HashMap<>();

    protected LoaderPropertiesFile() {
        addPropertiesPivotal();
        addPropertiesGradle();
        addPropertiesDriver();
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void addPropertiesPivotal() {
        Properties propertiesPivotal = loadFile("pivotal.properties");
        propertiesPivotal.forEach((key, value) -> properties.put( key.toString() , value.toString()));
        
    }

    public void addPropertiesGradle() {
        Properties propertiesGradle = loadFile("gradle.properties");
        propertiesGradle.forEach((key, value) -> properties.put( key.toString() , value.toString()));
    }

    public void addPropertiesDriver() {
        Properties propertiesGradle = loadFile(URL_DRIVER_PROPERTIES);
        propertiesGradle.forEach((key, value) -> properties.put( key.toString() , value.toString()));
    }

    public static LoaderPropertiesFile getInstance(){
        return new LoaderPropertiesFile();
    }

    private Properties loadFile(String url) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(url);
            // load a properties file
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
