package com.shipway.pageobject;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage
{
    WebDriver ldriver;

    public WelcomePage(WebDriver rdriver)
    {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }


    @FindBy(xpath = "//h1[@class='ship-font-w-700']")
    private WebElement WelcomeHeadLine;

    @FindBy(xpath = "//button[text()='Get Started Now']")
    private WebElement GetStartedNowbtn;


    public boolean verifytheWelcomeHeadLine() {
        return WelcomeHeadLine.isDisplayed();
    }

    public boolean verifytheGetStartedbtnAvaialable() {
        return GetStartedNowbtn.isDisplayed();
    }


}
