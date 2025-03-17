package ToolShopUI.component;
import ToolShopUI.testCases.UserInformation;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        List<UserInformation> mylist  =  UserInformation.retrieveData("src/test/java/ToolShopUI/data.txt");

        for(UserInformation user : mylist) {
            System.out.println("Email: " + user.getUserEmail() + ", Password: " + user.getPassword());
            System.out.println("================================================================");
        }

        UserInformation.saveData(mylist, "src/test/java/ToolShopUI/output.txt");
    }
}
