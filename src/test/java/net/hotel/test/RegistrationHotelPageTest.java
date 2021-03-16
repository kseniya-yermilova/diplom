package net.hotel.test;

import net.hotel.enums.CityUsa;
import net.hotel.enums.Country;
import net.hotel.pages.MainPage;
import net.hotel.pages.RegistrationHotelPage;
import net.hotel.utils.TestHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationHotelPageTest extends BaseTest {
    @Test
    public void testCanOpenRegistrationPage() {
        boolean result = new MainPage(driver).openRegistrationHotelPage().isPageLoad();
        Assert.assertTrue(result, "Page should be loaded");
    }

    @Test
    public void testDataSectionIsDisplayed() {
        WebElement dataSectionElement = new MainPage(driver).openRegistrationHotelPage().dataSection;
        boolean result = dataSectionElement.isDisplayed();
        Assert.assertTrue(result, "Data section should be displayed");
    }

    @Test
    public void testCheckNameLabelMarkedWithAsterix() {
        WebElement element = new MainPage(driver).openRegistrationHotelPage().nameLabel;
        String labelText = element.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "Name field should be marked with asterisk");
    }

    @Test
    public void testSaveButtonIsDisplayed() {
        WebElement saveButtonElement = new MainPage(driver).openRegistrationHotelPage().saveButton;
        boolean result = saveButtonElement.isDisplayed();
        Assert.assertTrue(result, "Save button should be displayed");
    }

    @Test
    public void testNameFieldIsDisplayed() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().nameField;
        boolean result = nameElement.isDisplayed();
        Assert.assertTrue(result, "Name Field should be displayed");
    }

    @Test
    public void testNameFieldAllowsToInput() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().nameField;
        String text = "Example hotel";
        nameElement.sendKeys(text);
        Assert.assertEquals(nameElement.getAttribute("value"), text);
    }

    @Test
    public void testNameFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement nameElement = rhp.nameLabel;
        boolean result = rhp.isErrorExistsFor(nameElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsGlobalRatingDisplayed() {
        WebElement globalRatingElement = new MainPage(driver).openRegistrationHotelPage().globalRatingLabel;
        boolean result = globalRatingElement.isDisplayed();
        Assert.assertTrue(result, "Global Rating Field should be displayed");
    }

    @Test
    public void testIsDateFieldDisplayed() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().dateField;
        boolean result = dateElement.isDisplayed();
        Assert.assertTrue(result, "Date Field should be displayed");
    }

    @Test
    public void testCheckDateLabelMarkedWithAsterix() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().dateLabel;
        String labelText = dateElement.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "Date field should be marked with asterisk");
    }

    @Test
    public void testDateFieldAllowsToInput() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().dateField;
        String text = "3/24/03";
        nameElement.sendKeys(text);
        Assert.assertEquals(nameElement.getAttribute("value"), text);
    }

    @Test
    public void testIsNotPossibleToSaveIncorrectDate() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.dateField;
        String text = "3.24.03";
        dateElement.sendKeys(text);
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testDateFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.dateLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsCountryFieldDisplayed() {
        WebElement countryElement = new MainPage(driver).openRegistrationHotelPage().countryField;
        boolean result = countryElement.isDisplayed();
        Assert.assertTrue(result, "Country Field should be displayed");
    }

    @Test
    public void testCheckCountryLabelMarkedWithAsterix() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().countryLabel;
        String labelText = dateElement.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "Country field should be marked with asterisk");
    }

    @Test
    public void testCountryFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.countryLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsCityFieldDisplayed() {
        WebElement cityElement = new MainPage(driver).openRegistrationHotelPage().cityField;
        boolean result = cityElement.isDisplayed();
        Assert.assertTrue(result, "City Field should be displayed");
    }

    @Test
    public void testCheckCityLabelMarkedWithAsterix() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().cityLabel;
        String labelText = dateElement.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "City field should be marked with asterisk");
    }

    @Test
    public void testCityFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.cityLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsShortDescriptionFieldDisplayed() {
        WebElement shortDescriptionElement = new MainPage(driver).openRegistrationHotelPage().shortDescriptionField;
        boolean result = shortDescriptionElement.isDisplayed();
        Assert.assertTrue(result, "Short Description Field should be displayed");
    }

    @Test
    public void testCheckShortDescriptionLabelMarkedWithAsterix() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().shortDescriptionLabel;
        String labelText = dateElement.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "Short Description field should be marked with asterisk");
    }

    @Test
    public void testShortDescriptionFieldAllowsToInput() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().shortDescriptionField;
        String text = "Great view";
        nameElement.sendKeys(text);
        Assert.assertEquals(nameElement.getAttribute("value"), text);
    }

    @Test
    public void testShortDescriptionFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.shortDescriptionLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsDescriptionFieldDisplayed() {
        WebElement descriptionElement = new MainPage(driver).openRegistrationHotelPage().descriptionField;
        boolean result = descriptionElement.isDisplayed();
        Assert.assertTrue(result, "Description Field should be displayed");
    }

    @Test
    public void testCheckDescriptionLabelMarkedWithAsterix() {
        WebElement dateElement = new MainPage(driver).openRegistrationHotelPage().descriptionLabel;
        String labelText = dateElement.getText();
        Assert.assertTrue(TestHelper.isAsterixLastCharIn(labelText), "Description field should be marked with asterisk");
    }

    @Test
    public void testDescriptionFieldAllowsToInput() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().descriptionField;
        String text = "Our hotel is home to an outdoor pool and fitness center with a sauna.";
        nameElement.sendKeys(text);
        Assert.assertEquals(nameElement.getAttribute("value"), text);
    }

    @Test
    public void testDescriptionFieldCantBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.descriptionLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertTrue(result, "Error massage should be desplayed");
    }

    @Test
    public void testIsNotesFieldDisplayed() {
        WebElement notesElement = new MainPage(driver).openRegistrationHotelPage().notesField;
        boolean result = notesElement.isDisplayed();
        Assert.assertTrue(result, "Notes Field should be displayed");
    }

    @Test
    public void testNotesFieldAllowsToInput() {
        WebElement nameElement = new MainPage(driver).openRegistrationHotelPage().notesField;
        String text = "Our adress: bl.Venice, 45";
        nameElement.sendKeys(text);
        Assert.assertEquals(nameElement.getAttribute("value"), text);
    }

    @Test
    public void testNotesFieldCanBeEmpty() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        WebElement dateElement = rhp.notesLabel;
        boolean result = rhp.isErrorExistsFor(dateElement, rhp);
        Assert.assertFalse(result, "Error massage shouldn't be desplayed");
    }

    @Test
    public void testHotelIsPossibleToSave() {
        RegistrationHotelPage rhp = new MainPage(driver).openRegistrationHotelPage();
        String name = "Hilton";
        String date = "03/02/03";
        String country = Country.USA.getName();
        String city = CityUsa.LOSANGELES.getName();
        String shortDescription = "Great view";
        String hotelDescription = "Our hotel is home to an outdoor pool " +
                "and fitness center with a sauna.";
        boolean result = rhp.isHotelSaved(name, date, country,
                city, shortDescription, hotelDescription,
                rhp);
        Assert.assertTrue(result, "Hotel should be saved");
    }


}
