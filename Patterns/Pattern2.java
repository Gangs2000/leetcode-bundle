import java.util.Scanner;
class Pattern2
{
	int odd=1;
	void print(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int space=1;space<=n-i;space++)
				System.out.print("  ");
			for(int j=1;j<=odd;j++)
				System.out.print(j+" ");
			odd=odd+2;
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of length :");
		int n=sc.nextInt();
		new Pattern2().print(n);
	}
}