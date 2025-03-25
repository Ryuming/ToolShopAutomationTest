package ToolShopUI.testCases;

import ToolShopUI.base.BaseSetUp;
import ToolShopUI.pages.ToolShopHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ToolShopHomePageTest extends BaseSetUp {
    private WebDriver driver;
    public ToolShopHomePage toolShopHomePage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
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
                Assert.assertEquals(toolShopHomePage.getNormalCategory().getText(), "Category: " + pageTitle);
            } else if (i == categoryList.size() - 1) {
                pageTitle = toolShopHomePage.handleCategoryList(i);
                Assert.assertEquals(toolShopHomePage.getRentalCategory().getText(), pageTitle);
            }
        }

    }

    @Test(priority = 7)
    public void verifyLanguageSelector() throws InterruptedException {
        toolShopHomePage = new ToolShopHomePage(driver);
        toolShopHomePage.clickLanguageButton();
        List<WebElement> languageList = toolShopHomePage.getListLanguage();

        for (int i = 0; i < languageList.size(); i++) {
            String selectedLanguage = toolShopHomePage.handleLanguageDropdown(i);
            System.out.println("selectedLanguage: " + selectedLanguage);
            Assert.assertEquals(selectedLanguage, toolShopHomePage.getLanguageSelectButton().getText());
        }

    }



}
