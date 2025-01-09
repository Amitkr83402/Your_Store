package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	 private static String testEmail;
	 static String testPassword;
	static WebDriver driver=null;
	public static void  initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome"))
		{
			driver = new ChromeDriver();
	}
		else if(browserName.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}else if(browserName.equals("edge"))
	{
		driver =new EdgeDriver();
	}else if(browserName.equals("safari"))
	{
		driver=new SafariDriver();
	}
	}
    public static WebDriver getDriver() {
    	return driver;
    }
    public static String getTestEmail() {
        return testEmail;
    }

    // Setter for test email
    public static void setTestEmail(String email) {
        testEmail = email;
    }
    public static String getTestPassword() {
        return testPassword;
    }

    // Set the test password
    public static void setTestPassword(String password) {
        testPassword = password;
    }
}

