package ToolShopUI.testCases;

import ToolShopUI.base.BaseSetUp;
import ToolShopUI.component.ConfigTextFile;
import ToolShopUI.component.ConfigTextFileHandler;
import ToolShopUI.pages.ToolShopHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ToolShopHomePageTest extends BaseSetUp {
    private WebDriver driver;
    public ToolShopHomePage toolShopHomePage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @BeforeMethod
    public void navigateToToolShopHomePage() {

        ConfigTextFileHandler configFile = new ConfigTextFileHandler();
        ConfigTextFile configData = new ConfigTextFile(configFile.openConfigFile(configBrowserFilePath));


        driver.navigate().to(configData.getSiteUrl());

    }

    @Test(priority = 1)
    public void verifyToolShopTitle() {
        toolShopHomePage = new ToolShopHomePage(driver);
        String title = toolShopHomePage.getHomePageTitle();
        Assert.assertEquals(title, "Practice Software Testing - Toolshop - v5.0");
    }

    @Test(priority = 2)
    public void verifyToolShopLogo()
    {
        toolShopHomePage = new ToolShopHomePage(driver);
        Assert.assertTrue(toolShopHomePage.getToolShopLogo().isDisplayed());
    }

    @Test(priority = 3)
    public void verifyHomeButtonClickable()
    {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.getHomeButton().click();
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Practice Software Testing - Toolshop - v5.0");
    }

    @Test(priority = 4)
    public void verifyContactButtonClickable() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.getContactButton().click();
        Thread.sleep(3000);
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Contact Us - Practice Software Testing - Toolshop - v5.0");
    }

    @Test(priority = 5)
    public void verifySignInButtonClickable() throws InterruptedException
    {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.getSignInButton().click();
        Thread.sleep(3000);
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
    }

    @Test(priority = 6)
    public void verifyCategoryButtonSelectable() throws InterruptedException
    {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.clickCategoryButton();
        List<WebElement> categoryList = toolShopHomePage.getCategoryDropdownList();

        for (int i = 0; i < categoryList.size(); i++) {
            String pageTitle = null;
            if (i < categoryList.size() - 2) {
                pageTitle = toolShopHomePage.handleCategoryList(i);
                Assert.assertEquals(toolShopHomePage.getNormalCategoryText(), "Category: " + pageTitle);
            } else if (i == categoryList.size() - 1) {
                pageTitle = toolShopHomePage.handleCategoryList(i);
                Assert.assertEquals(toolShopHomePage.getRentalCategoryText(), pageTitle);
            }
        }

    }

    @Test(priority = 7)
    public void verifyLanguageSelector() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.clickLanguageButton();
        List<WebElement> languageList = toolShopHomePage.getListLanguage();
        String defaultLanguage = "EN";
        int defaultLanguagePosition = 0;

        for (int i = 0; i < languageList.size(); i++) {
            String selectedLanguage = toolShopHomePage.handleLanguageDropdown(i);
            System.out.println("selectedLanguage: " + selectedLanguage);
            if (selectedLanguage.equals("EN")) {
                defaultLanguagePosition = i;
            }
            Assert.assertEquals(selectedLanguage, toolShopHomePage.getSelectedLanguageText());
        }
        toolShopHomePage.handleLanguageDropdown(defaultLanguagePosition);
    }


    @Test(priority = 8)
    public void verifySortBoxSelectable() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        Select sortBox = new Select(toolShopHomePage.getSortBox());
        List<WebElement> sortBoxOptions = sortBox.getOptions();
        for (int i = 0; i < sortBoxOptions.size(); i++)
        {
            sortBox.selectByIndex(i);
            Thread.sleep(800);
            System.out.println("Selected Option: " + toolShopHomePage.getSortBoxOption(i, sortBoxOptions));
        }
    }

    @Test(priority = 9)
    public void verifyPriceRangeSlider() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.dragAndDropSlider(toolShopHomePage.getMinSlider(), 195, 0);
        toolShopHomePage.dragAndDropSlider(toolShopHomePage.getMaxSlider(), -80, 0);
    }

    @Test(priority = 10)
    public void verifySearchBar() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        String searchString = "Hammer";
        toolShopHomePage.enterTextInSearchBox(searchString);
        toolShopHomePage.clickSearchButton();
        String searchResult = toolShopHomePage.getSearchResultText();

        System.out.println("Search result: " + searchResult);
        Assert.assertEquals(searchResult.toLowerCase(), searchString.toLowerCase());

    }

    @Test(priority = 11)
    public void verifyPageSelector() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.scrollToFooter();
        List<WebElement> pageButtons = toolShopHomePage.getPageButton();

        for (WebElement button : pageButtons) {
            toolShopHomePage.pageHandler(button);
        }

        System.out.println("Number of Page selected: " + pageButtons.size());
    }

    @Test(priority = 12)
    public void verifyFilterMainCategoryCheckBox() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.scrollToFooter();
        List<WebElement> listMainCategory = toolShopHomePage.getListCategory();
        for (WebElement mainCategory : listMainCategory) {
            toolShopHomePage.handleMainCategoryCheckBox(mainCategory);
        }
    }

    @Test(priority = 13)
    public void verifyFilterSubCategoryCheckBox() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.scrollToFooter();
            List<WebElement> listSubCategory = toolShopHomePage.getSubCategoryList();
            for (WebElement subCategory : listSubCategory) {
                toolShopHomePage.handleSubCategoryCheckBox(subCategory);
            }
    }

    @Test(priority = 14)
    public void verifyFilterBrandCheckBox() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.scrollToFooter();
        List<WebElement> listBrand = toolShopHomePage.getBrandList();
        for (WebElement brand : listBrand) {
            toolShopHomePage.handleBrandCheckBox(brand);
        }
    }

}
