import java.util.*;
class Array_rotate
{
	int arr[],i,temp;
	Array_rotate(int arr[],int length)
	{
		this.arr=arr;
		arr=new int[length];	
	}
	void rotate(int n) throws Exception
	{	
		temp=0;
		if(n==0)
		{
			System.out.println("Rotated Array...");
			for(int j:arr)
				System.out.print(j+" ");
			System.out.println();
		}
		else
		{
			temp=arr[0];
			for(i=0;i<(arr.length)-1;i++)
				arr[i]=arr[i+1];
			arr[i]=temp;
			n=n-1;
			rotate(n);
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println();	
			System.out.print("Enter the length of an array: ");
			int length=sc.nextInt();
			int array[]=new int[length];
			System.out.println();
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of an array : ");
				array[i]=sc.nextInt();
				System.out.println();
			}
			System.out.print("Enter a number to rotate an array N number of times : ");
			int n=sc.nextInt();
			System.out.println("Original Array...");
			for(int i:array)
				System.out.print(i+" ");
			System.out.println();
			if(n<array.length)
			{
				Array_rotate obj=new Array_rotate(array,length);
				obj.rotate(n);	
			}
			else
				throw new Exception("Array can't be rotated..");
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : ");
			e.printStackTrace();
		}
	}
}