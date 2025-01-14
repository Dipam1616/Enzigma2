package signupPageValidation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordsNotMatching {

	public static void main(String[] args) throws InterruptedException {

		// Open the browser
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Click on Sign up
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign up']"));
		signUp.click();

		// Write email in Email text field
		WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		email.sendKeys("dipamkawale11@gmail.com");

		// Select check box
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));
		checkbox.click();
		Thread.sleep(2000);

		// Click on Proceed button
		WebElement proceed = driver.findElement(By.xpath("//div[text()='Proceed']"));
		proceed.click();
		Thread.sleep(5000);

		// Check for messages
		boolean isUserExists = driver.findElements(By.xpath("//h2[text()='User already exists']")).size() > 0;
		boolean isCodeSent = driver.findElements(By.xpath("//h2[text()='Verification code sent successfully']"))
				.size() > 0;

		if (isUserExists) {
			System.out.println("User already exists.");
		} else if (isCodeSent) {
			System.out.println("Verification code sent successfully.");

			// Prompt to manually enter OTP
			driver.findElement(By.xpath("//input[@placeholder='Enter Code']"));
			System.out.println("Enter the OTP manually on the web page.");

			// Pause the script for manual OTP entry
			System.out.println("After entering the OTP, press Enter here to continue...");
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine(); // Wait for user input

			// Click on Verify Code button
			WebElement verifyCode = driver.findElement(By.xpath("//div[text()='Verify Code']"));
			verifyCode.click();

			Thread.sleep(5000);

			// Enter first name
			WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
			firstName.sendKeys("Dipam");

			// Enter last name
			WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
			lastName.sendKeys("Kawale");

			// Enter password
			WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[2]"));
			password.sendKeys("Dipam@123");

			// Enter confirm password
			WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='password-confirmpassword']"));
			confirmPassword.sendKeys("Dipam@12");
			
			// Check for error message
            String expectedError = "The password and confirmation password do not match";
            WebElement message = driver.findElement(By.xpath("//div[text()=' The password and confirmation password do not match ']"));

            if (message.isDisplayed()) {
                String actualError = message.getText().trim();
                if (actualError.equals(expectedError)) {
                    System.out.println(actualError);
                    System.out.println("Register button will not be clicked because the passwords do not match.");
                }
            } else {
                // Click on Register button only if no error message is displayed
                WebElement register = driver.findElement(By.xpath("//div[text()='Register']"));
                register.click();
            }

	}
}
}
