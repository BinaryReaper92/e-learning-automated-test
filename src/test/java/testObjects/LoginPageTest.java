package testObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;
import utilities.BasePageTest;

public class LoginPageTest extends BasePageTest {



    public LoginPageTest(WebDriver driver)
    {
       super(driver,LoginPage.class);
    }




    public void setUserName(String username) throws InterruptedException {
        Thread.sleep(5000);
        LoginPage.textEmail.clear();
        LoginPage.textEmail.sendKeys(username);

    }

    public void setPassword(String password){
        LoginPage.textPassword.clear();
        LoginPage.textPassword.sendKeys(password);
    }

    public void clickLogin()
    {

        LoginPage.buttonLogin.click();
    }
}
