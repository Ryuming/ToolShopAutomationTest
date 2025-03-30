package ToolShopUI.handler;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverHandler implements CommonActionHandler{
    public void waitForImplicit(int timeOutBySec, WebDriver initDriver)
    {
        initDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutBySec));
    }
}
