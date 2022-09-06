import java.util.Scanner;
class Excep extends Exception
{
	public String toString()
	{
		return "Can't be devided by zero";
	}
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter devisor and devidend :");
		try
		{
			int divisor=obj.nextInt();
			int dividend=obj.nextInt();
			if(dividend==0)
				throw new Excep();
		}
		catch(Excep e)
		{
			System.out.println("Caught : "+e);
		}
		finally
		{
			System.out.println("Executed successfully...");
		}
	}
}