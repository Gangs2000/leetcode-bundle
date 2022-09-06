import java.util.*;
class Multiple_excep
{
	static Scanner reader=new Scanner(System.in);
	static int arr[],pos;
	Multiple_excep(int arr[],int len)
	{
		this.arr=arr;
		arr=new int[len];
	}
	static void check() throws ArrayIndexOutOfBoundsException,InputMismatchException
	{
		System.out.print("Enter the array position to get an element :");	
		pos=reader.nextInt();
		System.out.println("Element is : "+arr[pos]);
	}
	public static void main(String[] args)
	{
		int array[]={2,4,6,8,10};
		Multiple_excep obj=new Multiple_excep(array,array.length);
		try
		{
			Multiple_excep.check();
		}
		catch(ArrayIndexOutOfBoundsException | InputMismatchException e)
		{
			System.out.println("Error occured :"+e);
			e.printStackTrace();
		}
	}
}