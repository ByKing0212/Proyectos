package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {
    public static Properties loadProperty(String propertyPath) {
        try (InputStream inputStream = new FileInputStream(propertyPath)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
