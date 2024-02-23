package sparq;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;



public class viewDemoTest {

    @Test
   public  void viewDemoLink() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://sparq.ai");

        WebElement viewDemoButton = driver.findElement(By.xpath("//a[text()=' View Demo ']"));
        Actions actions= new Actions(driver);

        actions.moveToElement(viewDemoButton).click(viewDemoButton).perform();
        String title = driver.getTitle();
        System.out.println(title);
        if(title.contains("Sparq"))
        {
            System.out.println("This is shopify sparq page for demo");
        }
        else
            System.out.println("The page not found.");

        Thread.sleep(2000);

        driver.quit();
    }

}
