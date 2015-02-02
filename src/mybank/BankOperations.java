 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

/**
 *
 * @author Akash
 */
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class BankOperations {

    

    public void deposit(String accountNo, double amount) throws Exception {
        File searchFile = new File(accountNo+".txt");
        FileWriter fw = new FileWriter(accountNo + "temp.txt", true);
        if (searchFile.exists()) {
            Scanner deposit = new Scanner(searchFile);
             while (deposit.hasNextLine()) {
                String line = deposit.nextLine();
                System.out.println(line);
                if (line.contains("Amount")) {
                    double currAmount = (Double.parseDouble(line.substring(line.indexOf(" ") + 1, line.length())));
                    double updatedAmount = currAmount + amount;
                    fw.write(line.replaceAll(String.valueOf(currAmount), String.valueOf(updatedAmount)) + "\n");

                } else {
                    fw.write(line + "\n");
                }
            }
           deposit.close();
        }
        fw.flush();
        fw.close();
         try {
            if (searchFile.delete()) {
                System.out.println("Amount credited to your account");

            } else {
                System.out.println("operation failed,Rolling back your transaction");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new File(accountNo + "temp.txt").renameTo(searchFile);

    }

    public void menu() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String inputName;
        String inputPassword;
        System.out.println("Welcome to axis bank");
        System.out.println("1:Open new account.");
        System.out.println("2:Login");
        try{
        int choice = (Integer.parseInt(br.readLine()));

        switch (choice) {
            case 1:
                OpenAccount accountopener = new OpenAccount();
                System.out.print("Enter UserName:- ");
                inputName = br.readLine();
                System.out.print("Enter Password:- ");
                inputPassword = br.readLine();
                System.out.print("Enter Initial amount:- ");
                double amount = Double.parseDouble(br.readLine());
                accountopener.account(inputName, inputPassword, amount);
                System.out.println();
                menu();
            case 2:
                Login c = new Login();
                System.out.print("Enter user name:- ");
                inputName = br.readLine();
                System.out.print("Enter Password:- ");
                inputPassword = br.readLine();
                boolean flag = c.verifyCredentials(inputName, inputPassword);
                if (flag) {
                    mainMenu();
                } else {
                    System.out.println("Invalid UserName or Password.Try Again");
                    System.out.println();
                    menu();
                }

        }
        }
        catch(Exception e){
            System.out.println("Invalid Input.Try Again");
            menu();
        }
        
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("Login Successful");
        System.out.println("---------------------------");

        System.out.println("Enter your choice");
        System.out.println("1: Deposit funds");
        System.out.println("2: WithDraw Funds");
        System.out.println("3: Check Account");
        System.out.println("4: Check Transaction");
        System.out.println("5: Show all Accounts");
        System.out.println("6: Show all user transaction History ");
        System.out.println("0: Logout");
        System.out.println("---------------------------");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        try {
            int input = Integer.parseInt(scan.next());
            switch (input) {
                case 1:
                    System.out.println("Enter your account No");
                    String inputAccountNo = scan.next();
                    System.out.println("Enter amount to be deposited");
                    int inputAmount = Integer.parseInt(scan.next());
                    deposit(inputAccountNo, inputAmount);
                    menu();
            }
        } /*
         case 3:
         System.out.println("Enter your account No");
         inputAccountNo = Integer.parseInt(scan.next());
         System.out.println("Enter amount to be withdrawn");
         inputAmount = Integer.parseInt(scan.next());
         withDraw(inputAccountNo, inputAmount);
         menu();
         case 4:
         System.out.println("Enter your account No");
         inputAccountNo = Integer.parseInt(scan.next());
         checkAmount(inputAccountNo);
         menu();
         case 5:
         System.out.println("Enter your account No");
         inputAccountNo = Integer.parseInt(scan.next());
         transactionCheck(inputAccountNo);
         menu();
         case 6:
         showAll();
         menu();
         case 7:
         allTransactions();
         menu();
         case 8:
         System.out.println("Enter String");
         String search=scan.next();
         search(search);
         case 0:
         System.out.println("Exiting the application");
         System.exit(0);
         default:
         System.out.println("No match found.Please retry");
         menu();

         }
         } */ catch (Exception e) {
            System.out.println("Invalid input.Try Again");
            mainMenu();
        }

    }
}
