package com.project.home;

import com.cinch.testautomation.ui.base.BaseTest;
import com.cinch.testautomation.ui.security.ZapScan;
import com.project.pages.home.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public class HomePageTest extends BaseTest {

    @Test
    public void test() throws Exception {
        String my_url = "http://php.testsparker.com/process.php?file=Generics/index.nsp";
        // page.getPageInstance(HomePage.class).gotoSite("https://customer.qa.accelerate.cinchhs.com/account");
        page.getPageInstance(HomePage.class).gotoSite(my_url);
        Thread.sleep(5000);
        ZapScan.passiveScan(driver.getCurrentUrl());


    }


}
