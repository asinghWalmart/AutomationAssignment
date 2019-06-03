package org.wallmart.ca.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wallmart.ca.PageObjects.*;
import org.wallmart.ca.TestData.DataProviderClass;
import org.wallmart.ca.TestData.TestData;
import org.wallmart.ca.Util.LoggingUtils;

import java.util.List;

public class SmokeTest extends BaseTest {

    @Test(dataProvider = "searchItems", dataProviderClass = DataProviderClass.class)
    public void testSearchFunctionality(String searchItem) {
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = new WallmartLandingPage().getLandingPage(logger);
        Assert.assertTrue(landingPage != null, "Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem, logger);
        Assert.assertTrue(searchPage != null, "Search Page is Successfully Launched");
        // Verify that Search is Successfull
        Assert.assertTrue(searchPage.isSearchPageLoaded(logger), "Searching Items is Successfull");
    }

    @Test()
    public void testAccountCreation() throws Exception {
        List list = TestData.getDataArray("createAccount","createAccountData",logger);
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = new WallmartLandingPage().getLandingPage(logger);
        CreateAccountPage cap = landingPage.getCreateAccountPage(logger);
        Assert.assertTrue(cap != null, "Create Account Page Successfull Created");
        Assert.assertTrue(cap.fillFormForAccountCreation(list,logger) , "Form Filled Successfully");



    }

    @Test()
    public void verifyItemsAddedToCart() throws Exception {
        String searchItem = TestData.getData("cart", "searchItem", logger);
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = new WallmartLandingPage().getLandingPage(logger);
        Assert.assertTrue(landingPage != null, "Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem, logger);
        Assert.assertTrue(searchPage != null, "Search Page is Successfully Launched");
        Assert.assertTrue(searchPage.isSearchPageLoaded(logger), "Searching Items is Successfull");
        // Add Items to Cart
        Assert.assertTrue(searchPage.addItemsToCart(logger), "Item Added to Cart");
        // Checkout Page is Displayed.
        Assert.assertTrue(searchPage.getShoppingCartPage(logger) != null, "Checkout Page is displayed");
    }

    @Test()
    public void verifySecuredCheckoutPage() throws Exception {
        String searchItem = TestData.getData("cart", "searchItem", logger);
        logger = LoggingUtils.getLogger();
        WallmartLandingPage landingPage = new WallmartLandingPage().getLandingPage(logger);
        Assert.assertTrue(landingPage != null, "Landing Page is Successfully Launched");
        SearchProductPage searchPage = landingPage.getSearchProductPage(searchItem, logger);
        Assert.assertTrue(searchPage != null, "Search Page is Successfully Launched");
        Assert.assertTrue(searchPage.isSearchPageLoaded(logger), "Searching Items is Successfull");
        // Add Items to Cart
        Assert.assertTrue(searchPage.addItemsToCart(logger), "Item Added to Cart");
        // Cart Page is Displayed.
        ShoppingCartPage scp = searchPage.getShoppingCartPage(logger);
        Assert.assertTrue(scp != null, "Shopping Cart Page is displayed");
        // Proceed to Secure Checkout Page
        SecureCheckoutPage securedCheckOutPage = scp.getSecureCheckoutPage(logger);
        Assert.assertTrue(securedCheckOutPage != null, "Secured Checkout Page is displayed");


    }
}
