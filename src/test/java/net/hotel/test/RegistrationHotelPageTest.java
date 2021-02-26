package net.hotel.test;

import net.hotel.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationHotelPageTest extends BaseTest{
    @Test
    public void testCanOpenRegistrationPage(){
        boolean result = new MainPage(driver).openRegistrationHotelPage().isPageLoad();
        Assert.assertTrue(result,"Page should be loaded");
    }
    @Test
    public void testDataSectionIsDisplayed(){
        boolean result = new MainPage(driver).openRegistrationHotelPage().isDataSectionDisplayed();
        Assert.assertTrue(result,"Data section should be displayed");
    }
    @Test
    public void testSaveButtonIsDisplayed(){
        boolean result = new MainPage(driver).openRegistrationHotelPage().isSaveButtonDisplayed();
        Assert.assertTrue(result,"Save button should be displayed");
    }
}
