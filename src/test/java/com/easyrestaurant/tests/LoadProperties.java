package com.easyrestaurant.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	 public String userEmail;
	 public String userPassword;
	 public Properties properties;
	
	public void loadProperties() {
        FileInputStream fis = null;

        try {
            properties = new Properties();
            fis = new FileInputStream("src/test/resources/properties/config.properties");
            properties.load(fis);

            userEmail = properties.getProperty("userEmail");
            userPassword = properties.getProperty("userPassword");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
