package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardPage extends BasePage{

    @FindBy(xpath ="//h1" )
    public WebElement alisverisSepetiTextLoc;

    @FindBy(xpath ="(//span[@class='a-declarative'])[1]" )
    public WebElement silButtonLoc;

}
