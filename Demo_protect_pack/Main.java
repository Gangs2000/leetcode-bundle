import Package.*;
import java.util.Scanner;
class Main extends Sort
{
	int arr[],n;
	Main(int arr[],int n)
	{
		super(arr);
		this.n=n;
	}
	public static void main(String args[])
	{
		int arr[],i,n;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the lenght of an array :");
		n=obj.nextInt();
		arr=new int[n];
		for(i=0;i<n;i++)
		{
			System.out.println("Enter the "+(i+1)+" element :");
			arr[i]=obj.nextInt();
		}
		Main a=new Main(arr,n);
		a.sort();
		a.show();
	}
}