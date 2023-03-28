package pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    public SelenideElement getPageTitle(){
        //return $x("//body/div[@id='root']/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/h1[1]");
        return $x("//h1[contains(@class,'page-header__title')]");
    }
}
