package com.abc.PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPageObject {
    private static AndroidDriver driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "xx");
        desiredCapabilities.setCapability("appPackage", "com.myzaker.ZAKER_Phone");
        desiredCapabilities.setCapability("appActivity", ".view.LogoActivity");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("chromedriverExecutableDir","/*/chromedriver/2.20h");
//        chromedriver的版本对应关系和下载地址: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md

        desiredCapabilities.setCapability("noReset", "false");
        desiredCapabilities.setCapability("unicodeKeyboard", "true");
        desiredCapabilities.setCapability("ResetKeyboard", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testPageObject() {
        MainPage mainPage = new MainPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver), mainPage);
        ViewPage viewPage = mainPage.gotoViews();
        PageFactory.initElements(new AppiumFieldDecorator(driver), viewPage);
        PopupPage popupPage = viewPage.gotoPopup();
        PageFactory.initElements(new AppiumFieldDecorator(driver), popupPage);
        popupPage.makePopupAdd();
    }

    @AfterClass
    public static void asd() {
        driver.quit();
    }
}
