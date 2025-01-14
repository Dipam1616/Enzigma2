package signupPageValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MissingOrBlankMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		// Open the browser
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Click on Sign up
		WebElement sign_up = driver.findElement(By.xpath("//a[text()='Sign up']"));
		sign_up.click();

		// Write email in Email text field
		WebElement email = driver.findElement(By.xpath("(//input[@name='username'])[2]"));
		email.sendKeys("");

		// Select check box
		WebElement checkbox = driver.findElement(By.xpath("//span[@class='slds-checkbox_faux']"));
		checkbox.click();

		Thread.sleep(2000);
		// Click on Proceed button
		WebElement proceed = driver.findElement(By.xpath("//div[text()='Proceed']"));
		proceed.click();
		
		String error = "Please enter email";
		
		WebElement message = driver.findElement(By.xpath("//h2[text()='Please enter email']"));
		String txt = message.getText();
		
		if (txt.contains(error)) {
			System.out.println("Please enter email");
			
		}

	}
}
