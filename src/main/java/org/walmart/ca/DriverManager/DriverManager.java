package org.wallmart.ca.DriverManager;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> seleniumDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        return seleniumDriver.get();
    }

    public static void setDriver(WebDriver driver){
        seleniumDriver.set(driver);
    }

    public static void closeDriver(){
        if(seleniumDriver.get()!=null){
            seleniumDriver.get().quit();
            seleniumDriver.set(null);
        }
    }

}
