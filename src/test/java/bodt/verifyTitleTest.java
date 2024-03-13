package bodt;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class verifyTitleTest {

    @Test
    public void validateTitle() throws InterruptedException {
//        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https:bodt.io");

        String title = driver.getTitle();

        System.out.println(title);

        if (title.contains("Bodt") || title.contains("bodt")) {
            System.out.println("Verify: The Title is Find");
        } else
            System.out.println("Not Verify: The Title is not Find");

        Thread.sleep(5000);
        driver.quit();

    }

}
