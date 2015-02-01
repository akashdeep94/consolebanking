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
public class OpenAccount {
    
    public void account(String inputName,String inputPassword,int accountNo,double amount) throws Exception{
      FileWriter passwordHandler = new FileWriter("password.txt",true);
      passwordHandler.write(inputName+" "+inputPassword+"\n");
      FileWriter accountOpener = new FileWriter(String.valueOf(accountNo),true);
      accountOpener.write("accountNO "+accountNo+"\n");
      accountOpener.write("amount "+amount+"\n");
      passwordHandler.flush();
      accountOpener.flush();
      passwordHandler.close();
      accountOpener.close();
        
    }
    
    
} 
 