package testObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjects.DashboardPage;
import utilities.BasePageTest;


import java.util.function.Function;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.page;

public class DashboardPageTest {

    public static void checkIfPageTitleIs (String title){
        DashboardPage dashboardPage = page(DashboardPage.class);
        dashboardPage.getPageTitle().shouldHave(Condition.text(title));
    }
}
