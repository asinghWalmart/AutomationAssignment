package org.wallmart.ca.DriverManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.wallmart.ca.Util.Config;

import java.util.ResourceBundle;

public class DriverFactory {
    private static ResourceBundle propertyFileHandler;
    // Create a Webdriver Instance
    public static WebDriver createInstance(Logger logger){
        //Create Instance of Property File
        propertyFileHandler = Config.getResourceBundle();
        String browser =  propertyFileHandler.getString("browser");
        String chromeDriverPath = propertyFileHandler.getString("chromeDriverpath");
        String homeDirectory = System.getProperty("user.dir");

        System.out.println(homeDirectory+chromeDriverPath);

        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome")  ){
            logger.debug("****Trying to Create an Instance of Chrome Webdriver ****");
            logger.debug("Current User Directory"+homeDirectory);
            System.setProperty("webdriver.chrome.driver", homeDirectory+chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            logger.debug("****Successfully Created Chrome Driver Instance  ****");
            return driver;
        }
        // add different Browsers below if needed
        else{
            logger.debug("****Unable to Create Chromedriver Instance.Current Chrome drive path is "+ homeDirectory+chromeDriverPath+"****");
            return null;
        }


    }
}
