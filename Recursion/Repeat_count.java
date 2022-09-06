import java.util.Scanner;
class Repeat_count
{
	int arr[],count=1;
	Repeat_count(int arr[],int length)
	{
		this.arr=arr;
		arr=new int[length];
	}
	void counting(int point)
	{
		if(point==(arr.length)-1)
		{
			count=(count!=1)?(count++):(count=1);
			System.out.print(arr[point]+"("+count+")"+" ");
		}
		else if(arr[point]==arr[point+1])
		{
			count++;point++;
			counting(point);
		}
		else
		{
			System.out.print(arr[point]+"("+count+")"+" ");
			count=1;point++;
			counting(point);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int array[];
		try
		{
			sc=new Scanner(System.in);
			System.out.print("Enter the length of an array :");
			int length=sc.nextInt();
			array=new int[length];
			System.out.println();
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of an array : ");
				array[i]=sc.nextInt();
			}
			System.out.println();
			Repeat_count obj=new Repeat_count(array,array.length);	
			System.out.println("Element(Count)");
			obj.counting(0); //Passing array's first index as a parameter
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e);
		}
	}
}