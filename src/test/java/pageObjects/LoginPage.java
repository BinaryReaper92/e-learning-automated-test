package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utilities.ElementFinder;

public class LoginPage {

    @FindBy(xpath="(//form//input)[1]")
    @CacheLookup
    //public static WebElement textEmail = ElementFinder.myFindElement( "this");
    public static WebElement textEmail;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]")
    @CacheLookup
    public static WebElement textPassword;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]")
    @CacheLookup
    public static WebElement buttonLogin;

    @FindBy(xpath = "a")
    @CacheLookup
    public static WebElement buttonLoginOnHoover;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/span[1]/div[1]/span[1]")
    @CacheLookup
    public static WebElement invalidEmail;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/span[2]/div[1]/span[1]")
    @CacheLookup
    public static WebElement invalidPassword;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/span[1]/div[1]/span[1]")
    @CacheLookup
    public static WebElement errorLogin;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/h1[1]")
    @CacheLookup
    public static WebElement mainPageTitle;

    @FindBy(xpath = "//div[@class='auth-wrapper__title-box--title']")
    @CacheLookup
    public static WebElement loginPage;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/span[1]/button[1]/i[1]")
    @CacheLookup
    public static WebElement buttonEye;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]")
    @CacheLookup
    public static WebElement buttonForgotPassword;

}
