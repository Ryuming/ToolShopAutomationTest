package ToolShopUI.pages;

import ToolShopUI.component.PageNavigator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolShopRegisterPage implements PageNavigator {

    private WebDriver driver;
    @Override
    public void goToPage(String siteUrl) {
        driver.navigate().to(siteUrl);
    }

    private static final String registerPageUrl = "https://practicesoftwaretesting.com/auth/register";

    private By firstNameTextBox = By.xpath("//*[@id=\"first_name\"]");
    private By lastNameTextBox = By.xpath("//*[@id=\"last_name\"]");
    private By dobTextBox = By.xpath("//*[@id=\"dob\"]");
    private By streetTextBox = By.xpath("//*[@id=\"street\"]");
    private By cityTextBox = By.xpath("//*[@id=\"city\"]");
    private By postalCodeTextBox = By.xpath("//*[@id=\"postal_code\"]");
    private By stateTextBox = By.xpath("//*[@id=\"state\"]");
    private By countryTextBox = By.xpath("//*[@id=\"country\"]");
    private By phoneTextBox = By.xpath("//*[@id=\"phone\"]");
    private By emailTextBox = By.xpath("//*[@id=\"email\"]");
    private By passwordTextBox = By.xpath("//*[@id=\"password\"]");
    private By registerButton = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button");

    private By errorMsgPassword = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div");
    private By errorMsgFirstName = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[1]/div[2]/div");
    private By errorMsgLastName = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[2]/div[2]/div");
    private By errorMsgDOB = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[3]/div/div");
    private By errorMsgStreet = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[4]/div/div");
    private By errorMsgPostalCode = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[5]/div[2]/div");
    private By errorMsgCity = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[6]/div[2]/div");
    private By errorMsgState = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[7]/div[2]/div");
    private By errorMsgCountry = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[8]/div[2]/div");
    private By errorMsgPhoneNumber = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[9]/div/div");

    public WebElement getFirstName()
    {
        return driver.findElement(firstNameTextBox);
    }

    public WebElement getLastNameTextBox()
    {
        return driver.findElement(lastNameTextBox);
    }

    public WebElement getDOBTextBox()
    {
        return driver.findElement(dobTextBox);
    }

    public WebElement getStreetTextBox()
    {
        return driver.findElement(streetTextBox);
    }

    public WebElement getCityTextBox()
    {
        return driver.findElement(cityTextBox);
    }

    public WebElement getPostalCodeTextBox()
    {
        return driver.findElement(postalCodeTextBox);
    }

    public WebElement getStateTextBox()
    {
        return driver.findElement(stateTextBox);
    }

    public WebElement getCountryTextBox()
    {
        return driver.findElement(countryTextBox);
    }

    public WebElement getPhoneTextBox()
    {
        return driver.findElement(phoneTextBox);
    }

    public WebElement getEmailTextBox()
    {
        return driver.findElement(emailTextBox);
    }

    public WebElement getPasswordTextBox()
    {
        return driver.findElement(passwordTextBox);
    }

    public WebElement getRegisterButton()
    {
        return driver.findElement(registerButton);
    }

    public WebElement getErrorMsgPassword()
    {
        return driver.findElement(errorMsgPassword);
    }

    public WebElement getErrorMsgFirstName()
    {
        return driver.findElement(errorMsgFirstName);
    }

    public WebElement getErrorMsgLastName()
    {
        return driver.findElement(errorMsgLastName);
    }

    public WebElement getErrorMsgDOB()
    {
        return driver.findElement(errorMsgDOB);
    }

    public WebElement getErrorMsgStreet()
    {
        return driver.findElement(errorMsgStreet);
    }

    public WebElement getErrorMsgPostalCode()
    {
        return driver.findElement(errorMsgPostalCode);
    }

    public WebElement getErrorMsgCity()
    {
        return driver.findElement(errorMsgCity);
    }

    public WebElement getErrorMsgState()
    {
        return driver.findElement(errorMsgState);
    }

    public WebElement getErrorMsgCountry()
    {
        return driver.findElement(errorMsgCountry);
    }

    public WebElement getErrorMsgPhoneNumber()
    {
        return driver.findElement(errorMsgPhoneNumber);
    }

    public String getErrorMsgPasswordText()
    {
        return getErrorMsgPassword().getText();
    }

    public String getErrorMsgFirstNameText()
    {
        return getErrorMsgFirstName().getText();
    }

    public String getErrorMsgLastNameText()
    {
        return getErrorMsgLastName().getText();
    }

    public String getErrorMsgDOIText()
    {
        return getErrorMsgDOB().getText();
    }

    public String getErrorMsgStreetText()
    {
        return getErrorMsgStreet().getText();
    }

    public String getErrorMsgPostalCodeText()
    {
        return getErrorMsgPostalCode().getText();
    }

    public String getErrorMsgCityText()
    {
        return getErrorMsgCity().getText();
    }

    public String getErrorMsgStateText()
    {
        return getErrorMsgState().getText();
    }

    public String getErrorMsgCountryText()
    {
        return getErrorMsgCountry().getText();
    }

    public String getErrorMsgPhoneNumberText()
    {
        return getErrorMsgPhoneNumber().getText();
    }

    public void clickRegisterButton()
    {
        getRegisterButton().click();
    }

    public void inputFirstName(String initFirstName)
    {
        getFirstName().sendKeys(initFirstName);
    }

    public void inputLastName(String initLastName)
    {
        getLastNameTextBox().sendKeys(initLastName);
    }

    public void inputDOB(String initDoB)
    {
        getDOBTextBox().sendKeys(initDoB);
    }

    public void inputStreet(String initStreet)
    {
        getStreetTextBox().sendKeys(initStreet);
    }

    public void inputPostalCode(String initPostalCode)
    {
        getPostalCodeTextBox().sendKeys(initPostalCode);
    }

    public void inputCity(String initCity)
    {
        getCityTextBox().sendKeys(initCity);
    }

    public void inputState(String initState)
    {
        getStateTextBox().sendKeys(initState);
    }

    public void inputCountry(String initCountry)
    {
        getCountryTextBox().sendKeys(initCountry);
    }

    public void inputPhone(String initPhone)
    {
        getPhoneTextBox().sendKeys(initPhone);
    }

    public void inputEmail(String initUserEmail)
    {
        getEmailTextBox().sendKeys(initUserEmail);
    }

    public void inputPassword(String initPassword)
    {
        getPasswordTextBox().sendKeys(initPassword);
    }

}
