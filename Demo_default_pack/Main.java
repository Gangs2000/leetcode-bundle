import java.util.Scanner;
class Main extends Fact
{
	public static void main(String[] args)
	{
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter a number to calculate Factorial of the given number :");
		long n=obj.nextInt();
		Fact f=new Fact();
		System.out.println("Factorial is :"+f.factorial(n));
	}
}