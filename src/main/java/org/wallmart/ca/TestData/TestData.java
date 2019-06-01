package org.wallmart.ca.TestData;


import com.google.gson.JsonObject;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestData {
    static JSONParser jasonParser;
    static Object jsonFileObject;
    static JSONObject jsonObject;

    public static void initaliseJsonParser(Logger logger) throws ParseException {
        jasonParser = new JSONParser();
        String homeDirectory = System.getProperty("user.dir");
        System.out.println(homeDirectory);
        String jsonFilePath = homeDirectory + "\\src\\main\\resources\\testData.json";
        System.out.println(jsonFilePath);

        try {
            jsonFileObject = jasonParser.parse(new FileReader(jsonFilePath));
            jsonObject = (JSONObject) jsonFileObject;
            logger.debug("****** Json Parser Initialized ******* ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getData(String pageName, String propertyName, Logger logger) {
        JSONObject pageObject = (JSONObject) jsonObject.get(pageName);
        if (pageObject == null) {
            logger.debug("**** Page Object Not Found *** " + pageName);
            return null;
        }
        logger.debug("*** Returning Data for Page [" + pageName + "] , Property +[" + propertyName + "]");
        String pageName1 = (String) pageObject.get(propertyName);
        return pageName1;
    }


    public static List getDataArray(String pageName, String arrayObjectName,Logger logger) {
        JSONObject pageObject = (JSONObject) jsonObject.get(pageName);
        JSONArray listItem = (JSONArray) pageObject.get(arrayObjectName);
        if (listItem.size() > 0) {
            logger.debug("No of List Found :- " + listItem.size());
            return listItem;
        }
        logger.debug("No Such Array Items Present in JSON File.. ");
        return null;
    }


}
