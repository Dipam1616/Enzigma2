package forgotPasswordValidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NonRegisteredEmail {

	public static void main(String[] args) throws InterruptedException {

		// Open the browser
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		// Navigate to the URL
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

		// Click on Forgot Password text
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();

		// Enter email into the text field
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("dipamkawale11@gmail.com");

		// Click on Proceed button
		driver.findElement(By.xpath("//div[text()='Proceed']")).click();
		
		String error = "User does not exists";
		
		Thread.sleep(2000);
		
		WebElement message = driver.findElement(By.xpath("//h2[text()='User does not exists']"));
		String text = message.getText();
		
		if (text.contains(error)) {
			System.out.println(error);
			
		}
		

	}

}
