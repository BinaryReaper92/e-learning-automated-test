package utilities;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestSetup {

    @Before
    public void setup() {

        Log4j.log4jSetup();
        Log4j.startLog("Test is starting.");

        Configuration.timeout = 4000;
        System.setProperty("selenide.timeout", "4000");
    }

    public static WebDriver driver;
/*
    @Before
    public void setup() {

        Log4j.log4jSetup();
        Log4j.startLog("Test is starting.");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        /*
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers/geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
*/
    @After
    public void tearDown() {

        Log4j.endLog("Test is ending.");
    }
}
