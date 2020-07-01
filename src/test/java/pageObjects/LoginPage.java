package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(className = "auth-wrapper__error ng-star-inserted")
    @CacheLookup
    public static WebElement errorLogin;

}
