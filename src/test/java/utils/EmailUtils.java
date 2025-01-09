package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailUtils {
	 public static String generateRandomEmail() {
	        // Generate a random string (specify the length)
	        String generatedString = RandomStringUtils.randomAlphabetic(15); // Example: length 10
	        String email = generatedString + "@gmail.com";
	        System.out.println(email);
			return generatedString + "@gmail.com"; 
	    }
}
