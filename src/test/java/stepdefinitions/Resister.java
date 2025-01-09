package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Resister {

	WebDriver driver;
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		/* String randomEmail = EmailUtils.generateRandomEmail(); // Call the utility method
	        dataMap.put("email", randomEmail);*/
		String email = dataMap.get("email");
		 String password = dataMap.get("password");
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		DriverFactory.setTestEmail(email);
		DriverFactory.setTestPassword(password);
	}

	@And("User enter privacy policy")
	public void user_enter_privacy_policy() {
	   driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}

	@And("User clicks on continew button")
	public void user_clicks_on_continew_button() {
	   driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}

	@Then("User account should get created sucessfully")
	public void user_account_should_get_created_sucessfully() {
		 boolean isDuplicateEmailWarning = driver.findElements(By.xpath("//div[contains(text(), 'Warning: E-Mail Address is already registered!')]")).size() > 0;

	        if (isDuplicateEmailWarning) {
	        	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	            driver.findElement(By.xpath("//a[text()='login page']")).click();
	            String email=DriverFactory.getTestEmail();
	            driver.findElement(By.id("input-email")).sendKeys(email);
	            String password = DriverFactory.getTestPassword();
	            driver.findElement(By.id("input-password")).sendKeys(password);
	            driver.findElement(By.linkText("Login")).click();
	        }
	        else {
	        	
	   Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']//h1")).getText());
	}
	}

	@And("User select yes for Newsletter")
	public void user_select_yes_for_newsletter() {
	   driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("User account should get proper warning about dublicate email")
	public void user_account_should_get_proper_warning_about_dublicate_email() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into field")
	public void user_dont_enter_any_details_into_field() {
	   //intentionally kept blank
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
	    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText().contains("First Name must be between 1 and 32 characters!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText().contains("Last Name must be between 1 and 32 characters!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText().contains("E-Mail Address does not appear to be valid!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText().contains("Telephone must be between 3 and 32 characters!"));
	    Assert.assertTrue(driver.findElement(By.xpath("//input[@name='password']/following-sibling::div")).getText().contains("Password must be between 4 and 20 characters!"));
	}
}
