package bodt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;


public class verifyBookAcallLinkTest {
	@Test
	public void verifiyBookAcallLink() throws InterruptedException
	{
//		WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();
//		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

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
//		driver.manage().window().maximize();
		//Wait until the URl is load and Element to be loaded. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Launch URL on Google.
		driver.get("https:bodt.io");
		
		WebElement bookACallbutton = driver.findElement(By.xpath("//a[text()='Book a Call']"));
		String textButton = bookACallbutton.getText();
		
		if(textButton.contains("Book"))
		{
			bookACallbutton.click();
			System.out.println("Verified: Button clicked.");
		}
		else
			System.out.println("Not verified. Button not clicked");
		Thread.sleep(2000);
		String titleOfPage = driver.getTitle();
		System.out.println(titleOfPage);
		if(titleOfPage.contains("Contact"))
		{
			System.out.println("verified: Contact us page");
		}
		else
		{
			System.out.println("Not verified: contact us page");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
