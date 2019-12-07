import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    public WebDriver driver = null;

    @Test
    public void beforeTest()
    {
        System.out.println("Initialing the browser for you....Please wait...");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @AfterTest
    public void afterTest() throws InterruptedException
    {
        Thread.sleep(3000);
        System.out.println("Closing the browser....");
        driver.quit();
    }

}
