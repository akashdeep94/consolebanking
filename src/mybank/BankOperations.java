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
import java.util.Scanner;

public class BankOperations {

    int currentAccount = 101;

    public void deposit() {

    }

    public void menu() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String inputName;
        String inputPassword;
        System.out.println("Welcome to axis bank");
        System.out.println("1:Open new account.");
        System.out.println("2:Login");
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
                int accountNo = currentAccount;
                accountopener.account(inputName, inputPassword, currentAccount, amount);
                currentAccount++;
                System.out.println("New account opened,Your account no is "+accountNo);
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
        /*Scanner scan = new Scanner(System.in);
         try {
         int input = Integer.parseInt(scan.next());
         switch (input) {
         case 1:
         System.out.println("Enter your name");
         String inputName = scan.next().toUpperCase();
         System.out.println("Enter amount to be deposited");
         int inputAmount = Integer.parseInt(scan.next());
         openAccount(inputName, inputAmount);
         menu();
         case 2:
         System.out.println("Enter your account No");
         int inputAccountNo = Integer.parseInt(scan.next());
         System.out.println("Enter amount to be deposited");
         inputAmount = Integer.parseInt(scan.next());
         deposit(inputAccountNo, inputAmount);
         menu();
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
         } catch (Exception e) {
         System.out.println("Invalid input.Try Again");
         menu();
         }
         }*/
    }
}
