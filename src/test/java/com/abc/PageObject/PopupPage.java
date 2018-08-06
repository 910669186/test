package com.abc.PageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class PopupPage {
    @AndroidFindBy(accessibility = "Make a Popup")
    WebElement makePopup;
    @FindBy(xpath = "//android.widget.TextView[@Text='Add']")
    WebElement add;

    public String makePopupAdd() {
        makePopup.click();
        add.click();
        return "";
    }
}
