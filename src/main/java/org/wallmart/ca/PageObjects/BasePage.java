package org.wallmart.ca.PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wallmart.ca.DriverManager.DriverFactory;
import org.wallmart.ca.DriverManager.DriverManager;
import org.wallmart.ca.Util.Config;


public class BasePage {
    String url;
    WebDriver driver;
    private JavascriptExecutor js;

    public void setUp(Logger logger) {
        driver = DriverManager.getDriver();
        if(driver == null){
            driver = DriverFactory.createInstance(logger);
            DriverManager.setDriver(driver);
        }
    }

    public WebElement getElement(By by, Logger logger) {
        if (by == null) {
            logger.debug("By Object is Null ");
            return null;
        } else {
            if (isVisible(by, 30, logger)) {
                logger.debug("Creating WebElement Using By Object " + by.toString());
                return driver.findElement(by);
            }
            return null;
        }
    }

    public WebElement getElement(By by, long timeToWait, Logger logger) {
        if (by == null) {
            logger.debug("By Object is Null ");
            return null;
        } else {
            if (isVisible(by, timeToWait, logger)) {
                logger.debug("Creating WebElement Using By Object " + by.toString());
                return driver.findElement(by);
            }
            return null;
        }
    }

    //a[@title='Click to close.']

    // return null;


    public boolean highlightElement(WebElement element, Logger logger) {
        // logger.("Highlighting the Element to click :- " + element.toString());
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px dashed red;');", element);
        js.executeScript("arguments[0].setAttribute('style','border: solid 4px white');", element);
        return true;
    }

    // click function for webdriver
    public boolean click(By element, Logger logger, long timeToWait) {
        By feedBackModal = By.xpath("//a[@title='Click to close.']");
        logger.debug("Trying to click an WelElement " + element.toString());
        WebElement myElement = getElement(element, logger);
        WebElement feedBackModalElement = getElement(feedBackModal,1,logger);
        if(feedBackModalElement == null){
            logger.debug("Feedback Modal is not displayed ");
        }
        else {
            logger.debug("Feedback Modal is displayed .... CLICKING THE MODAL ");
            feedBackModalElement.click();
        }
        //scrollToElement(element,logger);
        highlightElement(myElement, logger);
        // check to see if Element is visible
        logger.debug("Check to see if WebElement is visible in the Dom ");
        if (isVisible(element, timeToWait, logger)) {
            logger.debug("Element is visible.. Clicking on the Element");

            if (scrollToElement(myElement, logger)) {
                myElement.click();
                return true;
            }

        }

        logger.debug("Element is not visible " + element.toString());
        return false;

    }


    public boolean hasLoaded(By element, long timeToWait) {
        try {

            WebElement myDynamicElement = (new WebDriverWait(driver, timeToWait))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            return false;
        } catch (Error error) {
            return false;
        }
        return true;

    }

    public boolean isClickable(WebElement element, long timeToWait) {
        try {

            WebElement myDynamicElement = (new WebDriverWait(driver, timeToWait))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        } catch (Error error) {
            return false;
        }
        return true;

    }


    public boolean isVisible(By element, long timeToWait, Logger logger) {
        try {
            boolean result = hasLoaded(element, timeToWait);
            logger.debug("Element is Visible " + element + "-----> " + result);
            return result;
        } catch (Exception e) {
            return false;
        } catch (Error error) {
            return false;
        }
    }

    public boolean sendKeys(By element, String stringToSend, Logger logger) {
        if (stringToSend.length() == 0) {
            logger.debug("There is no String to send");
            return false;
        }

        WebElement myElement = getElement(element, logger);
        logger.debug("User has Requested to send String as  " + stringToSend);
        highlightElement(myElement, logger);
        if (isClickable(myElement, 30)) {
            logger.debug("Element is Clickable " + element.toString());
            if (isVisible(element, 30, logger)) {
                logger.debug("Element is visible.. Sending String as " + stringToSend);
                myElement.sendKeys(stringToSend);
                return true;
            }
            myElement.sendKeys(stringToSend);
            return true;
        }

        return false;

    }

    public boolean moveMouseToElement(By element, Logger logger) {
        WebElement myElement = getElement(element, logger);
        new Actions(driver).moveToElement(myElement).build().perform();
        return true;
    }

    public boolean scrollToElement(WebElement element, Logger logger) {
        logger.debug("Scroll to Element " + element.toString());
        logger.debug("Verify if Element is Visible");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        highlightElement(element, logger);
        return true;
    }


}
