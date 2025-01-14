package forgotPasswordValidation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordValidation {

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
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("fearyour44@gmail.com");

		// Click on Proceed button
		driver.findElement(By.xpath("//div[text()='Proceed']")).click();

		String otp = "Verification code sent successfully";

		Thread.sleep(3000);

		WebElement message = driver.findElement(By.xpath("//h2[text()='Verification code sent successfully']"));
		message.getText();

		if (otp.contains(otp)) {
			System.out.println(otp);

		}

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"));
		System.out.println("Enter the OTP manually on the web page");

		// Pause the script for manual OTP entry
		System.out.println("After entered the OTP, press Enter here to continue...");
		Scanner scanner = new Scanner(System.in); // Wait for user input
		scanner.nextLine(); // Script will pause until Enter is pressed

		// Click on Verify Code button
		WebElement verifyCode = driver.findElement(By.xpath("//div[text()='Verify Code']"));
		verifyCode.click();
		
		String error = "Invalid or Expired code";
	

	}

}
