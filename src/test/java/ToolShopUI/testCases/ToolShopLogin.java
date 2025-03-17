package ToolShopUI.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolShopLogin {

    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().deleteAllCookies();

    }

    @BeforeMethod
    public void navigateToHomePage()
    {
        driver.navigate().to("https://practicesoftwaretesting.com/auth/login");
    }

    @Test
    public void verifyLogInByUsernamePassword()
    {
        WebElement usernameTextBox = driver.findElement(By.xpath(""));
    }
}
