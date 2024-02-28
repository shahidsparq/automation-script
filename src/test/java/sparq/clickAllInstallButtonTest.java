package sparq;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Test;


public class clickAllInstallButtonTest {

    WebDriver driver;

    @Test
    public void allInsatllButton() throws InterruptedException {
////        WebDriverManager.chromedriver().browserVersion("121.0.6167.160").setup();
//
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.sparq.ai/");

        List<WebElement> allInstallButton = driver.findElements(By.xpath("//a[contains(text(), 'Install')]"));

        Actions action = new Actions(driver);

        for (WebElement clickOneONone : allInstallButton) {
            Thread.sleep(2000);

            action.keyDown(Keys.CONTROL).moveToElement(clickOneONone).click(clickOneONone).perform();
            action.keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);
        }

        ArrayList<String> closeWindow = new ArrayList<String>(driver.getWindowHandles());
        for (int i = 1; i<closeWindow.size(); i++) {
            driver.switchTo().window(closeWindow.get(i));
            System.out.println("The Title of Header Links: " + driver.getTitle());

            driver.close();
            driver.switchTo().window(closeWindow.get(0));
        }

        System.out.println("Script completed");
        driver.quit();

    }

}
