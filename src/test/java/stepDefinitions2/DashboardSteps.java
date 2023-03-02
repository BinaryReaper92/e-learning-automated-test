package stepDefinitions2;

import io.cucumber.java.en.Then;
import testObjects.DashboardPageTest;

import java.io.IOException;

public class DashboardSteps {

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) throws IOException {

        DashboardPageTest.checkIfPageTitleIs(title);

    }
}
