import Package1.Invalid_data;
import Package2.Back_end;
import java.util.*;
class Hdfc 
{
	public static void main(String[] args)
	{
		Back_end call;
		Scanner obj=new Scanner(System.in);
		long choice,account_no,balance,withdraw,deposit;
		String message;
		System.out.println("Enter your account number :");
		try
		{
			account_no=obj.nextLong();
			System.out.println("Enter your balance amount :");
			balance=obj.nextLong();
			if(balance<0)
			{
				message=" Balance amount cannot be negative value..";
				throw new Invalid_data(message);
			}
			call=new Back_end(account_no,balance);
			do
			{
				System.out.println("Enter number to perform below mentioned actions...");
				System.out.print("1.Deposit amount 2.Withdraw amount 3.Check Balance 4.Transaction history 5.Exit :");
				choice=obj.nextLong();
				if(choice==1)
				{
					System.out.println("Enter the deposit amount in Rupees - (100,200,500 or 2000):");	
					deposit=obj.nextLong();
					if(deposit<0)
					{
						message=" Deposit amount cannot be negative value..";
						throw new Invalid_data(message);
					}
					else if(deposit!=100 && deposit!=200 && deposit!=500 && deposit!=2000)
					{
						message=" Enter full amount (100,200,500 or 2000) to deposit..";
						throw new Invalid_data(message);
					}
					else
						call.deposit_amount(deposit);
				}
				else if(choice==2)
				{
					System.out.println("Enter the withdraw amount which must be lower than Rupees 15000 :");	
					withdraw=obj.nextLong();
					if(withdraw<0)	
					{
						message=" Withdraw amount cannot be negative value..";
						throw new Invalid_data(message);
					}
					else if(withdraw>balance || call.balance==0)
					{
						message=" You have an Insufficient amount..";
						throw new Invalid_data(message);
					}
					else if(withdraw>15000)
					{
						message=" Withdraw amount cannot be exceeded 15000 Rupees, Enter lower amount to fulfill the transaction..";
						throw new Invalid_data(message);
					}
					else
						call.withdraw_amount(withdraw);
				}
				else if(choice==3)
				{
					System.out.println();
					call.show();
				}
				else if(choice==4)
				{
					call.transaction_history();
				}
			}while(choice!=5);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid data bypassed..This field requires numeric entry..");
			
		}
		catch(Invalid_data e)
		{
			System.out.println("Invalid data :"+e.getMessage());
		}
		finally
		{
			System.out.println("Closing the gateway.. Please initiate the app again");
		}
	}
}
