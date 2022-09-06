import java.util.Scanner;
class Intreplace
{
	int count=0;
	private int replacement(long num)
	{
		if(num==1)
		{
			System.out.print(num);
			System.out.println();
		}
		else if(num==3)
		{
			System.out.print(num+"->");
			count++;
			replacement(num-1);
		}
		else if(num%2==0)
		{
			System.out.print(num+"->");
			count++;
			replacement(num/2);
		}
		else if(num%2==1)
		{
			System.out.print(num+"->");
			count++;
			if(((num+1)/2)%2==0 && ((num-1)/2)%2==1)
			{
				System.out.print((num+1)+"->");
				count++;
				replacement((num+1)/2);
			}
			else if(((num+1)/2)%2==1 && ((num-1)/2)%2==0)
			{
				System.out.print((num-1)+"->");
				count++;
				replacement((num-1)/2);
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		long number;
		try
		{	
			sc=new Scanner(System.in);
			System.out.print("Enter the number : ");
			number=sc.nextLong();
			System.out.println();
			System.out.println("Manimum Count is "+new Intreplace().replacement(number));
		}
		catch(Exception e)
		{
			System.out.println("Exception thrown : "+e.getMessage());
			e.printStackTrace();
		}
	}
}