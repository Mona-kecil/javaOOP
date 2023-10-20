package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import entity.User;

public class UserDataUtility {
    
    private static final String USER_DATA_PATH = "user_data/";

    public static void readUsers(ArrayList<User> user) {
        String filePath = String.format(USER_DATA_PATH + "users.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            while((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                
                if (userData.length == 6) {
                    User readUser = new User();

                    readUser.setUsername(userData[0]);
                    readUser.setPassword(userData[1]);
                    readUser.setEmail(userData[2]);
                    readUser.setFirstName(userData[3]);
                    readUser.setLastName(userData[4]);

                    user.add(readUser);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printUserData(ArrayList<User> user)
    {
        for (int i = 0; i < user.size(); i++)
        {
            System.out.println(i+1 + ". " +user.get(i).getUsername() + " " + user.get(i).getPassword() + " " + user.get(i).getEmail() + " " + user.get(i).getFirstName() + " " + user.get(i).getLastName());
        }
    }

    public static void writeUsers(ArrayList<User> user) {
        String filepath = String.format(USER_DATA_PATH + "users.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));

            for (var item : user)
                bw.write(item.getUserId() + "," + item.getUsername() + "," + item.getPassword() + "," + item.getEmail() + "," + item.getFirstName() + "," + item.getLastName());
            
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
