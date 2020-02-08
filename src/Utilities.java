import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains all the functionality 
 * used in Bank System
 */
public class Utilities extends Validation {
	static Scanner scanner=new Scanner(System.in);


	/**
	 * attribute used for checking user existence
	 */
	private boolean isNewUser=false;

	//Show account details
	protected  void mainMenu() {
		print("WELCOME TO BANKING SYSTEM"+"\n Enter a valid option to proceed\n");
		print("1. Existing User\n"
				+ "2. New User?  Open New Account\n"
				+ "3. Exit");
		int choice =scanner.nextInt();
		switch(choice) {
		case 1:
			existingUser();
			break;
		case 2:
			enterNewUser();
			break;
		case 3:
			print("Thanks For Visit...");
			return;

		default:
			print("Choose Valid Option");
			mainMenu();
		}
		// Check whether list is empty or not 

	}

	/**
	 * Checking existing user in bank data
	 */
	private void existingUser() {
		if(SessionData.I().localData.accountList.size()>0) {

			boolean isValid=true;
			long  accountNumber=0;
			do {
				try {
					print("Enter your account number");
					accountNumber= scanner.nextLong();
					if(accountNumber>0) {
						isValid=false;
					}else {
						isValid=true;
					}
				}catch(Exception e) {
					print("Error! Invalid Input");
				}
				scanner.nextLine();
			}while(isValid);
			isValid=true;


			for(int i=0;i<SessionData.I().localData.accountList.size();i++) {
				if(SessionData.I().localData.accountList.get(i).getAccountNumber()==accountNumber) {
					print("Account Holder Name:"+SessionData.I().localData.accountList.get(i).getName());
					print("Account Number :"+SessionData.I().localData.accountList.get(i).getAccountNumber());
					print("Bank Name :"+SessionData.I().localData.accountList.get(i).getBankName());
					//print("Balance :$"+SessionData.I().localData.accountList.get(i).getBalance());
					print("Account Type :"+SessionData.I().localData.accountList.get(i).getAccountType());	
					print("\n");
					isNewUser=false;
					showUserFunctionality(i);
					break;
				} else {
					isNewUser=true;
				}
			}
		}else {
			print("Congrats! You are the first customer of our bank");
			print("Create New User?");
			print("Press Y for yes or N no");
			String decision=scanner.next();

			if(decision.equalsIgnoreCase("Y")) {
				enterNewUser();
			}
			else {
				return;
			}
		}

		if(isNewUser) {
			print("Account Not Found");
			print("Create New User?");
			print("Press Y for Yes or N No");



			scanner=new Scanner(System.in);
			String decesion=scanner.nextLine();	

			switch(decesion) {

			case "Y":
				enterNewUser();
				break;
			case "N": 
				mainMenu();
				break;

			default:
				mainMenu();
				print("Choose valid option");	

				break;
			}
			//			if(decesion.equalsIgnoreCase("Y")) {					   
			//				enterNewUser();
			//			} else {					   
			//				return;
			//			}
		}
	} //end of existingUser() method

