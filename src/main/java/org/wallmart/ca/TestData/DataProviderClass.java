package org.wallmart.ca.TestData;

import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import static org.wallmart.ca.TestCases.BaseTest.logger;
public class DataProviderClass {
    static List list = TestData.getDataArray("wallmartLandingPage","searchItems",logger);
    static Iterator iterator = list.iterator();

    @DataProvider(name="searchItems")
    public static Object[][] getDataFromDataProvider(){

     Object[][] data = new Object[list.size()][1];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                data[i][j] = (String)iterator.next();
                System.out.println(data[i][j]);
            }
        }
        return data;
    }


}
