package org.wallmart.ca.TestCases;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.wallmart.ca.DriverManager.DriverFactory;
import org.wallmart.ca.DriverManager.DriverManager;
import org.wallmart.ca.TestData.TestData;
import org.wallmart.ca.Util.Config;
import org.wallmart.ca.Util.LoggingUtils;

import java.util.ResourceBundle;

public class BaseTest {
    public static ResourceBundle propertyFileHandler;
    public static Logger logger;

    @BeforeSuite
    protected void setUp() throws ParseException {
        // set up property file
        propertyFileHandler = Config.getResourceBundle();
        StatusLogger.getLogger().setLevel(Level.OFF);
        LoggingUtils.setLoggingFileName(propertyFileHandler.getString("pathToLog4jXml"));
        logger = LoggingUtils.getLogger();
        LoggingUtils.setLogLevel(logger, "DEBUG");
        TestData.initaliseJsonParser(logger);
        WebDriver driver = DriverFactory.createInstance(logger);
        DriverManager.setDriver(driver);
    }

    @AfterSuite
    public void suiteTearDown() {
        DriverManager.closeDriver();
    }

}
