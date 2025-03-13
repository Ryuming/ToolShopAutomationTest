package ToolShopUI;

import org.testng.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInformation {
    private String userEmail;
    private String password;

    public UserInformation(String initUserEmail, String initPassword)
    {
        this.userEmail = initUserEmail.trim();
        this.password = initPassword.trim();
    }

    public UserInformation()
    {
        userEmail = "unidentified";
        password = "unidentified";
    }

    public UserInformation(UserInformation initUserInformation)
    {
        userEmail = initUserInformation.userEmail;
        password = initUserInformation.password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public static List<UserInformation> retrieveData(String direction){

        List<UserInformation> userInformationList = new ArrayList<UserInformation>();
        {
        // Implement data retrieval logic here

            try {
                File userInfoFile = new File(direction);

                FileReader reader = new FileReader(userInfoFile);
                BufferedReader bufferedReader = new BufferedReader(reader);

                while (true)
                {
                    UserInformation userInfo = new UserInformation();
                    String lineEmailInfo = bufferedReader.readLine();
                    String linePasInfo = bufferedReader.readLine();
                    if (lineEmailInfo == null || linePasInfo == null) {
                        break;
                    }
                    else {
                        userInfo.setUserEmail(lineEmailInfo.trim());
                        userInfo.setPassword(linePasInfo.trim());
                        userInformationList.add(userInfo);
                    }
                }
            }
            catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return userInformationList;
    }

    public static void saveData(List<UserInformation> userInformationList, String direction) throws IOException {
        File userInfoFile = new File(direction);

        // Ensure the parent directory exists
        if (userInfoFile.getParentFile() != null) {
            userInfoFile.getParentFile().mkdirs();
        }

        // Try-with-resources to ensure proper closing of resources
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userInfoFile, true))) {
            for (UserInformation userInfo : userInformationList) {
                bufferedWriter.write(userInfo.getUserEmail());
                bufferedWriter.newLine();
                bufferedWriter.write(userInfo.getPassword());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
    }
}
