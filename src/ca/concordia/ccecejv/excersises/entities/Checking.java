package ca.concordia.ccecejv.excersises.entities;

public class Checking extends Bank {

              //no magic numbers. initialized given conditions to proper variable names
           protected double serviceChargePenalty = 15;
           protected double serviceChargeForMonth = 5;
           protected double serviceChargePerWithdraw = 0.10;
           protected double accountIsZero = 0;

    //method calls super from bank for balance and interest
    public Checking(double startBalance, double annualInterest)
    {
        super(startBalance, annualInterest);
    }

    @Override
    public void makeWithdraw(double withdraw)
    {
            if (currentBalance < accountIsZero)       // checks if balance is LESS than accountIsZero
            {
                System.out.println("current balance is below 0, a charge of $15.00 will be applied : " + currentBalance);
                currentBalance -= serviceChargePenalty;      //charges serviceChargePenalty dollars per entry attempt after account is below zero
                System.out.println("current balance is : " + currentBalance);

            }
            else //if account is above min threshold, make withdraw
                super.makeWithdraw(withdraw);
    }

    //basic deposit method
    @Override
    public void makeDeposit(double deposit)
    {
        super.makeDeposit(deposit);
    }

    //monthly calculations and report
    @Override
    public void doMonthlyReport() {

        monthlyServiceCharge +=  serviceChargeForMonth;  // five dollars is charged

        monthlyServiceCharge += (totalWithdrawal) * serviceChargePerWithdraw; // ten cent service charge per withdraw

        super.doMonthlyReport();

        System.out.println("current balance in your Checking is : "  + currentBalance);

    }


}
