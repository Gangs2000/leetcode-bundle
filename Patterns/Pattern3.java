import java.util.Scanner;
class Pattern3
{
	void print(int n)
	{
		for(int i1=1;i1<=n;i1++)
		{
			for(int space1=1;space1<=n-i1;space1++)
				System.out.print(" ");
			for(int j1=1;j1<=i1;j1++)
				System.out.print("* ");               //Upper Triangle part
			System.out.println();
			if(i1==n)
			{
				for(int i2=n-1;i2>=1;i2--)
				{
					for(int space2=1;space2<=(n-1)-i2;space2++)
						System.out.print(" ");
					for(int j2=1;j2<=i2;j2++)
						System.out.print(" *");           //Lower Triangle part
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of length :");
		int n=sc.nextInt();
		if(n%2==0)
			System.out.println("Invalid number..");
		else
		{
			n=(n/2)+1;
			new Pattern3().print(n);
		}
	}
}