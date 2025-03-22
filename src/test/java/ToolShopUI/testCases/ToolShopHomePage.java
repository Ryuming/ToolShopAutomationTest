package ToolShopUI.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ToolShopHomePage {
    // Define UI elements for the Tool Shop Home Page

    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "src/test/resources/chromedriver-win64/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.manage().deleteAllCookies();

    }

    @BeforeMethod
    public void navigateToHomePage()
    {
        driver.navigate().to("https://practicesoftwaretesting.com/");
    }

    @Test
    public void verifyToolShopTitle()
    {
        String HomePageTittle = driver.getTitle();
        Assert.assertEquals(HomePageTittle, "Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifyToolShopLogo()
    {
        WebElement toolShopLogo = driver.findElement(By.cssSelector("#Layer_1"));
        Assert.assertTrue(toolShopLogo.isDisplayed());
    }

    @Test
    public void verifyHomeButtonClickable()
    {
        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a"));
        homeButton.click();
        Assert.assertEquals(driver.getTitle(), "Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifyContactButtonClickable() throws InterruptedException {
        WebElement contactButton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));
        contactButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Contact Us - Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifySignInButtonClickable() throws InterruptedException {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a"));
        signInButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
    }

    private static String handleCategoryList(int i) throws InterruptedException {
        driver.navigate().to("https://practicesoftwaretesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);

        WebElement categorySelected = driver.findElement(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > ul > li:nth-child(" + (i + 1) + ")"));
        String categoryNameSelected = categorySelected.getText();
        categorySelected.click();
        Thread.sleep(3000);
        return categoryNameSelected;
    }

    @Test
    public void verifyCategoryButtonSelectable() throws InterruptedException {
        WebElement categoryButton = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a"));
        categoryButton.click();
        Thread.sleep(1000);
        List<WebElement> categoryList = driver.findElements(By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > ul > li"));
        int categoryListSize = categoryList.size() ;
        for (int i = 0; i < categoryListSize ; i++) {

            if (i < (categoryListSize -2))
            {
                String text = handleCategoryList(i);
                Assert.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > app-category > div:nth-child(1) > h2")).getText(),"Category: " + text);
            }
            else if ( i == (categoryListSize-1))
            {
                String text = handleCategoryList(i);
                Assert.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > app-overview > div > h1")).getText(), text);
            }
        }
    }

    private static String selectLanguageHandler(int i) throws InterruptedException {
        driver.navigate().to("https://practicesoftwaretesting.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement languageSelectButton = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        languageSelectButton.click();
        Thread.sleep(1000);

        WebElement selectedLanguage = driver.findElement(By.xpath("//*[@id=\"dropdown-animated\"]/li[" + (i+1) + "]/a"));
        String selectedLanguageString =  selectedLanguage.getText();
        selectedLanguage.click();


        return selectedLanguageString;

    }

    @Test
    public void verifyLanguageSelector() throws InterruptedException {
        WebElement languageSelectButton = driver.findElement(By.xpath("//*[@id=\"language\"]"));
        String curLanguage = driver.findElement(By.xpath("//*[@id=\"language\"]")).getText();

        languageSelectButton.click();
        Thread.sleep(1000);
        List<WebElement> languagesList  = driver.findElements(By.xpath("//*[@id=\"dropdown-animated\"]/li/a"));
        int languagesListSize = languagesList.size();


        for (int i = 0; i < languagesListSize ; i++) {

                String selectedLanguage = selectLanguageHandler(i);
                System.out.println("selectedLanguage: " + selectedLanguage);
                Assert.assertEquals(selectedLanguage, driver.findElement(By.xpath("//*[@id=\"language\"]")).getText());

        }

    }

    @Test
    public void verifySortBoxSelectable() throws InterruptedException
    {
        Select sortBox = new Select(driver.findElement(By.xpath("//*[@id=\"filters\"]/form[1]/div/select")));
        List<WebElement> options = sortBox.getOptions();
        for (int i = 0; i < options.size(); i++)
        {
            sortBox.selectByIndex(i);
            Thread.sleep(800);
            System.out.println("selected Option: " + options.get(i).getText());
        }
        //System.out.println("Number of Options: " + options.size());
    }

    @Test
    public void verifyPriceRangeSlider() throws InterruptedException
    {
        WebElement minSlider = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[5]"));
        WebElement maxSlider = driver.findElement(By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[6]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(minSlider, 195, 0).perform();
        Thread.sleep(3000);
        actions.dragAndDropBy(maxSlider,-80, 0).perform();
        Thread.sleep(3000);
    }

    @Test
    public void verifySearchBar() throws InterruptedException
    {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
        String searchString = "Hammer";
        searchBox.sendKeys(searchString);
        Thread.sleep(2000);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"filters\"]/form[2]/div/button[2]"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String searchResult = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/h3/span")).getText();
        System.out.println("Search result: " + searchResult);
        Assert.assertEquals(searchResult.toLowerCase(), searchString.toLowerCase());
    }


    @Test
    public  void verifyFilterCheckBox() throws InterruptedException
    {
        WebElement footer = driver.findElement(By.xpath("/html/body/app-root/app-footer/div/p"));
        Actions scrollToFooter = new Actions(driver);
        scrollToFooter.scrollToElement(footer).perform();

        List<WebElement> listCategory = driver.findElements(By.xpath("//*[@id=\"filters\"]/fieldset[1]/div"));
        for (WebElement element : listCategory)
        {
            element.findElement(By.xpath("./label/input")).click();
            Thread.sleep(4000);
            Assert.assertTrue(element.findElement(By.xpath("./label/input")).isSelected());
            System.out.println("Category selected: " + element.findElement(By.xpath("./label")).getText());
        }
    }

    @Test
    public void verifyFilterSubCheckBox() throws InterruptedException
    {
        WebElement footer = driver.findElement(By.xpath("/html/body/app-root/app-footer/div/p"));
        Actions scrollToFooter = new Actions(driver);
        scrollToFooter.scrollToElement(footer).perform();

        List<WebElement> listCategory = driver.findElements(By.xpath("//*[@id=\"filters\"]/fieldset[1]/div"));
        for (WebElement element : listCategory)
        {
            List<WebElement> subListCategory = element.findElements(By.xpath("./ul/fieldset/div"));
            for (WebElement subElement : subListCategory)
            {
                subElement.findElement(By.xpath("./label/input")).click();
                Thread.sleep(4000);
                Assert.assertTrue(subElement.findElement(By.xpath("./label/input")).isSelected());
                System.out.println("Sub-Category selected: " + subElement.getText());
            }
        }
    }

    @Test
    public void verifyFilterBrand() throws InterruptedException
    {
        WebElement footer = driver.findElement(By.xpath("/html/body/app-root/app-footer/div/p"));
        Actions scrollToFooter = new Actions(driver);
        scrollToFooter.scrollToElement(footer).build().perform();

        List<WebElement> listBrand = driver.findElements(By.xpath("//*[@id=\"filters\"]/fieldset[2]/div"));
        for (WebElement element : listBrand)
        {
            element.findElement(By.xpath("./label/input")).click();
            Thread.sleep(4000);
            Assert.assertTrue(element.findElement(By.xpath("./label/input")).isSelected());
            System.out.println("Brand selected: " + element.getText());
        }
    }

    @Test
    public void verifyPageSelector() throws InterruptedException
    {
        WebElement footer = driver.findElement(By.xpath("/html/body/app-root/app-footer/div/p"));
        Actions scrollToFooter = new Actions(driver);
        scrollToFooter.scrollToElement(footer).build().perform();

        List<WebElement> pagingButton = driver.findElements(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[2]/app-pagination/nav/ul/li[@class=\"page-item\"]"));

        for (WebElement element : pagingButton)
        {
            String selectedPage = element.findElement(By.xpath("./a")).getText();

            element.click();
            System.out.println("Page selected: " + element.getText());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            String currentPage = driver.findElement(By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[2]/app-pagination/nav/ul/li[@class=\"page-item active\"]/a")).getText();

            if (isNumeric(currentPage)&&isNumeric(selectedPage)) {
                Assert.assertEquals(selectedPage, currentPage);
            }
        }

        System.out.println("Number of page selected: " + pagingButton.size());
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    public static boolean isNumeric (String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
