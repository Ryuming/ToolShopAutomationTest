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

    @Test
    public void verifyToolShopTitle()
    {
        System.out.println(driver);
        toolShopHomePage = new ToolShopHomePage(driver);
        String title = toolShopHomePage.getHomePageTitle();
        Assert.assertEquals(title, "Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifyToolShopLogo()
    {
        Assert.assertTrue(toolShopHomePage.getToolShopLogo().isDisplayed());
    }

    @Test
    public void verifyHomeButtonClickable()
    {
        toolShopHomePage.getHomeButton().click();
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifyContactButtonClickable()
    {
        toolShopHomePage.getContactButton().click();
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Contact Us - Practice Software Testing - Toolshop - v5.0");
    }

    public void verifySignInButtonClickable() throws InterruptedException
    {
        toolShopHomePage.getSignInButton().click();
        Thread.sleep(3000);
        Assert.assertEquals(toolShopHomePage.getHomePageTitle(), "Login - Practice Software Testing - Toolshop - v5.0");
    }

    @Test
    public void verifyCategoryButtonSelectable() throws InterruptedException
    {
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

}
