package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.reflect.Type;
import java.util.Map;

public class PizzaAppSteps {

    WebDriver driver= Driver.getDriver();
    Map<String,Object> data;

    @Given("user navigates to pizza application")
    public void user_navigates_to_pizza_application() {
        driver.get(ConfigReader.getProperty("PizzaAppURL"));

    }

    @When("user creates pizza orders with data")
    public void user_creates_pizza_orders_with_data(DataTable dataTable) {

        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V>

        data=dataTable.asMap(String.class,Object.class);
        for (Object object:data.values()){
            System.out.println(object);
        }

    }

    @Then("user validates then order is created with success message {string} {string}")
    public void user_validates_then_order_is_created_with_success_message(String string, String string2) {

    }

}
