package net.hotel.utils;

import org.openqa.selenium.WebDriver;

public final class TestHelper {
    public static WebDriver driver;
    private TestHelper() {

    }

    public static void sleepSeconds(int secondsToSleep) {
        try {
            Thread.sleep(secondsToSleep * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAsterixLastCharIn(String text) {
        return (text.lastIndexOf('*') == text.length() - 1);
    }
}
