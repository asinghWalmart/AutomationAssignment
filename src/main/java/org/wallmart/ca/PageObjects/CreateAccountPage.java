package org.wallmart.ca.PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

public class CreateAccountPage extends BasePage {
    By email = By.xpath("//input[@name='email']");
    By firstName = By.xpath("//input[@name='firstName']");
    By lastName = By.xpath("//input[@name='lastName']");
    By password = By.xpath("//input[@name='password']");
    By confirmPassword = By.xpath("//input[@name='confirmPassword']");

    public CreateAccountPage(Logger l) {
        setUp(l);
    }

    public boolean fillFormForAccountCreation(List list, Logger logger) {
        if (list.size() == 0) {
            logger.debug("List Size is 0");
            return false;
        }
        sendKeys(email, list.get(0).toString().split(":")[1], logger);
        sendKeys(firstName, list.get(1).toString().split(":")[1], logger);
        sendKeys(lastName, list.get(2).toString().split(":")[1], logger);
        sendKeys(password, list.get(3).toString().split(":")[1], logger);
        sendKeys(confirmPassword, list.get(3).toString().split(":")[1], logger);
        return true;

    }

}
