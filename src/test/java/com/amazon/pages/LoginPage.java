package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="ap_email")
    public WebElement emailOrPhoneBoxLoc;

    @FindBy(id = "continue")
    public WebElement devamEtButtonLoc;

    @FindBy(id="ap_password")
    public WebElement passwordBoxLoc;

    @FindBy(id = "signInSubmit")
    public WebElement girisYapButtonLoc;

    @FindBy(id = "auth-error-message-box")
    public WebElement birSorunOlustuAlertMessageLoc;

    @FindBy(xpath = "(//*[@class='a-alert-content'])[2]")
    public WebElement sifreniziGirinAlertMessageLoc;

    @FindBy(xpath= "//h4[@class='a-alert-heading']")
    public WebElement onemliAlertMessageLoc;



    public void InvalidEmailAndPhoneCheck(List<String> invalidEmails){

        for (String invalidEmail : invalidEmails) {
           if(invalidEmail==null) {
            devamEtButtonLoc.click();
            BrowserUtils.waitForVisibility(sifreniziGirinAlertMessageLoc,2);
            Assert.assertTrue(sifreniziGirinAlertMessageLoc.isDisplayed());
             }
             else {
                 emailOrPhoneBoxLoc.sendKeys(invalidEmail);
                 devamEtButtonLoc.click();
                 BrowserUtils.waitForVisibility(birSorunOlustuAlertMessageLoc,2);
                 Assert.assertTrue(birSorunOlustuAlertMessageLoc.isDisplayed());
                 emailOrPhoneBoxLoc.clear();
             }
        }
    }


    public void InvalidPasswordCheck(List<String> invalidPasswords) {

        for (String invalidPassword : invalidPasswords) {

                  if (invalidPassword == null) {
                      girisYapButtonLoc.click();
                      BrowserUtils.waitForVisibility(sifreniziGirinAlertMessageLoc, 2);
                      Assert.assertTrue(sifreniziGirinAlertMessageLoc.isDisplayed());
                     }
                  else{
                     passwordBoxLoc.sendKeys(invalidPassword);
                     girisYapButtonLoc.click();
                     BrowserUtils.waitFor(2);
                         if(onemliAlertMessageLoc.isDisplayed()){ Assert.assertTrue(true); break;}
                     BrowserUtils.waitForVisibility(birSorunOlustuAlertMessageLoc, 2);
                     Assert.assertTrue(birSorunOlustuAlertMessageLoc.isDisplayed());
                     passwordBoxLoc.clear();

                  }

        }

    }

}


