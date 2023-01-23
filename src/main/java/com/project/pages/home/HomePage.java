package com.project.pages.home;

import com.cinch.testautomation.ui.base.BasePage;
import com.cinch.testautomation.ui.utilities.Wait;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver webdriver) {
        super(webdriver);
    }

    Wait wait = new Wait();

    @FindBy(xpath = "//input[@placeholder='Card number']")
    private WebElement txtbox_CardNumber;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    private WebElement txtbox_CVV;


    @Step("Go to Agent Site...")
    public void gotoSite(String url) throws Exception {
        gotoURL(url);
    }

}
