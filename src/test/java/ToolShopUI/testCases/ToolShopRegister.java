package ToolShopUI.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ToolShopRegister {
    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "src/main/resources/chromedriver-win64/chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();

    }

    @BeforeMethod
    public void navigateToHomePage()
    {
        driver.navigate().to("https://practicesoftwaretesting.com/auth/register");
    }

    private static char randomUpperCaseCharacter()
    {
        Random randomNum = new Random();
        return (char)(randomNum.nextInt(26) + 'A');
    }

    private static char randomLowerCaseCharacter()
    {
        Random randomNum = new Random();
        return (char)(randomNum.nextInt(26) + 'a');
    }
    private static char randomCharacters()
    {
        Random randomNum = new Random();

        int pivot = (randomNum.nextInt(2));

        char myChar;

        if (pivot == 0) {
            myChar = randomLowerCaseCharacter();
        }
        else
        {
            myChar = randomUpperCaseCharacter();
        }

        return myChar;
    }

    private static String generateRandomUpperCaseString(int numOfCharacter)
    {
        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < numOfCharacter; i++)
        {
            myString.append(randomUpperCaseCharacter());
        }

        return myString.toString();
    }

    private static String generateRandomLowerCaseString(int numOfCharacter)
    {
        StringBuilder myString = new StringBuilder();
        for (int i =0; i < numOfCharacter; i++)
        {
            myString.append(randomLowerCaseCharacter());
        }
        return myString.toString();
    }

    private static char randomNumber(int numOfCharacter)
    {
        Random randomNum = new Random();

        return (char)(randomNum.nextInt(100));
    }


    public void UnitTest()
    {
        for(int i = 0; i < 10 ; i++) {
            System.out.println("Test "+ i);
            System.out.println("Email: " + generateRandomEmailAddress(12));
            System.out.println("Password: "+ generateRandomPassword(8));
            System.out.println("================================================================");
        }
    }

    private static int randomNumbers()
    {
        Random random = new Random();
        return random.nextInt(10);
    }

    private static String generateRandomString(int numOfCharacter)
    {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < numOfCharacter;i++)
        {
            returnString.append(randomCharacters());
        }
        return returnString.toString();
    }

    private static String generateRandomNumber(int numOfNumber)
    {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < numOfNumber;i++)
        {
            returnString.append(randomNumbers());
        }
        return returnString.toString();
    }

    private static String generateRandomEmailAddress(int numOfCharacter)
    {
        return generateRandomString(numOfCharacter) + "@" + generateRandomString(3) + ".com";
    }

    private static String generateRandomPassword(int numOfCharacter)
    {
        numOfCharacter -= 5;
        return "K" +generateRandomString(numOfCharacter)+generateRandomNumber(3)+"@";
    }



    public static void register(String initUserEmail, String initPassword)
    {
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                initUserEmail,
                initPassword);


    }

    public static void registerWithForm(
            String initFirstName, String initLastName,
            String initDoB,
            String initStreet,
            String initCity,
            String initPostalCode,
            String initState,
            String initCountry,
            String initPhone,
            String initUserEmail,
            String initPassword)
    {
        WebElement firstNameTextBox = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstNameTextBox.sendKeys(initFirstName);

        WebElement lastNameTextBox = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastNameTextBox.sendKeys(initLastName);

        WebElement dobTextBox = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
        dobTextBox.sendKeys(initDoB);

        WebElement streetTextBox = driver.findElement(By.xpath("//*[@id=\"street\"]"));
        streetTextBox.sendKeys(initStreet);

        WebElement cityTextBox = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        cityTextBox.sendKeys(initCity);

        WebElement postalCodeTextBox = driver.findElement(By.xpath("//*[@id=\"postal_code\"]"));
        postalCodeTextBox.sendKeys(initPostalCode);

        WebElement stateTextBox = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        stateTextBox.sendKeys(initState);

        Select countryDropdownList = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
        countryDropdownList.selectByVisibleText(initCountry);

        WebElement phoneTextBox = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        phoneTextBox.sendKeys(initPhone);

        WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailTextBox.sendKeys(initUserEmail);

        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordBox.sendKeys(initPassword);

        WebElement registerButton = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button"));
        registerButton.click();
    }

    @Test
    public void verifyUserRegistration() throws InterruptedException, IOException {

        String userEmail = generateRandomEmailAddress(23);
        String userPassword = generateRandomPassword(8);

        register(userEmail, userPassword);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Login - Practice Software Testing - Toolshop - v5.0");

        List<UserInformation> users = new ArrayList<>();
        UserInformation user = new UserInformation(userEmail, userPassword);
        users.add(user);
        UserInformation.saveData(users, "output.txt");
    }

    @Test
    public void verifyEmailFormatInRegistration() throws InterruptedException {
        String invalidEmail = generateRandomString(15);
        String validPassword = generateRandomPassword(8);

        register(invalidEmail, validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[10]/div"));

        Assert.assertEquals(errorMessage.getText(), "Invalid Email Address");

    }

    @Test
    public void verifyPasswordFormatInRegistration_LengthIsShorterThan8() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomString(7);
        register(validEmail, invalidPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));

        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));

        Assert.assertEquals(errorMessage.getText(), "Password must be minimal 8 characters long.");


    }

    @Test
    public void verifyPasswordFormatInRegistration_NotContainUpperCase() throws InterruptedException {

        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomLowerCaseString(6) + randomNumber(1) + "@";

        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
        Assert.assertEquals(errorMessage.getText(), "Password must contain at least one uppercase letter.");
    }

    @Test
    public void verifyPasswordFormatInRegistration_NotContainLowerCase() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomUpperCaseString(6) + randomNumber(1) + "@";
        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
        Assert.assertEquals(errorMessage.getText(), "Password must contain at least one lowercase letter.");
    }

    @Test
    public void verifyPasswordFormatInRegistration_NotContainNumber() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomString(7)  + "@";
        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
        Assert.assertEquals(errorMessage.getText(), "Password must contain at least one number.");
    }

    @Test
    public void verifyPasswordFormatInRegistration_NotContainSpecialCharacter() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomString(7) + generateRandomNumber(1);
        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
        Assert.assertEquals(errorMessage.getText(), "Password must contain at least one special character.");
    }

    @Test
    public void verifyPasswordFormatRegistration_EmptyPassword() throws InterruptedException
    {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = "";
        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
        Assert.assertEquals(errorMessage.getText(), "Password is required");
    }

    @Test
    public void verifyPasswordFormatRegistration_TooLongPassword() throws InterruptedException, NoSuchElementException
    {
        String validEmail = generateRandomEmailAddress(23);
        String invalidPassword = generateRandomPassword(128);
        register(validEmail, invalidPassword);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        try {
            WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[11]/div[3]/div"));
            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertEquals(errorMessage.getText(), "Password is too long");
        }
        catch (NoSuchElementException e) {
            Assert.fail("No error message found");
        }


    }

    @Test
    public void verifyRegistration_MissingFirstName() throws InterruptedException
    {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyFirstName = "";
        registerWithForm(
                emptyFirstName,
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[1]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "First Name is required");
    }

    @Test
    public void verifyRegistration_MissingLastName() throws InterruptedException
    {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyLastName = "";
        registerWithForm(
                "John",
                emptyLastName,
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[2]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "Last Name is required");
    }

    @Test
    public void verifyRegistration_MissingDateOfBirth() throws InterruptedException
    {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyDateOfBirth = "";
        registerWithForm(
                "John",
                "Doe",
                emptyDateOfBirth,
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[3]/div/div"));
        Assert.assertEquals(errorMessage.getText(), "Date of Birth is required");
    }

    @Test
    public void verifyRegistration_MissingStreet() throws InterruptedException
    {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyStreet = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                emptyStreet,
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[4]/div/div"));
        Assert.assertEquals(errorMessage.getText(), "Street is required");
    }

    @Test void verifyRegistration_MissingPostalCode() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyPostalCode = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                emptyPostalCode,
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[5]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "Postal code is required");
    }

    @Test
    public void verifyRegistration_MissingCity() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyCity = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                emptyCity,
                "123",
                "NY",
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[6]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "City is required");
    }

    @Test
    public void verifyRegistration_MissingState() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyState = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                emptyState,
                "United States of America (the)",
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[7]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "State is required");
    }

    @Test
    public void verifyRegistration_MissingCountry() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyCountry = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                emptyCountry,
                "84325679412",
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[8]/div[2]/div"));
        Assert.assertEquals(errorMessage.getText(), "Country is required");
    }

    @Test
    public void verifyRegistration_MissingPhoneNumber() throws InterruptedException {
        String validEmail = generateRandomEmailAddress(32);
        String validPassword = generateRandomPassword(8);
        String emptyPhoneNumber = "";
        registerWithForm(
                "John",
                "Doe",
                "01-01-1999",
                "68, Saint Paul ST",
                "New York",
                "123",
                "NY",
                "United States of America (the)",
                emptyPhoneNumber,
                validEmail,
                validPassword);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(Duration.ofSeconds(3));
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/div[9]/div/div"));
        Assert.assertEquals(errorMessage.getText(), "Phone number is required");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
