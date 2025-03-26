package ToolShopUI.pages;

import ToolShopUI.base.BaseSetUp;
import ToolShopUI.component.CommonActionHandler;
import ToolShopUI.component.DataFormatHandler;
import ToolShopUI.component.PageNavigator;
import ToolShopUI.component.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ToolShopHomePage implements PageNavigator {
    private WebDriver driver;

    private static final String homePageUrl = "http://practicesoftwaretesting.com/";
    private By toolShopLogo = By.cssSelector("#Layer_1");
    private By homeButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a");
    private By contactButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a");
    private By signInButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a");
    private By categoryButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a");
    private String categorySelected = "#navbarSupportedContent > ul > li.nav-item.dropdown > ul > li:nth-child";
    private By categoryDropdownList = By.cssSelector("#navbarSupportedContent > ul > li.nav-item.dropdown > ul > li");
    private By normalCategory = By.cssSelector("body > app-root > div > app-category > div:nth-child(1) > h2");
    private By rentalCategory = By.cssSelector("body > app-root > div > app-overview > div > h1");
    private By languageSelectButton = By.xpath("//*[@id=\"language\"]");
    private String languageSelected = "//*[@id=\"dropdown-animated\"]/li[";
    private By listLanguage =  By.xpath("//*[@id=\"dropdown-animated\"]/li/a");
    private By sortBox = By.xpath("//*[@id=\"filters\"]/form[1]/div/select");
    private By minSlider = By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[5]");
    private By maxSlider = By.xpath("//*[@id=\"filters\"]/div[1]/ngx-slider/span[6]");
    private By searchBox = By.xpath("//*[@id=\"search-query\"]");
    private By searchButton = By.xpath("//*[@id=\"filters\"]/form[2]/div/button[2]");
    private By searchResult = By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/h3/span");
    private By footer = By.xpath("/html/body/app-root/app-footer/div/p");
    private By listCategory = By.xpath("//*[@id=\"filters\"]/fieldset[1]/div");
    private By category = By.xpath("./label/input");
    private By textCategory = By.xpath("./label");
    private By subCategoryList = By.xpath("//*[@id=\"filters\"]/fieldset[1]/div/ul/fieldset/div");
    private By brandList = By.xpath("//*[@id=\"filters\"]/fieldset[2]/div");
    private By pageButton = By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[2]/app-pagination/nav/ul/li[@class=\"page-item\"]");
    private By singlePageButton = By.xpath("./a");
    private By currentPage = By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[2]/app-pagination/nav/ul/li[@class=\"page-item active\"]/a");

    public ToolShopHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle()  {
        return driver.getTitle();
    }

    public WebElement getToolShopLogo()
    {
        return driver.findElement(toolShopLogo);
    }

    public WebElement getHomeButton()
    {
        return driver.findElement(homeButton);
    }

    public WebElement getContactButton()
    {
        return driver.findElement(contactButton);
    }

    public WebElement getSignInButton()
    {
        return driver.findElement(signInButton);
    }

    public WebElement getCategoryButton()
    {
        return driver.findElement(categoryButton);
    }

    public WebElement getCategorySelected(int initialPosition)
    {
        return driver.findElement(By.cssSelector(categorySelected + "(" + (initialPosition+1) + ")"));
    }

    public List<WebElement> getCategoryDropdownList()
    {
        return driver.findElements(categoryDropdownList);
    }

    public WebElement getNormalCategory()
    {
        return driver.findElement(normalCategory);
    }

    public WebElement getRentalCategory()
    {
        return driver.findElement(rentalCategory);
    }

    public WebElement getLanguageSelectButton()
    {
        return driver.findElement(languageSelectButton);
    }

    public WebElement getLanguageSelected(int initialPosition)
    {
        return driver.findElement(By.xpath(languageSelected + (initialPosition+1) + "]/a"));
    }
    public List<WebElement> getListLanguage()
    {
        return driver.findElements(listLanguage);
    }

    public WebElement getSortBox()
    {
        return driver.findElement(sortBox);
    }

    public WebElement getMinSlider()
    {
        return driver.findElement(minSlider);
    }

    public WebElement getMaxSlider()
    {
        return driver.findElement(maxSlider);
    }

    public WebElement getSearchBox()
    {
        return driver.findElement(searchBox);
    }

    public WebElement getSearchButton()
    {
        return driver.findElement(searchButton);
    }

    public WebElement getSearchResult()
    {
        return driver.findElement(searchResult);
    }

    public WebElement getFooter()
    {
        return driver.findElement(footer);
    }

    public List<WebElement> getListCategory()
    {
        return driver.findElements(listCategory);
    }

    public WebElement getCategory()
    {
        return driver.findElement(category);
    }

    public By getTextCategory() {
        return textCategory;
    }

    public List<WebElement> getSubCategoryList()
    {
        return driver.findElements(subCategoryList);
    }
    public List<WebElement> getBrandList()
    {
        return driver.findElements(brandList);
    }
    public List<WebElement> getPageButton()
    {
        return driver.findElements(pageButton);
    }

    public WebElement getSinglePageButton()
    {
        return driver.findElement(singlePageButton);
    }

    public WebElement getCurrentPage()
    {
        return driver.findElement(currentPage);
    }

    public void goToPage(String siteUrl)
    {
        driver.navigate().to(siteUrl);
        new WebDriverHandler().waitForImplicit(3, driver);
    }

    public String handleCategoryList(int initPivot) throws InterruptedException
    {
        goToPage(homePageUrl);
        getCategoryButton().click();
        Thread.sleep(1000);
        String categorySelected = getCategorySelected(initPivot).getText();
        getCategorySelected(initPivot).click();
        Thread.sleep(2000);
        return categorySelected;
    }

    public String handleLanguageDropdown(int initPivot) throws InterruptedException {
        goToPage(homePageUrl);
        getLanguageSelectButton().click();
        Thread.sleep(1000);

        String selectedLanguage = getLanguageSelected(initPivot).getText();
        getLanguageSelected(initPivot).click();
        Thread.sleep(2000);
        return selectedLanguage;
    }

    public void clickCategoryButton() throws InterruptedException
    {
        getCategoryButton().click();
        Thread.sleep(1000);
    }

    public void clickLanguageButton() throws InterruptedException
    {
        getLanguageSelectButton().click();
        Thread.sleep(1000);
    }

    public String getNormalCategoryText()
    {
        return getNormalCategory().getText();
    }

    public String getRentalCategoryText()
    {
        return getRentalCategory().getText();
    }

    public String getSelectedLanguageText()
    {
        return getLanguageSelectButton().getText();
    }

    public String getSortBoxOption(int index, List<WebElement> listOptions)
    {
        return listOptions.get(index).getText();
    }

    public void dragAndDropSlider(WebElement element, int xOffSet, int yOffSet) throws InterruptedException
    {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xOffSet, yOffSet).build().perform();
        Thread.sleep(2000);
    }


    public void enterTextInSearchBox(String text) throws InterruptedException {
        getSearchBox().sendKeys(text);
        Thread.sleep(2000);
    }

    public void clickSearchButton() throws InterruptedException {
        getSearchButton().click();
        new WebDriverHandler().waitForImplicit(3, driver);
    }

    public String getSearchResultText() {
        return getSearchResult().getText();
    }

    public void scrollToFooter() throws InterruptedException{
        WebElement footer = getFooter();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getCurrentPageText() {
        return getCurrentPage().getText();
    }

    public void clickSelectedPage(WebElement element)
    {
        element.click();
        System.out.println("Page selected: " + element.getText());
        new WebDriverHandler().waitForImplicit(3, driver);
    }

    public void pageHandler(WebElement initElement)
    {
        String selectedPage = initElement.findElement(By.xpath("./a")).getText();
        clickSelectedPage(initElement);
        String currentPage = getCurrentPageText();

        if (DataFormatHandler.isNumeric(selectedPage)&&DataFormatHandler.isNumeric(currentPage))
        {
            Assert.assertEquals(currentPage,selectedPage);
        }
    }

    public void handleMainCategoryCheckBox(WebElement initElement) throws InterruptedException
    {
        WebElement currentSelectedElement = initElement.findElement(By.xpath("./label/input"));
        currentSelectedElement.click();
        Thread.sleep(4000);
        Assert.assertTrue(currentSelectedElement.isSelected());
        System.out.println("Category Selected: " + initElement.findElement(By.xpath("./label")).getText() );

    }

    public void handleSubCategoryCheckBox(WebElement initElement) throws InterruptedException
    {
        WebElement selectedSubCategory = initElement.findElement(By.xpath("./label/input"));
        selectedSubCategory.click();
        Thread.sleep(4000);
        Assert.assertTrue(selectedSubCategory.isSelected());
        System.out.println("Subcategory Selected: " + initElement.findElement(By.xpath("./label")).getText());
    }

    public void handleBrandCheckBox(WebElement initElement) throws InterruptedException
    {
        WebElement selectedBrand = initElement.findElement(By.xpath("./label/input"));
        selectedBrand.click();
        Thread.sleep(4000);
        Assert.assertTrue(selectedBrand.isSelected());
        System.out.println("Brand Selected: " + initElement.findElement(By.xpath("./label")).getText());
    }
}
