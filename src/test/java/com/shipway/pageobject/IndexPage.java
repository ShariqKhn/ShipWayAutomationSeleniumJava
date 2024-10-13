package com.shipway.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage
{
    WebDriver ldriver;

    public IndexPage(WebDriver rdriver)
    {
            ldriver=rdriver;

        PageFactory.initElements(rdriver, this);
    }

    //identify WebElements
    @FindBy(xpath = "//div[@class='button-text blue-button-text']")
    private WebElement Login;

    //identify action

    public void clickOnLogin()
    {
        Login.click();
    }

    public boolean isLoginButtonDisplay()
    {
        return Login.isDisplayed();
    }

}
