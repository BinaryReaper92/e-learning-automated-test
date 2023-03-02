package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    public SelenideElement getPageTitle(){
        return $x("//h1[contains(@class,'page-header__title')]");
    }
}
