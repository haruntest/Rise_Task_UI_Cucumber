package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListPage extends BasePage{

    @FindBy(xpath="//a[starts-with(@id,'itemName_')]")
    public List<WebElement> favoritedProductLoc;

   @FindBy(xpath="//a[contains(text(),'Alışveriş Sepeti')]")
    public WebElement alısVerisSepetiniGoruntuleButtonLoc;

    @FindBy(name = "submit.deleteItem")
    public WebElement deleteLoc;

    @FindBy(xpath = "//div[@class='a-row a-spacing-none']")
    public List<WebElement> SilindiLoc;

}
