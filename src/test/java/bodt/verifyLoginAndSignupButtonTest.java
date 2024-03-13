package bodt;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class verifyLoginAndSignupButtonTest {
	@Test
	public void buttonLogin() throws InterruptedException
	{
//		WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");

		System.out.println("Hello Bodt.io");
		//Launch CHROME Browser
		 WebDriver driver= new ChromeDriver(options);
		//Maximize Browser
//		driver.manage().window().maximize();
		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		//String homePage = driver.getWindowHandle(); // address Unique Id.
		
		WebElement logInButton = driver.findElement(By.xpath("//a[text()='Log in']"));
	
		if(logInButton.isDisplayed() || logInButton.isEnabled())
				{
			
			logInButton.click();
			System.out.println(driver.getTitle());
			System.out.println("Verified: The Button clicked on Log in.");
				}
		else 
			System.out.println("Not Verified: The Button not Clicked on Log in.");
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		WebElement signUpButton = driver.findElement(By.xpath("//a[text()='Sign up']"));
		
		if(signUpButton.isDisplayed() || signUpButton.isEnabled())
		{
			signUpButton.click();
			System.out.println(driver.getTitle());
			System.out.println("Verified: The Button Clicked on Sign Up.");
			
		}
		else
			System.out.println("Not Verified: The Button not Clicked on Sign Up");
			driver.navigate().back();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.quit();
			
	}

}
