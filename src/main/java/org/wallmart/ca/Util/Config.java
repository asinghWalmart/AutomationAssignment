package org.wallmart.ca.Util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class Config {

   private static  Properties prop;
   private static  ResourceBundle input;

    private static ResourceBundle loadPropertyFile() {
        input = ResourceBundle.getBundle("config");
        String browser = input.getString("chromeDriverpath");
        if(input == null){
            System.out.println("Property file not found ");
            System.exit(0);
        }
       else{
            System.out.println("Property File Loaded Successfully");
            return input;
        }
        return null;
    }

    public static ResourceBundle getResourceBundle(){
        if(input == null){
            input = loadPropertyFile();
            return input;
        }
        else{
            return input;
        }

    }

}
