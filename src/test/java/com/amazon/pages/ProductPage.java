package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])")
    public List<WebElement> allProductsLocs;

    @FindBy(id ="productTitle")
    public WebElement selectedProductLoc;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement listeyeEkleLoc;

    @FindBy(xpath = "//button[@data-action='a-popover-close']")
    public WebElement closeListTabLoc;

    @FindBy(xpath="//*[contains(text(),'Favorilerim')]/parent::a")
    public WebElement favorilerimLoc;

    public void goToPage(String pageNumber){
        String newUrl = Driver.get().getCurrentUrl().concat("&page="+pageNumber);
        Driver.get().get(newUrl);
        BrowserUtils.waitForPageToLoad(20);
    }

    public String chooseProduct(String product){
        int intOrderProduct = Integer.parseInt(product);
        String selectProductFeaturesText = allProductsLocs.get(intOrderProduct-1).getText();
        allProductsLocs.get(intOrderProduct-1).click();
        return selectProductFeaturesText;
    }

}
