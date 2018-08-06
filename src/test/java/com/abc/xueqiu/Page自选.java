package com.abc.xueqiu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page自选 {
    @FindBy(xpath = "//*[@text='股票']")
    WebElement 股票;
    @FindBy(xpath = "//*[@text='沪深']")
    WebElement 沪深;
    @FindBy(id="portfolio_stockName")
    List<WebElement> stocks;

//    By stocks = By.id("portfolio_stockName");

    public void  get沪深股票(){
        股票.click();
        沪深.click();
//        stocks.forEach(e-> System.out.print(e.getText()));
    }

    public  Page股票 select股票(String name){
        for (WebElement element : stocks){
            if (name.equals(element.getText())){
                element.click();
                break;
            }
        }
        return new Page股票();
    }
}
