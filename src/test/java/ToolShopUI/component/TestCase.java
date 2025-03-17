package ToolShopUI.component;

public class TestCase {

    private String testID;
    private String description;
    private String date;
    private String dataInput;
    private String expectedResult;
    private String actualResult;
    private boolean status;

    public TestCase() //Default constructor
    {
        this.testID = "";
        this.description = "";
        this.date = "";
        this.dataInput = "";
        this.expectedResult = "";
        this.actualResult = "";
        this.status = false;
    }

    public TestCase(String testID, String description, String date, String dataInput, String expectedResult, String actualResult, boolean status) {
        this.testID = testID;
        this.description = description;
        this.date = date;
        this.dataInput = dataInput;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.status = status;
    }

    public TestCase(TestCase iTestCase) {
        this.testID = iTestCase.getTestID();
        this.description = iTestCase.getDescription();
        this.date = iTestCase.getDate();
        this.dataInput = iTestCase.getDataInput();
        this.expectedResult = iTestCase.getExpectedResult();
        this.actualResult = iTestCase.getActualResult();
        this.status = iTestCase.getStatus();
    }

    public String getTestID() {
        return this.testID;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getDataInput()
    {
        return this.dataInput;
    }

    public String getExpectedResult()
    {
        return this.expectedResult;
    }

    public String getActualResult()
    {
        return this.actualResult;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setTestID(String testID)
    {
        this.testID = testID;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setDataInput(String dataInput)
    {
        this.dataInput = dataInput;
    }

    public void setExpectedResult(String expectedResult)
    {
        this.expectedResult = expectedResult;
    }

    public void setActualResult(String actualResult)
    {
        this.actualResult = actualResult;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public void inputDataHandler()
    {

    }

    public void printTestCase()
    {
        System.out.println("Test ID: " + this.testID);
        System.out.println("Description: " + this.description);
        System.out.println("Date: " + this.date);
        System.out.println("Data Input: " + this.dataInput);
        System.out.println("Expected Result: " + this.expectedResult);
        System.out.println("Actual Result: " + this.actualResult);
        System.out.println("Status: " + this.status);
        System.out.println("------------------------");
    }


}
