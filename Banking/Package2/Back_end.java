package Package2;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Back_end 
{
	private ArrayList<String> obj=new ArrayList<String>();
	public Long account_no,balance;
	private int i,deposit_count=0,withdraw_count=0;
	private Date date; DateFormat dateformat;
	private String stamps;	
	public Back_end(Long account_no,Long balance)
	{
		this.account_no=account_no;
		this.balance=balance;
	}
	public void deposit_amount(long deposit)
	{
		System.out.println();
		balance+=deposit;
		System.out.println("Amount deposited successfully...");
		System.out.println("Deposited amount :"+deposit);
		deposit_count++;
		String stamp=" Deposited amount : ";
		record(stamp,deposit);
		show();
	}
	public void withdraw_amount(long withdraw)
	{
		System.out.println();
		balance-=withdraw;
		System.out.println("Amount withdrawn successfully...");
		System.out.println("Withdrawn amount :"+withdraw);
		withdraw_count++;
		String stamp=" Withdrawn amount : ";
		record(stamp,withdraw);
		show();
	}
	public void transaction_history()
	{
		System.out.println();
		System.out.println("Transaction details :");
		System.out.println("Number of deposit count :"+deposit_count);
		System.out.println("Number of withdraw count :"+withdraw_count);
		System.out.println();
		if(obj.size()==0)
		{
			System.out.println("No transaction histories found for this account...");
			System.out.println();
		}
		else
		{
			for(i=0;i<obj.size();i++)
				System.out.println(obj.get(i));
			System.out.println();
		}
	}
	public void record(String stamp,Long amount)
	{
		date=Calendar.getInstance().getTime();
		dateformat=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		stamps="Time stamp : "+(dateformat.format(date))+stamp+amount;
		obj.add(stamps);
	}
	public void show()
	{
		System.out.println("Account number :"+account_no);
		System.out.println("Balance amount is :"+balance);
		System.out.println();
	}
}