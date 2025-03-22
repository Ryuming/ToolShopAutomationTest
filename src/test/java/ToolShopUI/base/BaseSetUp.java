package ToolShopUI.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Arrays;

public class BaseSetUp
{
    private WebDriver driver;

    private static final String driverPath = System.getProperty("user.dir") + "src/test/resources";

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String siteUrl){
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(siteUrl);
                break;
            case "firefox":
                driver = initFirefoxDriver(siteUrl);
                break;
            default:
                System.out.println(browserType + " is invalid browser, Opening Default Chrome Driver...");
                driver = initChromeDriver(siteUrl);
        };
    }

    private static WebDriver initChromeDriver(String siteUrl) {
        System.out.println("Launching Chrome Browser");

        System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        generalSetUp(siteUrl, driver);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String siteUrl) {
        System.out.println("Launching Firefox Browser");
        System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver-v0.36.0-win-aarch64/geckodriver.exe");
        return new FirefoxDriver();
    }

    private static void generalSetUp(String siteUrl, WebDriver driver)
    {
        driver.manage().window().maximize();
        driver.navigate().to(siteUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Parameters({"browserType", "siteUrl"})
    @BeforeClass
    public void initializeTestBaseSetUp(String browserType, String siteUrl) {
        try {
            setDriver(browserType, siteUrl);
            System.out.println("Test Base Setup completed successfully");
        }
        catch (Exception e) {
            System.out.println("Test Base Setup failed due to: " + Arrays.toString(e.getStackTrace()));
        }
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Test Base Teardown completed successfully");
        driver.quit();
    }

}
