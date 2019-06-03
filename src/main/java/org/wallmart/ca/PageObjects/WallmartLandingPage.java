package org.wallmart.ca.PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.wallmart.ca.TestData.TestData;
import org.wallmart.ca.Util.Config;
import org.wallmart.ca.Util.LoggingUtils;

public class WallmartLandingPage extends BasePage {
    // All Element Locators Goes in here
    By  searchBar  = By.xpath("//*[@data-automation='search-form-input']");
    By  searchButton =By.xpath("//*[@data-automation='search-form-submit']");
    By  myAccount = By.xpath("//*[@id='my-account-wrap' and @class='flyout-menu-trigger']");
    By  myAccountHovered = By.xpath("//*[@id='my-account-wrap' and @class='flyout-menu-trigger hovered']");
    By  myAccountLink = By.xpath("//*[@class='new-customer-join']/a");

    public WallmartLandingPage getLandingPage(Logger logger) {
        setUp(logger);
        url = Config.getResourceBundle().getString("url");
        driver.navigate().to(url);
        String pageTitle = TestData.getData("wallmartLandingPage", "pageTitle", logger);
        logger.debug("***** Launching Url  ****** " + url);
        if (driver.getTitle().equals(pageTitle)) {
            logger.debug("***** Wallmart Page Successfully Launched ****** ");
            logger.debug(" returning object for Landing Page");
            return this;
        } else {
            LoggingUtils.setLogLevel(logger, "ERROR");
            logger.debug("Unable to create Landing Page");
            return null;
        }

    }

    public SearchProductPage getSearchProductPage(String searchItem, Logger logger) {
        sendKeys(searchBar, searchItem, logger);
        logger.debug("Search Element Found. Search by " + searchItem.toString());
        click(searchButton, logger, 30);
        logger.debug("Search Button Clicked ..  " + searchButton.toString());
        return new SearchProductPage(logger);

    }

    public CreateAccountPage getCreateAccountPage(Logger logger) throws Exception {
        logger.debug("Trying to get a Search Account Page");
        moveMouseToElement(myAccount,logger);
        if (isVisible(myAccountHovered, 30, logger)) {
            logger.debug("Mouse Movement Completed Successfully");
            if (click(myAccountLink, logger, 30)) {
                logger.debug("Account Page Successfully Created.");
                return new CreateAccountPage(logger);
            }
        }
        return null;
    }
}

