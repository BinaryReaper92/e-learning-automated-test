package utilities;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ElementFinder2 {
/*
    public static SelenideElement myFindElementById(String locator) {
        SelenideElement element = $(byId(locator));
        element.shouldBe(Condition.visible);
        return element;
    }*/

    public static SelenideElement myFindElement2(String locator) {
        SelenideElement element = $(byId(locator));
        if (!element.exists()) {
            element = $(byName(locator));
        }
        if (!element.exists()) {
            element = $(byCssSelector(locator));
        }
        if (!element.exists()) {
            element = $(byXpath(locator));
        }
        if (!element.exists()) {
            element = $(byLinkText(locator));
        }
        if (!element.exists()) {
            element = $(byPartialLinkText(locator));
        }
        if (!element.exists()) {
            element = $(byClassName(locator));
        }
        if (!element.exists()) {
            element = $(byTagName(locator));
        }
        element.shouldBe(Condition.visible);
        return element;
    }
}

