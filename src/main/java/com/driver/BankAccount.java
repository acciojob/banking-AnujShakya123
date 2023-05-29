package com.driver;
import static java.lang.Math.min;
import java.security.SecureRandom;
import java.util.Random;
//import java.lang.String;
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    public BankAccount(String name, double balance, double minBalance) {
    this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
          if(sum<0 || sum>digits*9){
              throw new AccountNumberCannotBeGeneratedException("Account Number cannot be generated");
          }
          int remaining=sum;
          String acNo="";
          for(int i=0;i<digits;i++){
              int dig=min(9,remaining);
              acNo+=dig;
              remaining-=dig;
          }
            acNo="";
          Random rand=new Random();
          int n;
          int remainingSum=sum;
          for(int i=0;i<digits;i++){
              int max=min(remainingSum+1,10);
              n=rand.nextInt(max);
              acNo+=String.valueOf(n);
              remainingSum-=n;
          }
        return acNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
     if(this.balance<amount || this.balance-amount<this.minBalance){
         throw new Exception("Insufficient Balance");
     }
     this.balance-=amount;
    }

}