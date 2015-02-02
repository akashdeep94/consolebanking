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
import java.util.*;
public class OpenAccount {
    int accountNo;
    public void account(String inputName,String inputPassword,double amount) throws Exception{
      
      FileWriter passwordHandler = new FileWriter("password.txt",true);
      FileWriter accountNoWriter = new FileWriter("accountNo.txt");
      FileReader accountNoReader = new FileReader("accountNo.txt"); 
      BufferedReader br = new BufferedReader(accountNoWriter);
      while(scan.hasNextLine()){
      accountNo=Integer.parseInt(scan.nextLine());
          System.out.println("inside while AccountNo is"+ accountNo);
      }
        System.out.println("below while");
      scan.close();
      passwordHandler.write(inputName+" "+inputPassword+"\n");
      FileWriter accountOpener = new FileWriter(accountNo+".txt",true);
      accountOpener.write("Name "+inputName+"\n");
      accountOpener.write("AccountNo "+accountNo+"\n");
      accountOpener.write("Amount "+amount+"\n");
      passwordHandler.flush();
      accountOpener.flush();
      passwordHandler.close();
      accountOpener.close();
      accountNo++;
        System.out.println(accountNo);
      accountNoWriter.write(""+accountNo);
      accountNoWriter.flush();
      accountNoWriter.close();
      System.out.println("New account opened,Your account no is " + accountNo);
        
    }
    
    
} 
 