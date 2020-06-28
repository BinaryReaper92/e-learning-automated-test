package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageTest {

    public BasePageTest(WebDriver driver, Class aClass) {
        this.driver = driver;
        PageFactory.initElements(driver, aClass);
    }

    protected WebDriver driver;


}
