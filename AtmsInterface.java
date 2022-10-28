	/* 	
					Developed By Abhishek Sunil Uphade 
					TASK 3 - ATM INTERFACE 
	*/

import java.util.*;
class BankDetail
{
	String User_Id , Name , Mobile_Number , Dob;   
	int User_pin ;
	int balance = 5000;
	
	void Create ()
	{
		Scanner sc = new Scanner (System.in);
		
		System.out.println(" Enter Your Name  : ");
		Name = sc.next();
		
		System.out.println(" Enter Your 10-Digit Mobile Number : ");
		Mobile_Number = sc.next();

		System.out.println(" Enter Your Date of Birth In Format DD--MM--YYYY : ");
		Dob = sc.next();
		
		System.out.println(" Generation of  UserId  : ");
 		User_Id = sc.next();

		System.out.println(" Generation of  Pin  : ");
		User_pin = sc.nextInt();
	}
	
	void Show ()
	{
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(" Your User_Id That Banks Are Provided By Bank : " + User_Id);
		System.out.println(" Your Four Digit Pin That are Provided By Bank : **** " );
		System.out.println(" Your Have Initial  Balance according To Bank Rule is : "+ balance);
		System.out.println(" Next Step Is To Login . Please Login" );
	}

	
}
class Login extends BankDetail
{
	String login_Id ;
	int pin;
	
	void login()
	{
		
		Scanner sc = new Scanner (System.in);
		System.out.println(" Enter The User_id  For login :");
		login_Id = sc.next();
		
		System.out.println(" Enter Pin for login  :");
		pin = sc.nextInt();
		if (pin == User_pin)
		{
			System.out.println(" You are eligible for Accessing Further Menu  ");
		}
		else
		{
			System.out.println(" Wrong Choice");
			System.out.println("");
			System.out.println(" Please Try Again To Login Step .....");
		}
	}
				
}

class Withdraw extends Login
{
	int Withdraw_Amount , Current_Balance;
	void Withdraw_Detail()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println(" Enter The Amount That You Want To Withdraw ");
		Withdraw_Amount = sc.nextInt();
		if (Withdraw_Amount < balance)
		{
		
			balance = balance - Withdraw_Amount ;
			System.out.println(" Your Current Balance After Withdraw is :" + balance);
		}
		else
		{
			System.out.println(" You Don't Have Enough Money To Withdraw ");
		}
	}
	void Withdraw_Display()
	{
		System.out.println(" You Had Try To Withdraw The Amount : "+Withdraw_Amount);
	}	
}
class Deposit extends Withdraw
{
	int Deposit_Amount ;
	void Deposit_Detail()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println(" Enter The Amount That You Want To Deposit");
		Deposit_Amount = sc.nextInt();
		balance = balance + Deposit_Amount ;
		System.out.println(" Your Current Blance After Deposit is :" + balance);
	}
	
	void Deposit_Display()
	{
		System.out.println(" You Had Try To Deposit The Amount : "+Deposit_Amount);
	}
}
class Transfer extends Deposit
{	
	String Account_number ;
	int Transfer_Amount ,i ;
	void Transfer_Detail()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println(" Enter The Account Number That You Have To Transfer The Money : ");
		Account_number = sc.next();
		System.out.println(" Please Check the Account Number Once Again ");
		System.out.println(" If Your Account Number Is Right Then Press key 1 ");
		i = sc.nextInt();
		if( i==1)
		{
			System.out.println(" Enter Further Details Carefully ");
		}
		else 
		{
			System.out.println(" Please Exit From Machine And Re_enter Your Detail"); 	
		}
		
		System.out.println(" Enter The Amount That You Want To Transfer");
		Transfer_Amount = sc.nextInt();
		if(Transfer_Amount < balance)
		{
			balance= balance - Transfer_Amount ;
			System.out.println(" Your Current Balance After Transfer is :" + balance);
		}
		else
		{
			System.out.println(" You Don't Have Enough Money To Transfer ");
		}
	}
	void Transfer_Display()
	{
		System.out.println(" You Had Try To Transfer The Amount : "+Transfer_Amount);
		System.out.println("");
		System.out.println(" Your have Current Balance : "+balance);
		
	}
}



class AtmsInterface
{
	public static void main (String ar[])
	{
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("******* WELCOME TO OASIS INFOBYTE ATM MACHINE **********");
		System.out.println("******* If You Are New Then Please Create Account And Then Login With Your Account Detials . If You Don't Do This Machine Will Not Work **************");
		System.out.println("******* Machine Can Do One Operation At A Time . So Plaease Be Calm **********");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		Transfer a1 = new Transfer();
		int selection;
		Scanner sc = new Scanner (System.in);
		
		do
		{
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Enter Your Choice");
		System.out.println(" 1 Create Account ");
		System.out.println(" 2 Login Account ");
		System.out.println(" 3 Witdraw Amount ");
		System.out.println(" 4 Deposit Amount ");
		System.out.println(" 5 Transfer Amount ");
		System.out.println(" 6 Transaction Details");
		System.out.println(" 7 exit");
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
		selection = sc.nextInt();

		switch(selection)
		{
			case 1 : 
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Create Account: ");
			a1.Create();
			a1.Show();
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;
			
			case 2:
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Login Detail : ");
			a1.login();
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;

			case 3:
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Withdraw Amount : ");
			a1.Withdraw_Detail();
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;
			
		
			case 4:
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Deposit Amount : ");
			a1.Deposit_Detail();
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;
			
			
			case 5:
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Transfer Amount : ");
			a1.Transfer_Detail();
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;

			case 6 :
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" *********** Transaction History *********** " );
			System.out.println("  " );
			
			
			System.out.println(" ******* Withdraw Details *******" );
			a1.Withdraw_Display();
			System.out.println("  " );
				
			System.out.println(" ******* Deposit Details *******" );
			a1.Deposit_Display();
			System.out.println("  " );
			
			System.out.println(" ******* Transfer Details ******* " );
			a1.Transfer_Display();
			System.out.println("  " );
			
			System.out.println("");	
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		
		}
	}
	while(selection!=7);

	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
	System.out.println(" Thankyou For Using OASIS INFOBYTE ATM Machine ...........");
	System.out.println(" GOOD BYE  ...........");
	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
	
	}
}
		