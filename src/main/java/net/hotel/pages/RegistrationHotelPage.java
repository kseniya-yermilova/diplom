package net.hotel.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationHotelPage {
    private WebDriver driver;

    public RegistrationHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isPageLoad(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState").equals("complete");
    }

    @FindBy(xpath = "//form[@id='add_hotel']")
    private WebElement dataSection;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    public boolean isDataSectionDisplayed(){
        return dataSection.isDisplayed();
    }

    public boolean isSaveButtonDisplayed(){
        return saveButton.isDisplayed();
    }
}
