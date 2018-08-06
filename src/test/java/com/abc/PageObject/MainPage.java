package com.abc.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    @FindBy(xpath="//*[@content-desc='Views']")
    WebElement views;

    WebElement text;

    /**
     * 点击Views
     * @return
     */
    public ViewPage gotoViews(){
        views.click();
        ViewPage page = new ViewPage();
        return page;
    }
}
