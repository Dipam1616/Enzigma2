package LoginPageValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlankFields {

	public static void main(String[] args) throws InterruptedException {

		// Open the browser
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Enter email in Email text field
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("");

		// Enter password into the Password text field
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("");

		// Click on Login button
		WebElement login = driver.findElement(By.xpath("//div[text()='Log In']"));
		login.click();

		Thread.sleep(2000);

		String error = "Please enter email";

		WebElement message = driver.findElement(By.xpath("//h2[text()='Please enter email']"));
		String txt = message.getText();

		if (txt.contains(error)) {
			System.out.println(error);

		}

	}

}
