package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath){
        Properties properties= new Properties();
        BufferedReader reader;
        try{
            reader=new BufferedReader(new FileReader(filePath));
            properties.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file now found at "+filePath);
        } catch (IOException e) {
            throw new RuntimeException("failed to load properties file"+ filePath);
        }
        return properties;
    }

}