	/**
	 * Show bank features after checking existing user in bank data
	 * @param i get user object from bank data list
	 */
	protected void showUserFunctionality(int i) {
		print("1. Show Balance\n"
				+ "2. Deposit\n"
				+ "3. Withdraw\n"
				+ "4. Transfer Amount\n"
				+ "5. Pay Bills\n"
				+ "6. Mini Statement\n"
				+ "7. Edit user Profile\n"
				+ "8. Exit");
		print("Enter one number: ");
		int choice = 0;

		////

		boolean isValid=true;

		do {
			try {

				choice= scanner.nextInt();
				if(choice>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;


		/////

		switch (choice) {  
		case 1:
			getBalance(i);
			print("");
			showUserFunctionality(i);
			break;

		case 2:
			deposit(i);
			showUserFunctionality(i);

			break;
		case 3:
			withdrawAmount(i);
			showUserFunctionality(i);

			break;
		case 4:
			//		print("Enter Amount to Transfer:");
			//		double amt2 = scanner.nextDouble();
			transferFunds(i);
			showUserFunctionality(i);

			break;
		case 5:
			
			//Pay Bills 
			payBills(i);
			showUserFunctionality(i);

	
			break;
		case 6:

			//Mini Statement
			miniStatement(i);
			pressChoice(i);
			break;

		case 7: 
			
			//editUser profile 
			editUserProfile(i);
			showUserFunctionality(i);
			
			break;
		case 8: 
			
			//View Account Details
			mainMenu();
			break;

		default:

			// Validation
			print("Please enter number between 1 to 8");
			showUserFunctionality(i);			
			break;
		}	
	}

	/**
	 * Used for print the message
	 * @param msg String type data which has to be print
	 */
	protected static void print(String msg) {	
		System.out.println(msg);
	}




//	protected int getRandomNumber()
//	{
//		Random ran = new Random();
//		return ran.nextInt((99999 - 999) + 1) + 999;
//	}
	/**
	 * This function used for register new user to bank data
	 */
	protected void enterNewUser() {
		
		long accountNumber=1000;
		if(SessionData.I().localData.accountList.size()!=0) {
			int lastPosition = SessionData.I().localData.accountList.size()-1;
			long previousAccountNumber = SessionData.I().localData.accountList.get(lastPosition).getAccountNumber();
			accountNumber=previousAccountNumber+1;
		}else {
			accountNumber=1000;
		}

		print("Enter your Personal Details\n");
		
		print("Enter Name:");
		
		nameValidation();

		String bankName=  "Lambton BANK";
		
		double balance=0;
		int accountType=0;
		
		String mAccountType=null;
		print("Choose your account type\n"
				+ "1. Savings Account\n"
				+ "2. Current Account\n"
				+ "3. Recurring Deposit Account\n"
				+ "4. Fixed Deposit Account");

		//////
		boolean isValid=true;

		do {
			try {

				accountType= scanner.nextInt();
				if(accountType>=0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;
		
		////

		switch(accountType) {
		case 1 : mAccountType="Savings Account";
		print("Your Account type is Savings");
		break;

		case 2 : mAccountType="Current Account";
		print("Your Account type is Current");
		break;
		case 3: mAccountType = " Recurring Deposit Account";
		print("Your Account type is Recurring");
		break;
		case 4: mAccountType = " Fixed Deposit Account";
		print("Your Account type is Fixed");
		break;

		default: print("Please choose valid option");
		break;
		}
		
		// Enter Email 
		print("Enter your Email");
		String email=scanner.next();
		while(!checkValidation(email, Constants.EMAIL)){
			print("Enter valid Email");
			email=scanner.next();
		}
		
		print("Enter your Address");
		String address=scanner.next();
		
		//Enter Phone
		print("Enter your Phone");
		String phone=scanner.next();

		while(!checkValidation(phone, Constants.PHONE_NUMBER)){
			print("Enter valid Phone Number");
			phone=scanner.next();
		}

		print("Enter your ID Proof");
		String idProof=scanner.next();

		print("Enter your Date of Birth: (MM/DD/YYYY");
		boolean isDateFormat=false;
		Date d1=null;

		do {
			String date1=scanner.next();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setLenient(false);
			try {
				d1 = sdf.parse(date1);
				//System.out.println("TRUE");
				isDateFormat=true;
			} catch (Exception e) {
				//	System.out.println("FALSE");
				isDateFormat=false;

			}
			if(!isDateFormat){
				System.out.println("Required Pattern (Month/Day/Year)" +
						"Enter a valid Date of Birth:");
			}
		}
		while(!isDateFormat);

		String dob = d1.toString(); 

		//		print("Enter Date");
		//		String date=scanner.next();		
		//		print("Enter Month");
		//		String month=scanner.next();
		//		print("Enter Year");
		//		String year=scanner.next();
		//String dob=date+"-"+month+"-"+year;



		AccountData accountData=new AccountData(name, bankName, mAccountType, balance, accountNumber, email, 
				address, phone, idProof, dob);

		SessionData.I().localData.accountList.add(accountData);
		SessionData.I().saveLocalData();

		print("Welcome to Lambton Bank");
		print("Your account is open successfully");
		print ("Your Account Number is "+accountNumber);
		print ("Your Current Balance is: $"+balance);
		//print ("To Deposit money in your Account Press 2");


		existingUser();
	}

	/**
	 * Get current balance 
	 * @param position  Get position of user bank data object 
	 */
	protected void getBalance(int position){
		double balance=SessionData.I().localData.accountList.get(position).getBalance();
		print("Your Available Balance is:\n$"+balance);
	}

	/**
	 * Function for deposit money 
	 * @param position  Get position of user bank data object 
	 */
	protected void deposit(int position){
		print("Enter Amount to deposit:");


		double amount = 0;
		///

		boolean isValid=true;

		do {
			try {

				amount= scanner.nextDouble();
				if(amount>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;


		////

		double currentBalance = SessionData.I().localData.accountList.get(position).getBalance();
		double finalAmount=currentBalance+amount;
		SessionData.I().localData.accountList.get(position).setBalance(finalAmount);
		SessionData.I().localData.accountList.get(position).getMiniStatementList().add(miniStatementData(finalAmount, Constants.DEPOSIT));
		SessionData.I().saveLocalData();
		print("Your money is deposited successfully\n"
				+ "Deposited amount : $"+amount+"\n"
				+ "Available Balance : $"+(currentBalance+amount));
		//double newBalance = currentBalance + amount;
		//currentBalance = newBalance;						
	}

	/**
	 * Function for WithDraw Money 
	 * @param position  Get position of user bank data object 
	 */
	protected void withdrawAmount(int position) {
		print("Enter Amount to you want to withdraw :");		
		double amount = 0;	
		///

		boolean isValid=true;

		do {
			try {

				amount= scanner.nextDouble();
				if(amount>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;



		///

		double currentBalance=SessionData.I().localData.accountList.get(position).getBalance();		
		if(currentBalance >= amount){		
			currentBalance=currentBalance-amount;			
			SessionData.I().localData.accountList.get(position).setBalance(currentBalance);
			SessionData.I().localData.accountList.get(position).getMiniStatementList().add(miniStatementData(amount,Constants.DEBIT));
			SessionData.I().saveLocalData();
			System.out.println("Withdraw Successfully");
			System.out.println("Available Balance : $"+currentBalance);

		}else{
			System.out.println("Less Balance..Transaction Failed..");			
		}		
	}

	/**
	 * Transfer money to another account 
	 * @param senderPosition  Get position of user bank data object
	 */
	protected void transferFunds(int senderPosition){
		print("Enter Beneficiary Account Number: ");
		long enteredAccountNumber=0;
		boolean isAccountNumberExist= false;
		boolean isValid1=true;
		do {
			try {
				enteredAccountNumber= scanner.nextLong();
				if(enteredAccountNumber>0) {
					isValid1=false;
				}else {
					isValid1=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid1);
		int receiverPosition=0;

			for(int i=0; i<SessionData.I().localData.accountList.size();i++) {

				if(SessionData.I().localData.accountList.get(i).getAccountNumber()==enteredAccountNumber ) {
					if ( SessionData.I().localData.accountList.get(senderPosition).getAccountNumber()== enteredAccountNumber ) {
						print(" Self Account number is not allowed ");
						transferFunds(senderPosition);
					}
					isAccountNumberExist=true;
					receiverPosition=i;
					print("Acc No. : "+SessionData.I().localData.accountList.get(i).getAccountNumber()+"\n"
							+ "Name : "+SessionData.I().localData.accountList.get(i).getName()+"\n"
							+ "Address : "+SessionData.I().localData.accountList.get(i).getAddress());
					print("\nPlease verify the Beneficiary details\n"
							+ "Press Y for Yes or N for No");
					scanner=new Scanner(System.in);
					String yesOrNo=scanner.nextLine();
					if(yesOrNo.equalsIgnoreCase("y")) {
						print("Enter Amount you want to transfer:");
						double amount = 0;

						///
						boolean isValid2=true;

						do {
							try {

								amount= scanner.nextDouble();
								if(amount>0) {
									isValid2=false;
								}else {
									isValid2=true;
								}
							}catch(Exception e) {
								print("Error! Invalid Input");
							}
							scanner.nextLine();
						}while(isValid2);
						isValid2=true;

						///

						double currentBalance=SessionData.I().localData.accountList.get(senderPosition).getBalance();

						if(currentBalance>=amount){
							currentBalance=currentBalance-amount;
							SessionData.I().localData.accountList.get(senderPosition).setBalance(currentBalance);
							//							if(option==1) {
							double currentRecieverBalance=SessionData.I().localData.accountList.get(receiverPosition).getBalance();
							currentRecieverBalance=currentRecieverBalance+amount;
							SessionData.I().localData.accountList.get(senderPosition).getMiniStatementList().add(miniStatementData(amount,Constants.DEBIT));
							SessionData.I().localData.accountList.get(receiverPosition).setBalance(currentRecieverBalance);
							SessionData.I().localData.accountList.get(receiverPosition).getMiniStatementList().add(miniStatementData(amount,Constants.CREDIT));
							//							}else {
							//								SessionData.I().localData.accountList.get(position).getMiniStatementList().add(miniStatementData(amount,Constants.DEBIT));	
							//							}
							SessionData.I().saveLocalData();
							print("Transaction Success...");
						}else{
							print("Less Balance..Transaction Failed..");
						}

					}
					break;
				}
				else {
					isAccountNumberExist=false;
				}
			//}
//	}else {
//					print("Enter receivers account number");
//					long accountNumber=0;
//					print("Enter Amount:");
//					double amount = scanner.nextDouble();
//					double currentBalance=SessionData.I().localData.accountList.get(senderPosition).getBalance();
//
//					if(currentBalance>=amount){
//						currentBalance=currentBalance-amount;
//						SessionData.I().localData.accountList.get(senderPosition).setBalance(currentBalance);
//						SessionData.I().localData.accountList.get(senderPosition).getMiniStatementList().add(miniStatementData(amount,Constants.DEBIT));
//					}
//					SessionData.I().saveLocalData();
//					print("Transaction Success...");
//				}
		if(!isAccountNumberExist) {
			print("Account Number not matched");
			transferFunds(senderPosition);
		}
		showUserFunctionality(senderPosition);
	}}

	/**
	 * Function for Paying bills
	 * @param position  Get position of user bank data object 
	 */
	public void payBills(int position)	
	{
		print("Choose One Option");
		print("1. Pay Internet bills");
		print("2. Pay Other Bills  ");	


		int option=0;

		//

		boolean isValid=true;

		do {
			try {

				option= scanner.nextInt();
				if(option>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;





		//





		if (option>2) {
			print("Please enter either 1 or 2");
			payBills(position);
		}else {
			print("Enter Amount for Bill Pay");
			double amount = scanner.nextDouble();
			double currentBalance=SessionData.I().localData.accountList.get(position).getBalance();
			if (amount<=currentBalance) {
				currentBalance = currentBalance-amount;
				print("Bill Paid Succesfully...");
				System.out.println("Available Balance : $"+currentBalance);
				SessionData.I().localData.accountList.get(position).setBalance(currentBalance);
				SessionData.I().localData.accountList.get(position).getMiniStatementList().add(miniStatementData(amount, Constants.DEBIT));
				SessionData.I().saveLocalData();

			}else {

				print("Less Balance..Transaction Failed..");

			}

		}


	}

	/**
	 * This returns miniStatement data to transaction list
	 * @param amount which has to be transact
	 * @param transactionType Credit, Debit and Deposit
	 * @return
	 */
	private MiniStatementData miniStatementData(double amount,String transactionType) {
		MiniStatementData miniStatementData=new MiniStatementData(amount,transactionType);
		return miniStatementData;
	}

	/**
	 * Used to show recent transaction by user
	 * @param position Get position of user bank data object
	 */
	private void miniStatement(int position) {
		print("Account Number: " + SessionData.I().localData.accountList.get(position).getAccountNumber());
		print("Account Holder: " + SessionData.I().localData.accountList.get(position).getName());
		print("Available Balance: " + SessionData.I().localData.accountList.get(position).getBalance());
		print("Your recent transaction\n");

		if(SessionData.I().localData.accountList.get(position).getMiniStatementList().size()==0) {
			print("No data available");
		}
		else if(SessionData.I().localData.accountList.get(position).getMiniStatementList().size()<=6) {
			print("Transaction Type       Amount");
			print("================       ======");
			for(int i=0; i<SessionData.I().localData.accountList.get(position).getMiniStatementList().size();i++) {	
				showMiniStatementDesign(position, i);
			}
		}else {
			print("Transaction Type       Amount");
			print("================       ======");
			for(int i=SessionData.I().localData.accountList.get(position).getMiniStatementList().size()-6; i<SessionData.I().localData.accountList.get(position).getMiniStatementList().size();i++) {	

				showMiniStatementDesign(position, i);
			}
		}
	}

	/**
	 * set margins between amount and transaction type
	 * @param position  Get position of user bank data object
	 * @param i Get position of transaction From user
	 */
	private void showMiniStatementDesign(int position, int i) {
		if(SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getTransactionType().equalsIgnoreCase("Credit")) {	
			print("    "+SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getTransactionType()+"              "
					+ SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getAmount());
		}else if(SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getTransactionType().equalsIgnoreCase("Deposit")) {	
			print("    "+SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getTransactionType()+"             "
					+ SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getAmount());
		}else {
			print("    "+SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getTransactionType()+"             "
					+ SessionData.I().localData.accountList.get(position).getMiniStatementList().get(i).getAmount());
		}

	}

	/**
	 * Used for edit profile of User
	 * @param position Get position of user bank data object
	 */
	private void editUserProfile(int position) {
		print("Choose One Option");

		print("1. Phone Number: "+SessionData.I().localData.accountList.get(position).getPhone()+ "\n"
				+ "2. Email Id: "+SessionData.I().localData.accountList.get(position).getEmail() + "\n"
				+ "3. Address: " + SessionData.I().localData.accountList.get(position).getAddress()+ "\n"
				+ "4. Id Proof: "+ SessionData.I().localData.accountList.get(position).getIdProof() +"\n"
				+ "5. Exit ");

		int choice = 0;

		//
		boolean isValid=true;

		do {
			try {

				choice= scanner.nextInt();
				if(choice>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;


		//

		switch(choice) {
		case 1:
			print("Enter New Number");
			String phoneNo = scanner.next();
			SessionData.I().localData.accountList.get(position).setPhone(phoneNo);
			SessionData.I().saveLocalData();
			editUserProfile(position);
			break;
		case 2:
			print("Enter New Email");

			String emailId = scanner.next();
			SessionData.I().localData.accountList.get(position).setEmail(emailId);
			SessionData.I().saveLocalData();
			editUserProfile(position);
			break;
		case 3:
			print("Enter New Address");

			String address = scanner.next();
			SessionData.I().localData.accountList.get(position).setAddress(address);
			SessionData.I().saveLocalData();
			editUserProfile(position);
			break;
		case 4:
			print("Enter New Id Proof");

			String idProof = scanner.next();
			SessionData.I().localData.accountList.get(position).setIdProof(idProof);
			SessionData.I().saveLocalData();
			editUserProfile(position);
			break;
		case 5:
			print("Profile Updated....");
			showUserFunctionality(position);
			break;

		default:
			print("Choose Valid Option");
			editUserProfile(position);
			break;
		}
	}

	private void pressChoice(int position) {
		print("Choose One Option");
		print("1. Go to Main Menu: "+ "\n"
				+ "2. Go to User Menu: ");

		int choice = 0;

		//
		boolean isValid=true;

		do {
			try {

				choice= scanner.nextInt();
				if(choice>0) {
					isValid=false;
				}else {
					isValid=true;
				}
			}catch(Exception e) {
				print("Error! Invalid Input");
			}
			scanner.nextLine();
		}while(isValid);
		isValid=true;

		//
		switch(choice) {

		case 1:
			mainMenu();
			break;
		case 2: 
			showUserFunctionality(position);
			break;
		}
	}
}
