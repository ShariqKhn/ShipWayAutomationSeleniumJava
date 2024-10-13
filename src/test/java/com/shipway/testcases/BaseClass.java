package com.shipway.testcases;

import com.shipway.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class BaseClass
{

    ReadConfig readConfig=new ReadConfig();
   String url=readConfig.getBaseURL();

   String browser=readConfig.getBrowser();

   public static WebDriver driver;

   public static Logger logger;


   @BeforeClass
   public void setup() {
      // String browser = "firefox";

       switch (browser.toLowerCase()) {
           case "chrome":

               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;

           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;

           case "edge" :
               WebDriverManager.edgedriver().setup();
               driver=new EdgeDriver();

           default:
               driver = null;
               break;

       }

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


// for logging

       logger = LogManager.getLogger("ShipWayLogisticAutomation");

   }

   @AfterClass
   public void tearDown()
   {
       driver.close();
       driver.quit();
   }


   public void captureScreenShot(WebDriver driver,String testName)throws Exception
   {
       //convert webDriver object to TakeScreenShot interface
       //call getScreenShot method to create image file

       File Src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

       FileUtils.copyFile(Src, new File(System.getProperty("user.dir") + "//screenshot//" + testName + ".png"));






   }

}
