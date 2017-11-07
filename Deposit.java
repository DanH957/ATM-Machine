import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Deposit.java
// Represents a deposit ATM transaction

public class Deposit extends Transaction
{
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot)
   {
      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);

      // initialize references to keypad and deposit slot
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // end Deposit constructor

   // perform transaction
   @Override
   public void execute()
   {
	   promptForDepositAmount();
   }
   public void makedeposit(double amount){
      BankDatabase bankDatabase = getBankDatabase(); // get reference
      Screen screen = getScreen(); // get reference
       // get deposit amount from user

      // check whether user entered a deposit amount or canceled
      if (amount != CANCELED)
      {
         // request deposit envelope containing specified amount
         screen.messageJLabel2.setText( "\nPlease insert a deposit envelope containing " + amount);

         // receive deposit envelope
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         // check whether deposit envelope was received
         if (envelopeReceived)
         {  
        	 screen.messageJLabel2.setText("\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not ");
              screen.messageJLabel3.setText("be available until we verify the amount of any " +
               "enclosed cash and your checks clear.");
            
            // credit account to reflect the deposit
            bankDatabase.credit(getAccountNumber(), amount); 
         } // end if
         else // deposit envelope not received
         {
        	 screen.messageJLabel2.setText("\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction.");
         } // end else
      } // end if 
      else // user canceled instead of entering amount
      {
    	  screen.messageJLabel2.setText("\nCanceling transaction...");
      } // end else
   } // end method execute

   // prompt user to enter a deposit amount in cents 
   private void promptForDepositAmount()
   {
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      screen.CreateDepositGUI(); // receive input of deposit amount
      screen.Mainframe.add( keypad.addkeypad(), BorderLayout.CENTER);
      Depositcheck check1 = new Depositcheck();  
      keypad.BEnter.addActionListener( check1 );
      screen.Mainframe.revalidate();
      // check whether the user cancelled or entered a valid amount
      
          // return dollar amount 
      } // end else
   // end method promptForDepositAmount

   private class Depositcheck implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
   	   
         double input = Integer.parseInt( screen.Inputfield2.getText() );
         double amount = input / 100;
        
         makedeposit(amount);
       
      }
   }
}
 // end class Deposit



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