package sparq;

import java.time.Duration;
import java.util.ArrayList;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class clickInstallButtonTest {
    WebDriver driver;

    @Test
    public void intallButton() throws InterruptedException {
//        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.sparq.ai/");


        WebElement installButton = driver.findElement(By.xpath("//a[text()='Install app']"));

        if (installButton.isDisplayed()) {
            installButton.click();
            System.out.println("Install App button clicked");
        } else
            System.out.println("Button not clicked");

        Thread.sleep(2000);


        ArrayList<String> ids = new ArrayList<String>(driver.getWindowHandles());

        for (int i = 1; i < ids.size(); ) {
            driver.switchTo().window(ids.get(0));
            driver.close();
            break;
        }

        driver.switchTo().window(ids.get(1)); // Must have to see this statement for current window to show for the active tab.

        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        driver.quit();


    }

}