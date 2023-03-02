package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordModal {

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/h5[1]/span[1]")
    @CacheLookup
    public static WebElement titleForgotPassword;

    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
    @CacheLookup
    public static WebElement textForgotPasswordEmail;

    @FindBy(xpath = "//span[contains(text(),'This field is required!')]")
    @CacheLookup
    public static WebElement emptyForgotPasswordEmail;

    @FindBy(xpath = "//span[contains(text(),'Please provide valid email address!')]")
    @CacheLookup
    public static WebElement invalidForgotPasswordEmail;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/button[1]/i[1]")
    @CacheLookup
    public static WebElement buttonX;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/button[1]")
    @CacheLookup
    public static WebElement buttonClose;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/button[2]")
    @CacheLookup
    public static WebElement buttonSend;

}
