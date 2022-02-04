package com.amazon.step_definitions;

import com.amazon.pages.CardPage;
import com.amazon.pages.DashBoardPage;
import com.amazon.pages.ListPage;
import com.amazon.pages.ProductPage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.amazon.utilities.BrowserUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardStepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();
    ProductPage productPage = new ProductPage();
    ListPage listPage = new ListPage();
    CardPage cardPage=new CardPage();
    String expectedProductFeaturesText;

    @When("The user selects {string} from the Tum kategoriler")
    public void the_user_selects_from_the_Tum_kategoriler(String product) {
        Select select= new Select(dashBoardPage.kategorilerLoc);
        select.selectByVisibleText(product);
    }

    @Then("Verify the user can see the {string} on categories")
    public void verify_the_user_can_see_the_on_categories(String product) {
        Select select= new Select(dashBoardPage.kategorilerLoc);
        assertEquals("Verify first selection ",product,select.getFirstSelectedOption().getText());
    }

    @When("The user enters {string} in search box")
    public void the_user_enters_in_search_box(String productType) {
        dashBoardPage.searchBoxLoc.sendKeys(productType);
    }

    @When("The user clicks search button")
    public void the_user_clicks_search_button() {
        dashBoardPage.searchBoxLoc.sendKeys(Keys.ENTER);
        waitForPageToLoad(10);
    }

    @Then("Verify the user can search {string}")
    public void verify_the_user_can_search(String productType) {
        assertTrue("Verify productType ",dashBoardPage.productTypeTextLoc.getText().contains(productType));
    }

    @When("The user clicks page {string} button")
    public void the_user_clicks_page_button(String pageNumber) {
        productPage.goToPage(pageNumber);
    }

    @Then("Verify the user can see page {string}")
    public void verify_the_user_can_see_page(String pageNumber) {
        waitForPageToLoad(10);
        assertEquals("Verify pageNumber",pageNumber,dashBoardPage.pageNumberLoc.getText());
    }

    @When("The user clicks product {string}")
    public void the_user_clicks_product(String orderProduct) {
        expectedProductFeaturesText=productPage.chooseProduct(orderProduct);
    }

    @Then("Verify the user is on selected product page")
    public void verify_the_user_is_on_selected_product_page()  {
      waitFor(2);
        getScreenshot("Selected_Product");
        assertEquals(expectedProductFeaturesText,productPage.selectedProductLoc.getText());
    }

    @Then("The user should be able to add selected product in Favorilerim list")
    public void the_user_should_be_able_to_add_selected_product_in_Favorilerim_list() {

        waitForVisibility(productPage.listeyeEkleLoc,5);
        productPage.listeyeEkleLoc.click();
    }

    @Then("The user should be able to close the list page")
    public void the_user_should_be_able_to_close_the_list_page() {
        waitFor(4);
        productPage.closeListTabLoc.click();
        waitForPageToLoad(10);
    }

    @When("The user navigates to Hesabim and Favorilerim list")
    public void the_user_navigates_to_Hesabim_and_Favorilerim_list() {
        hover(dashBoardPage.girisYapinButtonLoc);
        waitFor(3);
        productPage.favorilerimLoc.click();
    }

    @Then("Verify the user can see selected product in Favorilerim list")
    public void verify_the_user_can_see_selected_product_in_Favorilerim_list() {
        waitForPageToLoad(10);
        assertEquals(expectedProductFeaturesText,listPage.favoritedProductLoc.get(0).getText());
        getScreenshot("Favorilerim");
    }

    @When("The user click on {string} button")
    public void the_user_click_on_button(String sepeteEkle) {
       getTextWebelement(sepeteEkle).click();
       waitFor(1);
       assertTrue(getTextWebelement(sepeteEkle).getText().equals("Sepete Eklendi"));
    }

    @When("The user clicks Alisveris Sepetini Goruntule button")
    public void the_user_clicks_Alisveris_Sepetini_Goruntule_button() {
        waitFor(2);
        listPage.alısVerisSepetiniGoruntuleButtonLoc.click();
        waitForPageToLoad(10);
        assertTrue(cardPage.alisverisSepetiTextLoc.getText().equals("Alışveriş Sepeti"));
        getScreenshot("Alışveriş_Sepeti");
    }

    @Then("The user can delete selected product in Alisveris Sepeti")
    public void theUserCanDeleteSelectedProductInAlisverisSepeti() {

        cardPage.silButtonLoc.click();
    }

    @When("The user deletes selected product in Favorilerim list")
    public void the_user_deletes_selected_product_in_Favorilerim_list() {
        waitFor(2);
        listPage.deleteLoc.click();
        waitForPageToLoad(10);
    }

    @Then("Verify the user can delete selected product in Favorilerim list")
    public void verify_the_user_can_delete_selected_product_in_Favorilerim_list() {
        assertTrue(expectedProductFeaturesText.equals(listPage.SilindiLoc.get(0).getText()));
        assertTrue(listPage.SilindiLoc.get(1).isDisplayed());
    }

    @When("The user logs out")
    public void the_user_logs_out() {
        hover(dashBoardPage.girisYapinButtonLoc);
        dashBoardPage.cikisYapButtonLoc.click();
        waitForPageToLoad(10);
    }

    @Then("Verify the user can be logged out")
    public void verify_the_user_can_be_logged_out() {
        assertTrue(dashBoardPage.girisYapTextLoc.isDisplayed());
    }

}
