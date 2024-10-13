package com.shipway.testcases;

import com.shipway.pageobject.IndexPage;
import com.shipway.pageobject.MyAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;



public class TC02_SignUp extends BaseClass
{
    IndexPage page;
    MyAccount account;


    @Test
public void verifyLoginWithValidCredentials() throws  Exception
{
    driver.get(url);
    logger.info("Url is opened");

    page=new IndexPage(driver);
    page.clickOnLogin();
    logger.info("Login is Sucessfull");

    Thread.sleep(2000);

    String mainWindow=driver.getWindowHandle();
    System.out.println(mainWindow);

    Set<String> windowHandles=driver.getWindowHandles();

    for(String handle : windowHandles)
    {
        if(!handle.equals(mainWindow))
        {
            driver.switchTo().window(handle);
            break;
        }
    }

    logger.info("Switch to next window");

    String actual=driver.getTitle();
    Assert.assertEquals(actual, "Administration panel");


    logger.info("Assertion passed");

    account=new MyAccount(driver);
    account.enterEmail("kefali5685@scarden.com");
    account.enterPassword("Igate@1316");
    account.Login();

    logger.info("Successfully login with valid crednitals");







}
}
