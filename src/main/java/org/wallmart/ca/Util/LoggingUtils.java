package org.wallmart.ca.Util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;

import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LoggingUtils {
    private static String testCaseId;

    public static String getNameForLogger(){
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[3];
        String methodName = e.getMethodName();
        System.out.println("Method Name:- "+methodName);
        testCaseId = methodName;
        return methodName;
    }

    public static Logger getLogger(){
        String loggerName = LoggingUtils.getNameForLogger();
        loggerName = "------"+loggerName;
        return LogManager.getLogger(loggerName);
    }


    public static void setLogLevel(Logger logger, String level)
    {
        startAddingLog(logger);
        logger = logger;
        Level logLevel = Level.ERROR;
        switch (level.toUpperCase())
        {
            case "ERROR":
            default:
                break;
            case "DEBUG":
                logLevel = Level.DEBUG;
                break;
            case "OFF":
                logLevel = Level.OFF;
                break;
            case "WARNING":
                logLevel = Level.WARN;
                break;
            case "INFO":
                logLevel = Level.INFO;
                break;
            case "FATAL":
                logLevel = Level.FATAL;
                break;
            case "ALL":
                logLevel = Level.ALL;
                break;
            case "TRACE":
                logLevel = Level.TRACE;
                break;
        }
        Configurator.setLevel(logger.getName(), logLevel);
    }

    public static void setLoggingFileName(String xmlFilePath)
    {
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        String  date = dateFormat.format(d);
        System.setProperty("LOG4J-LOG-FILE-NAME", "C:\\Wallmart\\automation.log" + "\\" + date + ".log");
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        URL url = LoggingUtils.class.getResource(xmlFilePath);
        try {
            context.setConfigLocation(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public static void startAddingLog(Logger logger){
        logger.debug("-----------------New Test Case Starts Here for Test case:---------- " +testCaseId);

    }

}
