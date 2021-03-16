package net.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Article']")
    private WebElement articleButton;

    @FindBy(xpath = "//span[text()='New']")
    private WebElement newButton;

    @FindBy(xpath = "//span[text()='Hotel']")
    private WebElement hotelButton;

    public RegistrationHotelPage openRegistrationHotelPage(){
        Actions action = new Actions(driver);
        action.moveToElement(articleButton).moveToElement(newButton).
                moveToElement(hotelButton).click(hotelButton).build().perform();
        return new RegistrationHotelPage(driver);
    }

    @FindBy(xpath = "//span[text()='View']")
    private WebElement viewButton;

    @FindBy(xpath = "//span[text()='Hotels']")
    private WebElement hotelsButton;

    public HotelListPage openViewHotelsPage(){
        Actions action = new Actions(driver);
        action.moveToElement(articleButton).moveToElement(viewButton).
                moveToElement(hotelsButton).click(hotelsButton).build().perform();
        return new HotelListPage(driver);
    }
}
