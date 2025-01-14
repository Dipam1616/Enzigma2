package LoginPageValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncorrectUsernameOrPassword {
	public static void main(String[] args) throws InterruptedException {

		// Open the browser
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Enter email in Email text field
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("fearyour@gmail.com");

		// Enter password into the Password text field
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Dipam@123");

		// Click on Login button
		WebElement login = driver.findElement(By.xpath("//div[text()='Log In']"));
		login.click();

		Thread.sleep(2000);

		String error = "Invalid Email or Password";
		Thread.sleep(2000);
		WebElement message = driver.findElement(By.xpath("//h2[text()='Invalid Email or Password']"));
		String txt = message.getText();

		if (txt.contains(error)) {
			System.out.println(error);

		}

	}

}
