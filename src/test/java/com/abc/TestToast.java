package com.abc;

import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestToast {

    private static AndroidDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName","xx");
        desiredCapabilities.setCapability("appPackage","com.myzaker.ZAKER_Phone");
        desiredCapabilities.setCapability("appActivity",".view.LogoActivity");
        desiredCapabilities.setCapability("automationName","uiautomator2");
//        desiredCapabilities.setCapability("chromedriverExecutableDir","/*/chromedriver/2.20h");
//        chromedriver的版本对应关系和下载地址: https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/web/chromedriver.md

        desiredCapabilities.setCapability("noReset", "false");
        desiredCapabilities.setCapability("unicodeKeyboard", "true");
        desiredCapabilities.setCapability("ResetKeyboard", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl,desiredCapabilities);

    }

    @Test
    public void pageSource() throws InterruptedException{
        driver.findElementByAccessibilityId("Views").click();  //点击文本view
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())." +
                "scrollIntoView(new UiSelector().text(\"Popup Menu\"));").click(); //滚动查找文本 Popup Menu
        driver.findElementByAccessibilityId("Make a Popup").click();  //点击文本view
        driver.findElementByXPath("//android.widget.TextView[@text='Add']").click();

        //循环五次是因为Toast只显示三秒
        for (int i = 0;i<5;i++){
            System.out.print(driver.getPageSource());
            System.out.print("Toast");
            System.out.print(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
        }

        driver.getContextHandles();
        driver.getWindowHandles();//查找上下文

        driver.quit();
    }

    @Test
    public void addToastMsgToRoot(){
        System.out.print(driver.getPageSource());
    }
}
