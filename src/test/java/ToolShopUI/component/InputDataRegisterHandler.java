package ToolShopUI.component;

public class InputDataRegisterHandler extends RandomDataHandler{
    public static String generateEmailAddress(EmailFormat initEmail) throws Exception {



        return generateRandomString(initEmail.getNumUpperCaseChar())
                +generateRandomLowerCaseString(initEmail.getNumLowerCaseChar())
                +generateRandomNumberString(initEmail.getNumNumberChar())
                +generateRandomString(initEmail.getBeforeDotChar())
                +generateRandomString(initEmail.getAfterDotChar());
    }

    public static  String generateEmailAddress(int length) throws Exception {

        return generateRandomString(length)+"@example.com";
    }

    public static String generateRandomValidPassword(int numOfCharacter) throws Exception {

        numOfCharacter -= 6;
        return "Kk" +generateRandomString(numOfCharacter)+generateRandomNumberString(3)+"@";
    }

    public static String generateRandomInvalidPassword_TooShort() throws Exception {
        //TotalChar = 2+2+2+1 = 7
        return "Kk" +generateRandomString(2)+generateRandomNumberString(2) +"@";

    }

    public static String generateRandomInvalidPassword_TooLong() throws Exception {
        //TotalChar= 2+252+252+1 = 507
        return "Kk" +generateRandomString(252)+generateRandomNumberString(252) +"@";
    }

    public static String generateRandomInvalidPassword_NoSpecialChar() throws Exception {
        //TotalChar = 2+6+2 = 10
        return "Kk" + generateRandomString(6) + generateRandomNumberString(2);
    }

    public static String generateRandomInvalidPassword_NoNumber() throws Exception {
        //TotalChar = 2+6+1 =9
        return "Kk" + generateRandomString(6) + "@";
    }

    public static String generateRandomInvalidPassword_NoUppercase() throws Exception {
        //TotalChar = 8+1 =9
        return generateRandomLowerCaseString(8) + "@";
    }

    public static String generateRandomInvalidPassword_NoLowercase() throws Exception {
        //TotalChar = 8+1 =9
        return generateRandomUpperCaseString(8) + "@";
    }

}

