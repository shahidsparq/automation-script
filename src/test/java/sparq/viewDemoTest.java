package sparq;

<<<<<<< HEAD

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
>>>>>>> 47207a6 (Shahid new code push lear)
import org.testng.annotations.Test;

import java.time.Duration;

<<<<<<< HEAD


public class viewDemoTest {

    @Test
   public  void viewDemoLink() throws InterruptedException {
=======
public class viewDemoTest {

    @Test
    public void viewDemoButton ()
    {
>>>>>>> 47207a6 (Shahid new code push lear)
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://sparq.ai");
<<<<<<< HEAD

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
            System.out.println("The page not found..");

        Thread.sleep(2000);

        driver.quit();
=======
        driver.findElement(By.xpath("//a[text()=' View Demo ']")).click();

        String titlepaage = driver.getTitle();
        System.out.println("Title of the Page is: "+titlepaage);

        if (titlepaage.contains("Sparq"))
        {
            System.out.println("View Demo Button Clicked and the current page from Sparq shopify.");
        }
        else
            System.out.println("View Demo Button not clicked and the page not found");
        driver.quit();

>>>>>>> 47207a6 (Shahid new code push lear)
    }

}
