package com.amazon.step_definitions;

import com.amazon.pages.DashBoardPage;
import com.amazon.pages.LoginPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.amazon.utilities.BrowserUtils.getTextWebelement;
import static com.amazon.utilities.BrowserUtils.hover;
import static org.junit.Assert.*;

public class LoginStepDefs{

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Given("The user open the amazon page")
    public void the_user_open_the_amazon_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("Verify the user is on the home page")
    public void verify_the_user_is_on_the_home_page() {
        assertEquals(ConfigurationReader.get("url"),Driver.get().getCurrentUrl());
    }

    @Then("The user should be able to accept cookies")
    public void the_user_should_be_able_to_accept_cookies() {
        dashBoardPage.acceptCookies();

    }

    @When("The user click on Merhaba, giris yapin button")
    public void the_user_click_on_Merhaba_giris_yapin_button() {
        dashBoardPage.girisYapinButtonLoc.click();

    }

    @Then("Verify the user is on the login page")
    public void verify_the_user_is_on_the_login_page() {
        assertTrue("You are not in login page", getTextWebelement("E-posta adresi veya telefon numarası").isDisplayed());
    }

    @When("The user enters login email")
    public void the_user_enters_login_email() {
        loginPage.emailOrPhoneBoxLoc.sendKeys(ConfigurationReader.get("username"));
    }

    @When("The user clicks Devam et button")
    public void the_user_clicks_Devam_et_button() {
        loginPage.devamEtButtonLoc.click();
    }

    @Then("Verify the user is on the password window")
    public void verify_the_user_is_on_the_password_window() {
        assertTrue(getTextWebelement("Şifre").isDisplayed());
    }

    @When("The user enters password")
    public void the_user_enters_password() {
        loginPage.passwordBoxLoc.sendKeys(ConfigurationReader.get("password"));
    }

    @When("The user clicks Giris yap button")
    public void the_user_clicks_Giris_yap_button() {
        loginPage.girisYapButtonLoc.click();
    }

    @Then("Verify the user is logged in")
    public void verify_the_user_is_logged_in() {
        hover(getTextWebelement("Hesap ve Listeler"));
        assertTrue(dashBoardPage.cikisYapButtonLoc.isDisplayed());
    }

    @When("The user enters login invalid email")
    public void the_user_enters_login_invalid_email(List<String> invalidEmails) {
        loginPage.InvalidEmailAndPhoneCheck(invalidEmails);
    }

    @Then("Verify the user isn't on the password window")
    public void verify_the_user_isn_t_on_the_password_window() {
        assertFalse(getTextWebelement("Şifre").isDisplayed());
    }

    @When("The user enters invalid password")
    public void the_user_enters_invalid_password(List<String> invalidPasswords) {
        loginPage.InvalidPasswordCheck(invalidPasswords);
    }

    @Then("Verify the user isn't logged in")
    public void verify_the_user_isn_t_logged_in() {
        assertTrue(loginPage.passwordBoxLoc.isDisplayed());
    }

}
