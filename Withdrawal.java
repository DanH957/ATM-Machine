import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction
{
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser)
   {
      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // initialize references to keypad and cash dispenser
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   } // end Withdrawal constructor

   // perform transaction
   @Override
   public void execute()
   {
       // amount available for withdrawal

      // get references to bank database and screen
      

      // loop until cash is dispensed or the user cancels
      displayMenuOfAmounts();
   }
     public void transaction(int amount){
    	 BankDatabase bankDatabase = getBankDatabase();
         Screen screen = getScreen();
    	 boolean cashDispensed = false; // cash was not dispensed yet
         double availableBalance;
         // check whether user chose a withdrawal amount or canceled
         
            // get available balance of account involved
            availableBalance = 
               bankDatabase.getAvailableBalance(getAccountNumber());
      
            // check whether the user has enough money in the account 
            if (amount <= availableBalance)
            {   
               // check whether the cash dispenser has enough money
               if (cashDispenser.isSufficientCashAvailable(amount))
               {
                  // update the account involved to reflect the withdrawal
                  bankDatabase.debit(getAccountNumber(), amount);
                  
                  cashDispenser.dispenseCash(amount); // dispense cash
                  cashDispensed = true; // cash was dispensed

                  // instruct user to take cash
                  screen.messageJLabel7.setText("\nYour cash has been" +
                     " dispensed. Please take your cash now.");
               } // end if
               else // cash dispenser does not have enough cash
            	   screen.messageJLabel7.setText(
                     "\nInsufficient cash available in the ATM." +
                     "\n\nPlease choose a smaller amount.");
            } // end if
            else // not enough money available in user's account
            {
               screen.messageJLabel7.setText(
                  "\nInsufficient funds in your account." +
                  "\n\nPlease choose a smaller amount."); 
            } // end else
         } // end if
         // end else
     

    // end method execute

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private void displayMenuOfAmounts()
   {
	   
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      screen.createWithdrawGUI();
      screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
      withdraw1 check1 = new withdraw1();
      withdraw2 check2 = new withdraw2();
      withdraw3 check3 = new withdraw3();
      withdraw4 check4 = new withdraw4();
      withdraw5 check5 = new withdraw5();
      Keypad.B1.addActionListener(check1);
      Keypad.B2.addActionListener(check2);
      Keypad.B3.addActionListener(check3);
      Keypad.B4.addActionListener(check4);
      Keypad.B5.addActionListener(check5);
      
      
      
      screen.Mainframe.revalidate();
   }
   
   public class withdraw1 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(20);
      }
   }
   public class withdraw2 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(40);
      }
   }
   public class withdraw3 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(60);
      }
   }
   public class withdraw4 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(100);
      }
   }
   public class withdraw5 implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
        transaction(200);
      }
   }
} 




/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/