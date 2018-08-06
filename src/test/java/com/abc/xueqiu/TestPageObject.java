package com.abc.xueqiu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;


public class TestPageObject {
    private static AndroidDriver driver;

    @BeforeClass
    public static void beforeApi() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "xx");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability("chromedriverExecutableDir","/*/chromedriver/2.20h");
//        chromedriver的版本对应关系和下载地址: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md

//        desiredCapabilities.setCapability("noReset", "true");
//        desiredCapabilities.setCapability("fullReset", "false");
//        desiredCapabilities.setCapability("showChromedriverLog", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //隐式等待10秒
    }

    @Test
    public void testPageObject() throws InterruptedException{
        com.abc.xueqiu.MainPage mainPage = new com.abc.xueqiu.MainPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver),mainPage);
        Page自选 page自选 = mainPage.goto自选();
        PageFactory.initElements(new AppiumFieldDecorator(driver),page自选);
        page自选.get沪深股票();
        Page股票 page股票 = page自选.select股票("青岛海尔");
        PageFactory.initElements(new AppiumFieldDecorator(driver),page股票);
        assertEquals(page股票.getName(),"青岛海尔");
        assertTrue(page股票.getPrice()>18);

        assertThat(page股票.getName(),equalTo("青岛海尔"));
        assertThat(page股票.getPrice() , greaterThan(18.22));


//        com.abc.xueqiu.MainPage mainPage = new com.abc.xueqiu.MainPage(driver);
//        mainPage.goto自选().get沪深股票().select股票("青岛海尔"); //比较好的方式

        Thread.sleep(5000);
    }

    @AfterClass
    public static void asd() {
        driver.quit();
    }
}
