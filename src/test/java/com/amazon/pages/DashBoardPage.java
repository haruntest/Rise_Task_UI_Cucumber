package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage{

    @FindBy(id = "sp-cc-accept")
    public WebElement cerezleriKabulEtButtonLoc;

    public void acceptCookies(){
        if(cerezleriKabulEtButtonLoc.isDisplayed()){
            cerezleriKabulEtButtonLoc.click();
        }
    }

}
