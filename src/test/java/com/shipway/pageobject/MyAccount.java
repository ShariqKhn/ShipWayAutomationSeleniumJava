package com.shipway.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount
{
    WebDriver ldriver;

    public MyAccount(WebDriver rdriver)
    {
        ldriver=rdriver;

        PageFactory.initElements(rdriver, this);
    }

@FindBy(name = "user_login")
    private WebElement emailId;
@FindBy(name="password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement sumbit;



    public void enterEmail(String email)
    {
        emailId.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void Login()
    {
        sumbit.click();
    }


}
