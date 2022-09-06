import java.util.Scanner;
class BeautifulArrange
{
	int original_arr[],count=1;
	BeautifulArrange(int original_arr[])
	{
		this.original_arr=original_arr;
	}
	private int possibleArrange()
	{
		for(int i=0;i<original_arr.length;i++)
		{
			for(int j=i+1;j<original_arr.length;j++)
			{
				int spare[]=original_arr.clone();
				int arr[]=swapping(i,j,spare);
				if(isDivisible(arr))
					count++;
			}	
		}
		return count;
	}
	private int[] swapping(int i,int j,int temp[])
	{
		temp[i]=temp[i]+temp[j];
		temp[j]=temp[i]-temp[j];
		temp[i]=temp[i]-temp[j];		
		return temp;
	}
	private boolean isDivisible(int temp[])
	{
		boolean flag=true;
		for(int k=0;k<temp.length;k++)
		{
			if(!(temp[k]%(k+1)==0 || (k+1)%temp[k]==0))
				flag=false;
		}
		return flag;
	}	
	public static void main(String[] args)
	{
		Scanner sc;
		int array[],length;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the length of an array : ");
			length=sc.nextInt();
			array=new int[length];
			for(int i=0;i<length;i++)
				array[i]=i+1;
			System.out.println("Total combination count : "+new BeautifulArrange(array).possibleArrange());
		}	
		catch(Exception e)
		{
			System.out.println("Exception has been caught : "+e);
			e.printStackTrace();
		}
	}
}