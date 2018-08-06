package com.abc.PageObject;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ViewPage {
    WebElement webview;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())." +
            "scrollIntoView(new UiSelector().text(\"Popup Menu\"));")
    WebElement popup;

    public PopupPage gotoPopup() {
        popup.click();
        PopupPage popupPage = new PopupPage();
        return popupPage;
    }
}
