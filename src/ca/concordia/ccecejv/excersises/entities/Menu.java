package ca.concordia.ccecejv.excersises.entities;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        //user String inputs
        String userInput ;

        //user double inputs for withdrawal and deposits
        double minWithdraw = 0.01;
        double maxWithdraw = 10000;
        double minDeposit = 0.01;
        double maxDeposit = 5000;

        //user inputs for starting balances and interest rates
        //user entry Start Balance min and max
        double minBalanceSav = 0.01;
        double maxBalanceSav = 10000;
        double minBalanceChek = 0.01;
        double maxBalanceChek = 10000;

        //initial interest rate inputs
        double minBalanceSavInt = 0.01;
        double maxBalanceSavInt = 0.15;
        double minBalanceChekInt = 0.00;
        double maxBalanceChekInt = 0.15;

        //Greetings
        System.out.println("\n\n\n" + "+++++++++++ Welcome to the Bank Of Spades ++++++++++" + "\n\n\n");

        //messages for starting balances for saving and checking accounts //min and max
        String userStartBalanceSav = " Initializing the savings account... " + " \n Enter Starting balance amount between " + minBalanceSav + " and " + maxBalanceSav + " : ";
        String userStartBalanceChek  = " Initializing the checking account... " + " \n Enter a Starting amount between " + minBalanceChek + " and " + maxBalanceChek + " : ";

        //messages for starting interest rates for savings and checking accounts // min and max
        String userStartBalanceSavInt = "Enter annual interest rate between " + minBalanceSavInt + " and " + maxBalanceSavInt + " : ";
        String userStartBalanceChekInt  = "Enter annual interest rate between " + minBalanceChekInt + " and " + maxBalanceChekInt + " : ";

        //messages for user withdraw and deposits // min and max
        String userWithdrawal = " Enter a Withdrawal amount between " + minWithdraw + " and " + maxWithdraw + " : ";
        String userDeposit = " Enter a Deposit amount between " + minDeposit + " and " + maxDeposit + " : ";

        //top bank menu string choices
        String userTopMenu = "\n Enter A for Saving Account," +
                "\n Enter B for Checking Account," +
                "\n Enter X to Exit: ";

        //stored valid responses for top bank menu
        String[] validTopMenuResponses = {"A", "B", "X"};
        String topMenuNotValidMsg = "\n+++Did not get a valid entry+++";            //Top menu options
        String optedToExit = "\nHave a nice day";

        String userCheckingMenu = "\n Welcome to the Checking Account, \n Enter W to withdraw," +            //menu for Checking
                "\n Enter D to deposit," +
                "\n Enter R for monthly report," +
                "\n Enter Q to Exit: ";

        //valid stored user entry options
        String[] validCheckingMenuResponses = {"W", "D", "R", "Q"};
        String CheckingMenuNotValidMsg = "\n+++++Did not get a valid entry please enter again+++++";      //menu for Saving

        String userSavingMenu = "\nWelcome to the Saving Account, \n Enter W for to withdraw," +
                "\n Enter D for to deposit," +
                "\n Enter R for monthly report," +
                "\n Enter Q to Exit: ";

        //valid stored user entry options
        String[] validSavingMenuResponses = {"W", "D", "R", "Q"};
        String savingMenuNotValidMsg = "\n+++++Did not get a valid entry please enter again+++++";

        //Created User Objects with data entry options for start balances and interest rates
        //savings accounts
        Saving savingMatt = new Saving(getValidUserDoubleEntry(userStartBalanceSav,minBalanceSav,maxBalanceSav)
                ,getValidUserDoubleEntry(userStartBalanceSavInt,minBalanceSavInt,maxBalanceSavInt));

        //checking account
        Checking checkingMatt = new Checking(getValidUserDoubleEntry(userStartBalanceChek,minBalanceChek,maxBalanceChek)
                ,getValidUserDoubleEntry(userStartBalanceChekInt,minBalanceChekInt,maxBalanceChekInt));


        //initial message indicating starting balances and interest rates
        System.out.println("Initial Saving balance = " + savingMatt.currentBalance);

        System.out.println("Initial interest rate = " + savingMatt.annualInterest);

        System.out.println("Initial Checking balance = " + checkingMatt.currentBalance);

        System.out.println("Initial interest rate = " + checkingMatt.annualInterest);

        //user data input for top menu, valid entry checks, and top menu checks
        userInput = getValidUserEntry(userTopMenu, validTopMenuResponses, topMenuNotValidMsg);

    do {
                                                //bank menu

            switch (userInput) {
                //option "A" enters Savings account
                case "A" -> {   //saving menu
                    System.out.println("You Selected Saving Account");
                    switch (getValidUserEntry(userSavingMenu, validSavingMenuResponses, savingMenuNotValidMsg)) {
                        case "W" -> {
                            System.out.println("You Selected to Withdraw");
                            savingMatt.makeWithdraw(getValidUserDoubleEntry(userWithdrawal, minWithdraw, maxWithdraw));  //user Withdraw  with parameter checks
                        }
                        case "D" -> {
                            System.out.println("You Selected to Deposit");
                            savingMatt.makeDeposit(getValidUserDoubleEntry(userDeposit, minDeposit, maxDeposit));  //User Deposit with parameter checks
                        }
                        case "R" -> {
                            System.out.println("You have selected monthly report");
                            savingMatt.doMonthlyReport();  //do monthly report from super class Bank extending from Saving
                        }
                        //break out to main menu
                        case "Q" -> System.out.println("Have A Nice Day :)");
                    }
                }//checking account
                case "B" -> {
                    System.out.println("You Selected Checking Account");
                    switch (getValidUserEntryChecking(userCheckingMenu, validCheckingMenuResponses, CheckingMenuNotValidMsg)) {
                        case "W" -> {
                            System.out.println("You Selected to Withdraw ");
                            checkingMatt.makeWithdraw(getValidUserDoubleEntry(userWithdrawal, minWithdraw, maxWithdraw));  //user Withdraw  with parameter checks
                        }
                        case "D" -> {
                            System.out.println("You Selected to Deposit");
                            checkingMatt.makeDeposit(getValidUserDoubleEntry(userDeposit, minDeposit, maxDeposit));  //User Deposit with parameter checks
                        }
                        case "R" -> {
                            System.out.println("You have selected monthly report");
                            checkingMatt.doMonthlyReport();
                        }
                            //break out to main menu
                        case "Q" -> System.out.println("Returning to main menu");
                    }
                }
                            //break out of program
                case "X" -> System.out.println("Have A Nice Day :)");
            }

                         //if not X,  checks if a valid entry from stored responses
                              if (!userInput.equals("X")) {
                                    userInput = getValidUserEntry(userTopMenu, validTopMenuResponses, topMenuNotValidMsg);
                                    //otherwise exit
                                      if (userInput.equals("X")) {
                                           System.out.println(optedToExit);
            }
        }
    }while(!userInput.equalsIgnoreCase("X")); //checks letter case and ends do while loop
}
    //method checks valid responses
    //user inputs for the top bank menu
    //activates string messages for top menu
    private static String getValidUserEntry  (String userOutputMessage, String[]validResponses, String
        msgNotValid)
        {
            Scanner sc = new Scanner(System.in);

            String userInput;

            while (true)  //loop forever until valid entry
            {
                System.out.println(userOutputMessage); //user msg

                userInput = sc.nextLine();

                //loop through responses for valid match
                for (String validResponse : validResponses) {

                    //found, convert to uppercase
                    if (userInput.equalsIgnoreCase(validResponse))
                    {
                        return userInput.toUpperCase();
                    }
                }
                System.out.println(msgNotValid);  // did not match
            }
        }

    //method checks valid responses for checking and saving menus
    //user inputs for the checking and saving menu
    //activates string messages for checking and saving menu
    private static String getValidUserEntryChecking (String userOutputMessage, String[] validCheckingMenuResponses, String checkingMenuNotValidMsg)
    {
        Scanner myObj = new Scanner(System.in);

        String userInputCheck;

        while (true)  //loop forever until valid entry
        {
            System.out.println(userOutputMessage); //user msg

            userInputCheck = myObj.nextLine();

            //loop through responses for valid match
            for (String validCheckingMenuRespons : validCheckingMenuResponses) {

                if (userInputCheck.equalsIgnoreCase(validCheckingMenuRespons)) //found, convert to uppercase
                {
                    return userInputCheck.toUpperCase();
                }
            }
            System.out.println(checkingMenuNotValidMsg);  // did not match
        }
    }

    //output message to user
    //check for invalid entries such as parameters set for doubles, min and max, starting balances ect..
    private static double getValidUserDoubleEntry(String userOutputMessage, double min, double max){

        Scanner scn;

        double userInputChkSav;

        while (true) {                                                          // loop until valid entry entered
            scn = new Scanner(System.in);
            System.out.println(userOutputMessage);                              // user message
            try {
                userInputChkSav = scn.nextDouble();                                 // user input

                if (userInputChkSav < min || userInputChkSav > max) {

                    System.out.println("\nInput needs to be between " + min + " and " + max + "\n");
                }
                else

                     return userInputChkSav;
            }
            catch (Exception e) {
                System.out.println("\nInvalid input, try again\n");
            }
        }
    }
}





