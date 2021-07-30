package ca.concordia.ccecejv.excersises.entities;

import org.w3c.dom.ls.LSOutput;

public abstract class Bank {
    protected double startBalance;
    protected double currentBalance;
    protected final double annualInterest;
    protected double totalDeposit;   //amount
    protected double numberDeposit;  //count
    protected double totalWithdrawal;
    protected double numberWithdrawal;
    protected double monthlyServiceCharge;


    protected Boolean accountStatus = true; //account status is active


    protected double accountReset = 0; //Zero double, for reset
    protected double accountAtZero = 0;
    protected int annualDivision = 12; // part of yearly calculations


        //method for starting balance and interest, current balance as well
    public Bank(double startBalance, double annualInterest)
    {
        this.currentBalance = startBalance;
        this.startBalance = startBalance;
        this.annualInterest = annualInterest;
    }
        //super deposit, counts number of deposits and calculates amounts added to current balances
    public void makeDeposit(double deposit)
    {
        currentBalance += deposit;
        totalDeposit += deposit;
        numberDeposit++;
        System.out.println("In deposit = " + currentBalance + " total deposit = " + totalDeposit + " number deposit = " + numberDeposit);

    }
    //super withdraw, counts number of withdraw and calculates amounts added to current balances
    public void makeWithdraw(double withdraw)
    {
        currentBalance -= withdraw;
        totalWithdrawal++;
        System.out.println("In withdraw = " + currentBalance + " total withdraw = " + totalWithdrawal);
    }
    //super interest, calculates total interest for active accounts
    public void calculateInterest()
    {
        currentBalance += currentBalance * (annualInterest/ annualDivision);
        System.out.println(" after interest addition = " + currentBalance);
    }
    //super monthly report
    public void doMonthlyReport(){

        currentBalance -= monthlyServiceCharge; //adds the service charge to balance

        if(currentBalance > accountAtZero )  //if account above zero, call calculate interest
                calculateInterest();
        else
            System.out.println("No interest calculated because balance is less than or equal to ZERO");  //prints message to tell user account is in the negavtives

            //resets for start of month
        monthlyServiceCharge = accountReset;
        totalWithdrawal = accountReset;
        totalDeposit = accountReset;

        //prints final balance after all calculations
        System.out.println(" after monthly charge = " + currentBalance);

    }
}
