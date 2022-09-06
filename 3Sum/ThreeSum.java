import java.util.Scanner;
class ThreeSum
{
	int arr[],target,count=0;
	ThreeSum(int arr[],int target)
	{
		this.arr=arr;
		this.target=target;
	}
	private int sumWithMul()
	{
		System.out.println("Tuples..");
		for(int i=0;i<(arr.length)-2;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				for(int k=j+1;k<arr.length;k++)
				{
					if(((arr[i]<=arr[j]) && (arr[j]<=arr[k])) && (arr[i]+arr[j]+arr[k]==target))
					{
						System.out.println("("+arr[i]+","+arr[j]+","+arr[k]+")");
						count++;
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int target,length,array[];
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter length of an array :");
			length=sc.nextInt();
			if(length<3)
				throw new Exception("Length must be greater than or equal to 3..");
			System.out.println("Enter target value :");
			target=sc.nextInt();
			array=new int[length];
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of an array :");
				array[i]=sc.nextInt();
			}
			System.out.println("Possible output : "+new ThreeSum(array,target).sumWithMul());
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e.getMessage());
			e.printStackTrace();
		}
	}
}