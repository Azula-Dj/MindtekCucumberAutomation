package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchPage {
    public EtsyAppSearchPage(){

        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement allFiltersButton;

    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement priceButton;

    @FindBy(id = "search-filter-min-price-input")
    public WebElement lowPriceRadioButton;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    public WebElement applyButton;

     @FindBy(xpath = "//p[@class='wt-text-title-01']//span[@class='currency-value']")
     public List<WebElement>prices;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//div//h3")
    public List<WebElement> itemNames;






}
