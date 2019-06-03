package org.wallmart.ca.PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {
    By proceedToCheckoutButton = By.xpath("//*[@id='cart-summary']//following::a[@data-automation='checkout-btn-holder-link']");

    public ShoppingCartPage(Logger logger){
        logger.debug("Checkout page is displayed");
        super.setUp(logger);
    }

    public SecureCheckoutPage getSecureCheckoutPage(Logger logger){
        if(isVisible(proceedToCheckoutButton,30,logger)){
            click(proceedToCheckoutButton,logger,30);
            return new SecureCheckoutPage(logger);
        }
        return null;
    }
}
