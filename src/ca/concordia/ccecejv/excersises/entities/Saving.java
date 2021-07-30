package ca.concordia.ccecejv.excersises.entities;

public class Saving extends Bank{

        //no magic numbers. initialized given conditions to proper variable names
   protected double accountMinimumBalance = 25;
   protected double accountMaximumWithdraw = 4;
   protected double withdrawServiceCharge = 1;
   protected double accountBalanceMin = 0;

        //method calls super from bank for balance and interest
    public Saving(double startBalance, double annualInterest)
    {

        super(startBalance, annualInterest);
    }

        //Withdraw for Saving
    @Override
    public void makeWithdraw(double withdraw)
    {
        if (accountStatus)                      //make withdraw, check if account is active
        {
            System.out.println(" account is currently active");
            super.makeWithdraw(withdraw);

            if (currentBalance < accountBalanceMin)     //checks if balance is above the minimum required balance
            {
                System.out.println("Account is inactive due to insufficient funds");    //user output msg
                accountStatus = false;
            }
        }
        else
            System.out.println("account is inactive"); //tells user account is inactive
    }

    @Override
    public void makeDeposit(double deposit)
    {
        super.makeDeposit(deposit);  //make the deposit no matter what

        if(!accountStatus && currentBalance > accountMinimumBalance ) //if false and greater than 25
        {
                accountStatus = true;
            }
        }
        //monthly calculations and report
    @Override
    public void doMonthlyReport()
    {
        if( totalWithdrawal > accountMaximumWithdraw ) //checks maximum withdraws
        {
            monthlyServiceCharge += (totalWithdrawal - accountMaximumWithdraw) * withdrawServiceCharge; // applies charge for going over withdraw threshold

        }
        super.doMonthlyReport();
    }


}
