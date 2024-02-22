package bodt;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifytheTextPowerYourWebsitewithAIChatbotTest {
	
	
		@Test
		public void VerifyTextVisible() throws InterruptedException
		
		{
//			WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			System.out.println("Hello Bodt.io");
			//Launch ChromeBrowser
			 WebDriver driver= new ChromeDriver(options);
			//Maximize Browser
//			driver.manage().window().maximize();
			//Wait until the URl is load and Element to be loaded. 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//Launch URL on Google.
			driver.get("https:bodt.io");
			WebElement text = driver.findElement(By.xpath("//span[text()='AI-Chatbot']/parent::h1"));
			System.out.println(text.getText());
			
			if(text.getAccessibleName().contains("Power Your Website"))
			{
				System.out.println("Verified: The text is True.");
			}
			else
				System.out.println("Not Verified: The text is False.");
			
			Thread.sleep(2000);
			driver.quit();
		
	}
}
