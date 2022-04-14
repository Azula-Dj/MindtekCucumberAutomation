package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppSearchPage;
import pages.EtsyHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class  EtsyAppSteps {
    WebDriver driver= Driver.getDriver();

    EtsyHomePage etsyHomePage=new EtsyHomePage();
    EtsyAppSearchPage etsyAppSearchPage=new EtsyAppSearchPage();





    @Given("user navigates to the Etsy application")
    public void user_navigates_to_the_Etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyHomePage.searchBox.sendKeys(item+ Keys.ENTER);
    }

    @When("user applies price filter over {int}")
    public void user_applies_price_filter_over(Integer price) {
        etsyAppSearchPage.allFiltersButton.click();
        etsyAppSearchPage.priceButton.click();
        etsyAppSearchPage.lowPriceRadioButton.sendKeys(price+"");
        etsyAppSearchPage.applyButton.click();


    }

    @Then("user verifies that item prices are over {int}")
    public void user_verifies_that_item_prices_are_over(Integer price) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> prices=etsyAppSearchPage.prices;
        for(WebElement element:prices){
            String priceStr=element.getText().replace(",","");
            //"32402.00" --> 32402.00"
           // System.out.println(element.getText());
            // "32402.00"--> 32402.00
            double doublePrice=Double.parseDouble(priceStr);
            System.out.println(doublePrice);
            Assert.assertTrue(doublePrice>=price);
        }



    }

    @Then("user validates search results items contains keyword {string}")
    public void user_validates_search_results_items_contains_keyword(String item) {
        List<WebElement>itemName=etsyAppSearchPage.itemNames;

        for (WebElement element:itemName){
           // System.out.println(element.getText());
            Assert.assertTrue("Item doesn't contain carpet keyword: "+element.getText(),element.getText().toLowerCase().contains(item)
            || element.getText().toLowerCase().contains("rug"));

        }

    }


    @Then("user validates title is {string}")
    public void userValidatesTitleIs(String expectedTitle) {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user clicks on {string} section")
    public void userClicksOnSection(String section) {
        if (section.equalsIgnoreCase("Mother's Day Gifts")) {
            etsyHomePage.mothersDayGift.click();
        } else if (section.equalsIgnoreCase("Jewelry and Accessories")) {
            etsyHomePage.jewelryAndAccessories.click();
        } else if (section.equalsIgnoreCase("Clothing and Shoes")) {
            etsyHomePage.clothingAndShoes.click();
        } else if (section.equalsIgnoreCase("Home and Living")) {
            etsyHomePage.homeAndLiving.click();
        } else if (section.equalsIgnoreCase("Wedding and Party")) {
            etsyHomePage.weddingAndParty.click();
        } else if (section.equalsIgnoreCase("Toys and Entertainment")) {
            etsyHomePage.toysAndEntertainment.click();
        } else if (section.equalsIgnoreCase("Art and Collectibles")) {
            etsyHomePage.artAndCollectibles.click();
        } else if (section.equalsIgnoreCase("Craft Supplies and Tools")) {
            etsyHomePage.craftAndSupplies.click();
        } else if (section.equalsIgnoreCase("Gifts and Gift Cards")) {
            etsyHomePage.giftsAndGiftCards.click();
        }


    }
}
