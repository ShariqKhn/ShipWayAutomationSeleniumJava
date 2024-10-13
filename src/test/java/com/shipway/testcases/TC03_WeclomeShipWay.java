package com.shipway.testcases;

import com.shipway.pageobject.IndexPage;
import com.shipway.pageobject.MyAccount;
import com.shipway.pageobject.WelcomePage;
import com.shipway.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

public class TC03_WeclomeShipWay extends BaseClass
{
    IndexPage page;
    MyAccount account;
    WelcomePage wel;

    @Test
   // @Test(dataProvider = "LoginDataProvider")
    public void verifyWelcomePage() throws Exception {
        driver.get(url);
        logger.info("Url is opened");

        page = new IndexPage(driver);
        page.clickOnLogin();
        logger.info("Login is Sucessfull");

        Thread.sleep(2000);

        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        logger.info("Switch to next window");

       // String actual = driver.getTitle();
       // Assert.assertEquals(actual, "Administration panel");
        // logger.info("Assertion passed");

        account = new MyAccount(driver);
        account.enterEmail("kefali5685@scarden.com");

       // captureScreenShot(driver,"verifyWelcomePage");
        //Assert.assertTrue(false);

        account.enterPassword("Igate@1316");
        account.Login();

        logger.info("Successfully login with valid crednitals");

        wel=new WelcomePage(driver);
        wel.verifytheWelcomeHeadLine();

        logger.info("Welcome to ShipWay is Displayed");
        wel.verifytheGetStartedbtnAvaialable();
        logger.info("Get Started Now button is Dislpyed");
    }

  //  @DataProvider(name ="LoginDataProvider")
    public String[][] LoginDataProvider() {
        String filename = System.getProperty("user,dir") + "\\TestData\\ShipwayTestData.xlsx";

        int rows = ReadExcelFile.getRowCount(filename, "LoginDataProvider");
        int columns = ReadExcelFile.getColCount(filename, "LoginDataProvider");

        String data[][] = new String[rows - 1][columns];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i - 1][j] = ReadExcelFile.getCellValue(filename, "LoginDataProvider", i, j);
            }
        }
        return data;

    }
}