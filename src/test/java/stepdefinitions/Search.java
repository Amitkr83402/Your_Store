package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

WebDriver driver;
	
	
	@Given("User opens application")
	public void user_opens_application() {
	    
		driver=factory.DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(validProductText);
	}

	@And("User clicks search button")
	public void user_clicks_search_button() {
	  driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@When("User dint enter any product name into Search box field")
	public void User_dint_enter_any_product_name_into_Search_box_field() {
		
	    //intentionally kept blank
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	    Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	}

@Then("User should get a valid product displayed in the search result")
public void user_should_get_a_valid_product_displayed_in_the_search_result() {
  Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
}

@When("User enters invalid product {string} into search box field")
public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
	driver.findElement(By.name("search")).sendKeys(invalidProductText);
}

}
