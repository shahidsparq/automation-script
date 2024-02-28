package sparq;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class viewdemoTest {

    @Test
    public void viewDemoLink()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        ChromeDriver driver= new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://sparq.ai");
        driver.findElement(By.xpath("//a[text()=' View Demo ']")).click();

        String titlePage = driver.getTitle();
        System.out.println("The page Title is : "+titlePage);

        if(titlePage.contains("Sparq"))
        {
            System.out.println("The current page is Sparq page.");
        }
        else
        {
            System.out.println("The page is not from Sparq page.");
        }
        System.out.println("Pass View Demo button");
    }

}
