package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

public class WebOrdersSteps {
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();

    WebDriver driver = Driver.getDriver();

    @Given("user navigates to the weborders application")
    public void user_navigates_to_the_weborders_application() {
        // Write the code here that will be doing this step
        driver.get(ConfigReader.getProperty("WebOrdersURL"));

    }

    @When("user provides username {string} and password {string} and click login")
    public void user_provides_username_and_password(String username, String password) {

        // Write the code here that will be doing this step

        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();
    }

    @Then("user validates application is logged in")

    // Write the code here that will be doing this step
    public void user_validates_application_is_logged_in() {
        String actualTitle = driver.getTitle();
        String expected = "Web Orders";
        Assert.assertEquals(expected, actualTitle);

    }


    @Then("user validates error message {string}")
    public void user_validates_error_message(String errorMessage) {
        String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage, actualErrorMessage);

    }


    @When("user provides username {string} and password {string} and clicks on login")
    public void userProvidesUsernameAndPasswordAndClicksOnLogin(String username, String password) {
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginButton.click();

    }


    @And("user clicks on Order module")
    public void userClicksOnOrderModule() {
        webOrdersHomePage.ordersModule.click();


    }

    @And("user selects {string} product with {int} quantity")
    public void userSelectsProductWithQuantity(String product, int quantity) throws InterruptedException {
        // product = "MyMoney"
        // quantity = "1
        BrowserUtils.selectDropdownByValue(webOrdersOrderPage.productDropDown, product);
        webOrdersOrderPage.quantityBox.sendKeys(Keys.BACK_SPACE);
        // webOrdersOrderPage.quantityBox.sendKeys(Keys.CONTROL+"a");
        webOrdersOrderPage.quantityBox.sendKeys(quantity + "" + Keys.ENTER);
        Thread.sleep(3000);


    }

    @Then("user validates total is calculated correctly for quantity {int}")
    public void userValidatesTotalIsCalculatedCorrectlyForQuantity(int quantity) {
        String pricePerUnit = webOrdersOrderPage.pricePerUnit.getAttribute("value");
        System.out.println("Price per unit is " + pricePerUnit);

        String discountAmount = webOrdersOrderPage.discountBox.getAttribute("value");

        int discountAmountInt = Integer.parseInt(discountAmount);
        int expectedTotal = 0;
        if (discountAmountInt == 0) {
            expectedTotal = quantity * Integer.parseInt(pricePerUnit);

        } else {
            expectedTotal = quantity * Integer.parseInt(pricePerUnit);
            //1000-->8--->1000-1000*8/100
            expectedTotal = expectedTotal - expectedTotal * discountAmountInt / 100;
        }


        String actualTotalStr = webOrdersOrderPage.total.getAttribute("value");
        int actualTotal = Integer.parseInt(actualTotalStr);
        Assert.assertEquals(expectedTotal, actualTotal);

    }






    @When("user creates order with data")
    public void user_creates_order_with_data(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }


    @Then("user validates succsess message {string}")
    public void userValidatesSuccsessMessage(String arg0) {
    }


    @And("user validates order added to List Of Orders")
    public void userValidatesOrderAddedToListOfOrders() {

    }

}