package com.project.pages.home;

import com.testautomation.ui.base.BasePage;
import com.testautomation.ui.utilities.Wait;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public HomePage(WebDriver webdriver) {
        super(webdriver);
    }

    Wait wait = new Wait();

    @Step("Go to Site...")
    public void gotoSite(String url) throws Exception {
        gotoURL(url);
    }

}
