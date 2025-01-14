package signupPageValidation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidEmailFormat {

	public static void main(String[] args) throws InterruptedException {

		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// Navigate to the login page
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Click on the Sign up link
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign up']"));
		signUp.click();

		// Enter invalid email
		WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		email.sendKeys("fearyourgmail.com");

		// Select the checkbox
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));
		checkbox.click();
		Thread.sleep(2000);

		// Click on the Proceed button
		WebElement proceed = driver.findElement(By.xpath("//div[text()='Proceed']"));
		proceed.click();

		// Verify the error message
		WebElement error = driver.findElement(By.xpath("//h2[text()='Please enter a valid email']"));
		String emailError = error.getText();
		System.out.println(emailError);

		// Close the browser
		driver.quit();
	}
}
