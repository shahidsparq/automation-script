package trackorder;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ButtonValidationTest {
    @Test
    public void urlLoad() throws InterruptedException {
//        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.trackorder.app/");

        String Url = driver.getCurrentUrl();

        if (Url.contains("trackorder")) {
            System.out.println("The url is correct: Pass");
        } else {
            System.out.println("The url is not Fetch: Fail");
        }

        WebElement feature = driver.findElement(By.xpath("//h2[text()=' Features ']"));

        JavascriptExecutor js=(JavascriptExecutor)driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(false)", feature);




    }

}
	


