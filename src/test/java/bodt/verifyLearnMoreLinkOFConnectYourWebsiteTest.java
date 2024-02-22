package bodt;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Test;

public class verifyLearnMoreLinkOFConnectYourWebsiteTest {

    @Test
    public void learnMoreLink() throws InterruptedException {
//        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        System.out.println("Hello Bodt.io");
        //Launch ChromeBrowser
        WebDriver driver = new ChromeDriver(options);
        //Maximize Browser
//		driver.manage().window().maximize();
        //Wait until the URl is load and Element to be loaded.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Launch URL on Google.
        driver.get("https:bodt.io");

        WebElement learnMoreLink = driver.findElement(By.xpath("//a[text()='Learn more ']"));
        Actions action = new Actions(driver);
        action.moveToElement(learnMoreLink).perform();

        if (learnMoreLink.getText().contains("Learn more")) {
            learnMoreLink.click();
            System.out.println("Clicked: Learn more Link");
        } else {
            System.out.println("Not Clicked Learn more Link");
        }

        driver.navigate().refresh();

        if (driver.getTitle().contains("Creating Account - Docs for Bodt")) {
            System.out.println("Verified Page : Creating Account page.");
        } else {
            System.out.println("Not Verified: Creating Account page.");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}

