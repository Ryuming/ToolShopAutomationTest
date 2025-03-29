package ToolShopUI.pages;

import ToolShopUI.component.PageNavigator;
import org.openqa.selenium.WebDriver;

public class ToolShopLogin implements PageNavigator {

    private WebDriver driver;

    @Override
    public void goToPage(String siteUrl) {
        driver.navigate().to(siteUrl);
    }

    private static final String loginPageUrl = "https://practicesoftwaretesting.com/auth/login";

}
