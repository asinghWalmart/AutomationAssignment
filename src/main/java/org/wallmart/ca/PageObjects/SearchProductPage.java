package org.wallmart.ca.PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;


public class SearchProductPage extends BasePage {
    private By searchResults = By.xpath("//*[@data-automation ='search-adjustments']");
    private By searchResultNumbers = By.xpath("//*[@data-automation ='results-numbers' ]");
    private By searchResultItem = By.xpath("//*[@data-automation ='results-search-keyword' ]");
    private By addItemToCartButton = By.xpath("(//*[@class='button add-to-cart-btn available'])[1]");
    private By addToCartBanner = By.xpath("//*[@id='lightbox-outer' and @style='display: block;']");
    private By checkOutButton = By.xpath("//*[@data-automation='a2c-checkout-cta']");
    private By checkOutPage = By.xpath("//*[@id='breadcrumb']");

    SearchProductPage(Logger logger){
        setUp(logger);
    }
    public boolean isSearchPageLoaded(Logger logger) {
        if (isVisible(searchResults, 30, logger)) {
            if (isVisible(searchResultNumbers, 30, logger)) {
                if (isVisible(searchResultItem, 30, logger)) {
                    verifySearchResultIsNotZero(logger);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifySearchResultIsNotZero(Logger logger) {
        String searchNumber = getElement(searchResultNumbers, logger).getText();
        String num = searchNumber.replaceAll("[^0-9]", "");
        try {
            int numbersOfItemsDisplayed = Integer.parseInt(num);
            logger.debug("Number of Search Results ----> " + numbersOfItemsDisplayed + "For Item --> " + getElement(searchResultNumbers, logger).getText());
            return true;
        } catch (NumberFormatException e) {
            logger.debug("ERROR parsing search result :- " + e.getMessage());
            return false;
        }

    }

    public boolean addItemsToCart(Logger logger) {
        if (click(addItemToCartButton, logger, 30)) {
            logger.debug("addItemToCartButton is clicked");
            if (isVisible(addToCartBanner, 30, logger)) {
                logger.debug("Add to Cart Banner is Visible ..");
                return true;
            }
        }
        return false;
    }

    public ShoppingCartPage getShoppingCartPage(Logger logger) {
        if (click(checkOutButton, logger, 30)) {
            logger.debug("checkOutButton is clicked");
            if (isVisible(checkOutPage, 30, logger)) {
                logger.debug("Checkout Page is Displayed");
                return new ShoppingCartPage(logger);
            }
        }
        return null;
    }
}
