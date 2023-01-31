package com.project.home;

import com.project.pages.home.HomePage;
import com.testautomation.ui.base.BaseTest;
import com.testautomation.ui.reporting.TestListener;
import com.testautomation.ui.security.ZapScan;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ TestListener.class })
public class HomePageTest extends BaseTest {

    @Test
    public void test() throws Exception {
       // String my_url = "https://www.hackthissite.org/";
        String my_url = "http://php.testsparker.com/process.php?file=Generics/index.nsp";
        // page.getPageInstance(HomePage.class).gotoSite("https://customer.qa.accelerate.cinchhs.com/account");
        page.getPageInstance(HomePage.class).gotoSite(my_url);
        Thread.sleep(10000);
        System.out.println("ZAP SCAN TEST" + driver.getCurrentUrl());
        Thread.sleep(5000);
        ZapScan.passiveScan(driver.getCurrentUrl());
        ZapScan.spider(driver.getCurrentUrl());
        ZapScan.activeScan(driver.getCurrentUrl());


    }


}
