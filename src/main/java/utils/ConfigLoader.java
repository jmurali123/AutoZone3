package utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;

    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env=System.getProperty("env","PROD");
        switch(env){
            case "PROD":
                properties=PropertyUtils.propertyLoader("src\\test\\resources\\prod_config.properties");
                break;
            case "STAGE":
                properties=PropertyUtils.propertyLoader("src\\test\\resources\\stage_config.properties");
                break;
            default:
                throw new IllegalStateException("Invalid env "+env);

        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader==null){
            configLoader=new ConfigLoader();
        }
        return configLoader;
    }

    public String getURL(){
        String prop=properties.getProperty("baseUrl");
        if(prop!=null)
            return prop;
        else throw new RuntimeException("property baseUrl is not specified in the properties file");
    }

    public String getUsername(){
        String prop=properties.getProperty("username");
        if(prop!=null)
            return prop;
        else throw new RuntimeException("property username is not specified in the properties file");
    }

    public String getPassword(){
        String prop=properties.getProperty("password");
        if(prop!=null)
            return prop;
        else throw new RuntimeException("property password is not specified in the properties file");
    }
}
