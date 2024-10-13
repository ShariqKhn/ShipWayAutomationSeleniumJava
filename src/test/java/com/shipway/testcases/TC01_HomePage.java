package com.shipway.testcases;

import com.shipway.pageobject.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_HomePage extends BaseClass
{
    IndexPage page;


    @Test
    public void verifyTitleandLoginbtn()throws Exception
    {
        driver.get(url);
        logger.info("url opened");

        String actual=driver.getTitle();

        Assert.assertEquals(actual, "Ecommerce Shipping Automation Solution & Aggregation for India.");

        Thread.sleep(2000);

        page=new IndexPage(driver);
        page.clickOnLogin();

        Thread.sleep(1000);

    }

    @Test
    public void testLoginBtnDisplayed()
    {
        driver.get(url);
        logger.info("url opened");
        page=new IndexPage(driver);
        Assert.assertTrue(page.isLoginButtonDisplay());
        logger.info("Login button is displayed in the page");
    }




}
