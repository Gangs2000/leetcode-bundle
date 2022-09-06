import java.util.Scanner;
class LuckyInteger
{
	int arr[],count=1,max=0;
	LuckyInteger(int arr[])
	{
		this.arr=arr;
	}
	private int lucky()
	{
		for(int i=0;i<arr.length;i++)
		{
			if(i==(arr.length)-1)
			{
				count=(count!=1)?(count++):(1);
				setMax(arr[i],count);
			}
			else if(arr[i]==arr[i+1])
				count++;
			else if(arr[i]!=arr[i+1])
				setMax(arr[i],count);
		}
		return max;
	}
	private void setMax(int a,int b)
	{
		if(a==b && (b>max))
		{
			max=b;
			count=1;
		}
		count=1;	
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int array[],length;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter length of an array :");
			length=sc.nextInt();
			array=new int[length];
			for(int i=0;i<length;i++)
			{
				System.out.println("Enter "+(i+1)+" element of an array :");
				array[i]=sc.nextInt();
			}	
			System.out.println();
			System.out.println("Lucky Integer is "+new LuckyInteger(array).lucky());
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e.getMessage());
			e.printStackTrace();
		}
	}
}