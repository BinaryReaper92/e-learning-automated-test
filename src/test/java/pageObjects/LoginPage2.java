package pageObjects;

import com.codeborne.selenide.SelenideElement;
import utilities.ElementFinder;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage2 {



    public SelenideElement getEmailInput() {
        return ElementFinder.myFindElement("(//form//input)[1]");
       // return ElementFinder.myFindElement("#text-field-3");
    }

    public SelenideElement getPasswordInput() {
        return ElementFinder.myFindElement("(//form//input)[2]");
    }

    public SelenideElement getLoginButton() {
 //       return ElementFinder.myFindElement("div.login-page div.h-100.row.g-0 div.login-page__login-container-col.col-lg-4.col-6 div.login-container.login-page__login-container div.mt-3:nth-child(2) form.login-form div.login-form__button-container:nth-child(4) > button.button-wrapper.btn.login-form__button-container__button.btn-block.button-wrapper--medium");
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
