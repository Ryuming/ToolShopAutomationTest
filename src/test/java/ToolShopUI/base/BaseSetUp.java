package ToolShopUI.base;

import ToolShopUI.component.ConfigTextFile;
import ToolShopUI.component.ConfigTextFileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Arrays;

public class BaseSetUp
{
    private WebDriver driver;

    private static String driverPath = "/src/test/resources";

    private static final String configBrowserFilePath = System.getProperty("user.dir") + "/configBrowser.config";
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

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath + "/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(siteUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        System.out.println("Launched Chrome Browser");
        return driver;
    }

    private static WebDriver initFirefoxDriver(String siteUrl) {
        System.out.println("Launching Firefox Browser");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + driverPath + "/geckodriver-v0.36.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(siteUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        System.out.println("Launched Firefox Browser");
        return driver;
    }

    private static void generalSetUp(String siteUrl, WebDriver driver)
    {
        driver.manage().window().maximize();
        driver.navigate().to(siteUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


    @BeforeClass
    public void initializeTestBaseSetUp() {
        try {
            ConfigTextFileHandler configFile = new ConfigTextFileHandler();
            ConfigTextFile configData = new ConfigTextFile(configFile.openConfigFile(configBrowserFilePath));
            setDriver(configData.getBrowserType(), configData.getSiteUrl());
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

    @BeforeMethod
    public void warmUpBeforeTest() throws Exception {
        Thread.sleep(2000);
    }

    @AfterMethod
    public void cooldownAfterTest() throws Exception {
        Thread.sleep(2000);
    }

}
