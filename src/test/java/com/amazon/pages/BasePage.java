package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement girisYapinButtonLoc;

    @FindBy(linkText = "Çıkış Yap")
    public WebElement cikisYapButtonLoc;

    @FindBy(id = "searchDropdownBox")
    public WebElement kategorilerLoc;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBoxLoc;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement productTypeTextLoc;

    @FindBy(xpath = "//span[@class='s-pagination-item s-pagination-selected']")
    public WebElement pageNumberLoc;

    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    public WebElement girisYapTextLoc;

}
