package ToolShopUI.handler;

import org.junit.jupiter.api.Disabled;
import org.testng.annotations.Test;

import java.util.Random;

public class RandomDataHandler {
    public static char randomUpperCaseChar()
    {
        Random rd = new Random();
        return (char)(rd.nextInt(26) + 'A');
    }

    public static char randomLowerCaseChar()
    {
        Random rd = new Random();
        return (char)(rd.nextInt(26) + 'a');
    }

    public static char randomNum()
    {
        Random rd = new Random();
        return (char)(rd.nextInt(10) + '0');
    }

    public static char randomChar()
    {
        Random rd = new Random();
        int pivot = (rd.nextInt(2));

        char myChar;

        if (pivot == 0) {
            myChar = randomLowerCaseChar();
        }
        else
        {
            myChar = randomUpperCaseChar();
        }

        return myChar;
    }

    public static String generateRandomString(int numOfCharacter)
    {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < numOfCharacter;i++)
        {
            returnString.append(randomChar());
        }
        return returnString.toString();
    }

    public static String generateRandomUpperCaseString(int numOfCharacter)
    {
        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < numOfCharacter; i++)
        {
            myString.append(randomUpperCaseChar());
        }
        return myString.toString();
    }

    public static String generateRandomLowerCaseString(int numOfCharacter)
    {
        StringBuilder myString = new StringBuilder();
        for (int i =0; i < numOfCharacter; i++)
        {
            myString.append(randomLowerCaseChar());
        }
        return myString.toString();
    }

    public static String generateRandomNumberString(int numOfCharacter)
    {
        StringBuilder myString = new StringBuilder();
        for (int i =0; i < numOfCharacter; i++)
        {
            myString.append(randomNum());
        }
        return myString.toString();
    }

    @Test
    @Disabled
    private void UnitTest()
    {
        for(int i = 0; i < 10 ; i++) {
            System.out.println("Test "+ i);
            System.out.println("Generated Random String" + generateRandomString(10));
            System.out.println("Generated Random Uppercase String" + generateRandomUpperCaseString(10));
            System.out.println("Generated Random Lowercase String" + generateRandomLowerCaseString(10));
            System.out.println("Generated Random Number String" + generateRandomNumberString(10));
            System.out.println("================================================================");
        }
    }

}
