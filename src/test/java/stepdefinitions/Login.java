package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {

	WebDriver driver;
	   
	@Given("User navigates to Login page")
	public void user_navigates_to_login_page() {
	   driver=  factory.DriverFactory.getDriver();
	   driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   driver.findElement(By.linkText("Login")).click();
	   driver.manage().deleteAllCookies();
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailText)
	
	{
	    driver.findElement(By.id("input-email")).sendKeys(emailText);
	    
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	  driver.findElement(By.id("input-password")).sendKeys(passwordText);
	}

	@Then("User should get successfully Logged in")
	public void user_should_get_successfully_logged_in() {
	   Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@When("User enters invalid email address {string} into email field")
	public void user_enters_invalid_email_address_into_email_field(String invalidemailText) {
		driver.findElement(By.id("input-email")).sendKeys(invalidemailText);
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpasswordText) {
		driver.findElement(By.id("input-password")).sendKeys(invalidpasswordText);
	}

	@Then("User shoud get warning message about credentials mismatch")
	public void user_shoud_get_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User do not enters email address into email field")
	public void user_do_not_enters_email_address_into_email_field() {
	  driver.findElement(By.id("input-email")).sendKeys("");
	}

	@And("User do not enter password into password field")
	public void user_do_not_enter_password_into_password_field() {
	   driver.findElement(By.id("input-password")).sendKeys("");
	}

	@And("User click on Login button")
	public void users_click_on_login_button() {
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

}


