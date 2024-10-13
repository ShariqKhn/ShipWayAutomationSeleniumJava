package com.shipway.utilities;



import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;
    String path = "C:\\Users\\User\\IdeaProjects\\ShipWayLogisticAutomation\\Configuration\\config.properties";

    //constructor
    public ReadConfig()
    {
        try
        {
            properties = new Properties();
            FileInputStream fs = new FileInputStream(path);
            properties.load(fs);
        } catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }
    }


        public String getBaseURL ()
        {
            String url = properties.getProperty("baseUrl");
            if (url != null) {
                return url;
            } else {
                throw new RuntimeException("BaseUrl is not specified in config file");
            }
        }

    public String getBrowser ()
    {
        String url = properties.getProperty("browser");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("Browser is not specified in config file");
        }
    }

        public String getUserName ()
        {
            String username = properties.getProperty("username");
            if (username != null) {
                return username;
            } else {
                throw new RuntimeException("Username is not specified in config file");
            }
        }

        public String getPassword ()
        {
            String pwd = properties.getProperty("password");
            if (pwd != null) {
                return pwd;
            } else {
                throw new RuntimeException("Password is not specified in config file");
            }
        }


}
