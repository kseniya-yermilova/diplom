package net.hotel.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationHotelPage {
    private WebDriver driver;

    public RegistrationHotelPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isPageLoad(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState").equals("complete");
    }

    @FindBy(xpath = "//form[@id='add_hotel']")
    private WebElement dataSection;
}
