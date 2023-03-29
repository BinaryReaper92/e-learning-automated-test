package stepDefinitions2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.JSONReader;

public class ForgotPasswordModalSteps {

    private JSONReader reader = new JSONReader();

    //First Test
    @Given("Admin opens forgot password modal")
    public void admin_opens_forgot_password_modal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    //Enter email used in Login
    @And("Admin click on Send")
    public void admin_click_on_send() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Success Modal should appear")
    public void success_modal_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("Admin click outside of the modal")
    public void adminClickOutsideOfTheModal() {
    }

    @Then("Forgot password modal should not disappear")
    public void forgotPasswordModalShouldNotDisappear() {
    }

    @And("Admin click on X button")
    public void adminClickOnXButton() {
    }

    @Then("Forgot password modal should disappear")
    public void forgotPasswordModalShouldDisappear() {
    }

    @And("Admin click on Close button")
    public void adminClickOnCloseButton() {
    }
}
