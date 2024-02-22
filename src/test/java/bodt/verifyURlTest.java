package bodt;


import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class verifyURlTest {

    @Test
    public void ValidateTheUR() throws InterruptedException {

//        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        //Launch Browser
        WebDriver driver = new ChromeDriver(options);

        //Maximize the Browser on window.
//        driver.manage().window().maximize();
        //wait until element find.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //launch  URL on Browser.
        driver.get("https://bodt.io");

        System.out.println(driver.getTitle() + " This is Title of Page."); //get Title
        String url = driver.getCurrentUrl(); //getURL
        System.out.println(url + " This is URL of the Page.");

        System.out.println(url);

        if (url.contains("bodt.io") || url.contains("Bodt.io")) //condition follow statement.
        {
            System.out.println("Verify: The Url is Passed and Launch Url on Browser");
        } else
            System.out.println("Not Verify: The Url is not Passed");


        Thread.sleep(2000); // wait for 2 second.
        driver.quit(); // close browser with server.
    }
}
