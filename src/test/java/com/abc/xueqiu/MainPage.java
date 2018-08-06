package com.abc.xueqiu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath = "//*[@text='自选']")
    WebElement 自选;
    @FindBy(xpath = "//*[@text='行情']")
    WebElement 行情;

    public Page自选 goto自选(){
        自选.click();
        Page自选 page自选 = new Page自选();
        return page自选;
    }

//    RemoteWebDriver driver;
//    By 自选 = By.xpath("//*[@text='自选']");
//    By 行情 = By.xpath("//*[@text='行情']");
//
//    public  MainPage(RemoteWebDriver driver){
//        this.driver = driver;
//    }
//    public Page自选 goto自选(){
//        driver.findElement(自选).click();
//        driver.findElement(行情).click();
//    }
}
