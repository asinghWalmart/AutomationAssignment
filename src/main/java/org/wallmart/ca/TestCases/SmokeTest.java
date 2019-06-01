package org.wallmart.ca.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wallmart.ca.PageObjects.SearchProductPage;
import org.wallmart.ca.PageObjects.WallmartLandingPage;
import org.wallmart.ca.TestData.DataProviderClass;
import org.wallmart.ca.TestData.TestData;
import org.wallmart.ca.Util.LoggingUtils;

public class SmokeTest extends BaseTest {

    @Test(dataProvider = "searchItems", dataProviderClass = DataProviderClass.class)
    public void testSearchFunctionality(String searchItem){
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = WallmartLandingPage.getLandingPage(logger);
        Assert.assertTrue(landingPage !=null,"Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem,logger);
        Assert.assertTrue(searchPage !=null,"Search Page is Successfully Launched");
        // Verify that Search is Successfull
        Assert.assertTrue( searchPage.isSearchPageLoaded(logger) ,"Searching Items is Successfull");
    }

    @Test()
    public void testAccountCreation() throws Exception{
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = WallmartLandingPage.getLandingPage(logger);
        landingPage.getCreateAccountPage(logger);
    }

    @Test()
    public void verifyItemsAddedToCart() throws Exception{
        String searchItem = TestData.getData("cart", "searchItem", logger);
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = WallmartLandingPage.getLandingPage(logger);
        Assert.assertTrue(landingPage !=null,"Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem,logger);
        Assert.assertTrue(searchPage !=null,"Search Page is Successfully Launched");
        Assert.assertTrue( searchPage.isSearchPageLoaded(logger) ,"Searching Items is Successfull");
        // Add Items to Cart
        Assert.assertTrue( searchPage.addItemsToCart(logger) ,"Item Added to Cart");
        // Checkout Page is Displayed.
        Assert.assertTrue( searchPage.getCheckoutPage(logger)!=null ,"Checkout Page is displayed");
    }

    @Test()
    public void verifySecuredCheckoutPage() throws Exception{
        String searchItem = TestData.getData("cart", "searchItem", logger);
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = WallmartLandingPage.getLandingPage(logger);
        Assert.assertTrue(landingPage !=null,"Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem,logger);
        Assert.assertTrue(searchPage !=null,"Search Page is Successfully Launched");
        Assert.assertTrue( searchPage.isSearchPageLoaded(logger) ,"Searching Items is Successfull");
        // Add Items to Cart
        Assert.assertTrue( searchPage.addItemsToCart(logger) ,"Item Added to Cart");
        // Checkout Page is Displayed.
        Assert.assertTrue( searchPage.getCheckoutPage(logger)!=null ,"Checkout Page is displayed");
    }
}