package bodt;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class verifyConnectYourWebsiteButtonTest {
	@Test
	public void verifyLinkConnectYourWebsiteButton() throws InterruptedException
	{
//		WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
	
		System.out.println("Hello Bodt.io");
		//Launch Chrome Browser
		 WebDriver driver= new ChromeDriver(options);
//		 Dimension screenSize = new Dimension(1366, 768); // You can adjust the width and height accordingly
//	        driver.manage().window().setSize(screenSize);
		//Maximize Browser

		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		
		WebElement connectWebsite = driver.findElement(By.xpath("//a[text()=' Connect Your Website ']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", connectWebsite);

		if(connectWebsite.isDisplayed() || connectWebsite.isEnabled() || connectWebsite.isSelected())
		{
			connectWebsite.click();
			System.out.println("Verified: The Link clicked.");
		}
		else
		{
			System.out.println("Not Verified: The Link not clicked.");
		}
		Thread.sleep(2000);
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if(pageTitle.contains("Sign"))
		{
			System.out.println("Verified: sign up page open when click on Link");
		}
		else
			System.out.println("Not Verified: sign up page not open when click on Link");
		Thread.sleep(2000);
		driver.quit();
	}

}
