import java.util.Scanner;
class Pattern1
{
	int odd=1;
	void print1(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int space=1;space<=n-i;space++)
				System.out.print("  ");
			for(int j=1;j<=odd;j++)
				System.out.print("* ");
			odd=odd+2;
			System.out.println();
		}
	}
	void print2(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int space=1;space<=n-i;space++)
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print("* ");
			odd=odd+2;
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		int n;
		System.out.println("Enter the number of height :");
		n=obj.nextInt();
		new Pattern1().print1(n);
		new Pattern1().print2(n);
	}
}