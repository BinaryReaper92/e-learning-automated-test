package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    @FindBy(xpath="//input[@id='mat-input-0']")
    @CacheLookup
    public static WebElement textEmail;

    @FindBy(xpath="//input[@id='mat-input-1']")
    @CacheLookup
    public static WebElement textPassword;

    @FindBy(xpath="//span[@class='mat-button-wrapper']")
    @CacheLookup
    public static WebElement buttonLogin;


    /*
    public void setUserName(String username)
    {
        textEmail.clear();
        textEmail.sendKeys(username);
    }

    public void setPassword(String password)
    {
        textPassword.clear();
        textPassword.sendKeys(password);
    }

    public void clickLogin()
    {

        buttonLogin.click();
    }*/
}
