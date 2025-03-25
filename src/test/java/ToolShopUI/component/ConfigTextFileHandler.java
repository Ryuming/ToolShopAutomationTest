package ToolShopUI.component;

import java.io.*;
import java.io.File;
import java.io.FileReader;

public class ConfigTextFileHandler implements TextFileHandler {
    public ConfigTextFile openConfigFile(String filePath)
    {
        ConfigTextFile configFile = new ConfigTextFile();
        try {
            File textFile = new File(filePath);
            FileReader reader = new FileReader(textFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (true) {

                String currentLine = bufferedReader.readLine();
                if (currentLine == null) break;
                else if (currentLine.equals("browserType"))
                {
                    configFile.setBrowserType(bufferedReader.readLine());
                    System.out.println("Browser Type: " + configFile.getBrowserType());
                }
                else if (currentLine.equals("siteUrl"))
                {
                    configFile.setSiteUrl(bufferedReader.readLine());
                    System.out.println("Site URL: " + configFile.getSiteUrl());
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error while reading file at: " + filePath);
            e.printStackTrace();
        }
        return configFile;
    }
}
