
public class AccountFactory extends Account {

   //This code is used for creating additional accounts to add to the database.
	public AccountFactory(String Username, int theAccountNumber, int thePIN, double theAvailableBalance,
			double theTotalBalance, int isadmin) {
		super(Username, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, isadmin);
		setUsername(Username);
		setAccountNumber(theAccountNumber);
		setPin(thePIN);
		setAvailableBalance(theAvailableBalance);
	      setTotalBalance(theTotalBalance);
	      setAdmin(isadmin);
	}
	}

