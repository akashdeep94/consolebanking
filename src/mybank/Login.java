/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

import java.io.*;
import java.util.*;

/**
 *
 * @author Akash
 */
public class Login {
    
   
    boolean verifyCredentials(String inputUser, String inputPassword) throws Exception {
        Scanner scr = new Scanner(new File("password.txt"));
        boolean flag = false;
        while (scr.hasNextLine()) {
            String line = scr.nextLine();
            String username = line.substring(0, line.indexOf(' '));
            String password = line.substring(line.indexOf(' ') + 1, line.length());
            if (inputUser.equals(username) && inputPassword.equals(password)) {
                System.out.println("Valid user");
                flag = true;
                break;
            }

        }
        return flag;
    }

}

    

