package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import utilities.ElementFinder;
import utilities.ElementFinder2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage2 {

    /*public SelenideElement getEmailInput() {
        return $x("(//form//input)[1]");
    }*/

    public SelenideElement getEmailInput() {
        return ElementFinder2.myFindElement2("(//form//input)[1]");
    }

    public SelenideElement getPasswordInput() {
        return ElementFinder.myFindElement("(//form//input)[2]");
    }

    public SelenideElement getLoginButton() {
        return ElementFinder.myFindElement("//button[contains(@class,'login-form__button-container__button')]");
    }

    public SelenideElement getEmailEmptyError(){
        return $x("//span[contains(text(),'This field is required!')]");
    }

    public SelenideElement getPasswordEmptyError(){
        return $x("//body/div[@id='root']/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/span[2]/div[1]/span[1]");
    }

    public SelenideElement getEmailInvalidError(){
        return $x("//span[contains(text(),'Please provide valid email address!')]");
    }

    public SelenideElement getNonExistingAccountError(){
        return $x("//span[contains(text(),'Incorrect Email or Password!')]");
    }


}
