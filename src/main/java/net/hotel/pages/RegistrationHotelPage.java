package net.hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationHotelPage {
    private static WebDriver driver;

    public RegistrationHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState").equals("complete");
    }

    @FindBy(xpath = "//form[@id='add_hotel']")
    public WebElement dataSection;

    @FindBy(xpath = "//*[@id='add_hotel:j_idt40_content']/table")
    public WebElement table;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt42']")
    public WebElement nameLabel;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='add_hotel:name']")
    public WebElement nameField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt46']")
    public WebElement dateLabel;

    @FindBy(xpath = "//*[@id='add_hotel:dateOfConstruction_input']")
    public WebElement dateField;

    @FindBy(xpath = "//*[@id='add_hotel:country_label']")
    public WebElement countryField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt48']")
    public WebElement countryLabel;

    @FindBy(xpath = "//*[@id='add_hotel:city_label']")
    public WebElement cityField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt52']")
    public WebElement cityLabel;

    @FindBy(xpath = "//*[@id='add_hotel:city_panel']/div/ul/li[3]")
    public WebElement cityLosAngeles;

    @FindBy(xpath = "//input[@id='add_hotel:short_description']")
    public WebElement shortDescriptionField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt56']")
    public WebElement shortDescriptionLabel;

    @FindBy(xpath = "//textarea[@id='add_hotel:description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt58']")
    public WebElement descriptionLabel;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt44']")
    public WebElement globalRatingLabel;

    @FindBy(xpath = "//textarea[@id='add_hotel:notes']")
    public WebElement notesField;

    @FindBy(xpath = "//label[@id='add_hotel:j_idt60']")
    public WebElement notesLabel;

//    @FindBy(xpath = "//*[@id='add_hotel:country_panel']/div")
//    public WebElement country;

    @FindBy(xpath = "//*[@id='add_hotel:country']/div[3]/span")
    public WebElement countryDropdownCorner;

    @FindBy(xpath = "//div[@class='ui-selectonemenu-items-wrapper']//li")
    public List<WebElement> dropdownListElements;

    @FindBy(xpath = "//*[@id='add_hotel:city']/div[3]/span")
    public WebElement cityDropdownCorner;


    public void selectDropdownItem(String dropdownItemToBeSelected, WebElement dropdownCorner) {
        dropdownCorner.click();
        for (WebElement dropdownListElement : dropdownListElements) {
            if (dropdownItemToBeSelected.equals(dropdownListElement.getText())) {
                dropdownListElement.click();
                break;
            }
        }
    }

    public static boolean isErrorExistsFor(WebElement element, RegistrationHotelPage rhp) {
        boolean result = false;
        rhp.saveButton.click();
        WebElement tableElement = rhp.table;
        List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));
        String name = element.getText();
        name = name.replace("*", " ").trim();
        for (int row = 1; row < tableRows.size(); row++) {
            String labelText = driver.findElement(By
                    .xpath("//*[@id='add_hotel:j_idt40_content']/table/tbody/tr[" + row + "]/td[3]")).getText();
            if ((labelText != null) && (labelText.contains(name))) result = true;
        }
        return result;
    }

    public static boolean isHotelSaved(String name, String date, String country, String city,
                                       String shortDescription, String description,
                                       RegistrationHotelPage rhp) {
        boolean result = false;
        rhp.nameField.sendKeys(name);
        rhp.dateField.sendKeys(date);
        rhp.selectDropdownItem(country, rhp.countryDropdownCorner);
        rhp.selectDropdownItem(city, rhp.cityDropdownCorner);
        rhp.shortDescriptionField.sendKeys(shortDescription);
        rhp.descriptionField.sendKeys(description);
        rhp.saveButton.click();
        HotelListPage hlp = new MainPage(driver).openViewHotelsPage();
        WebElement hotelsTableElement = hlp.hotelsTable;
        List<WebElement> hotelsTableRows = hotelsTableElement.findElements(By.tagName("tr"));
        for (int row = 1; row < hotelsTableRows.size(); row++) {
            String nameHotel = driver.findElement(By
                    .xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[1]")).getText();
            String shortDescriptionHotel = driver.findElement(By
                    .xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[2]")).getText();
            String cityHotel = driver.findElement(By
                    .xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[5]")).getText();
            String countryHotel = driver.findElement(By
                    .xpath("//table[@role='grid']/tbody/tr[" + row + "]/td[6]")).getText();
            if ((name.equals(nameHotel)) && (shortDescription.equals(shortDescriptionHotel)) &&
                    (country.equals(countryHotel)) && (city.equals(cityHotel))) result = true;
        }
        return result;
    }

}
