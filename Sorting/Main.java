import Package1.*;
import java.util.*;
class Main 
{
	public static void main(String[] args) throws InputMismatchException
	{
		int i,array[],limit;
		try
		{		
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter the array limit : ");
			limit=sc.nextInt();
			array=new int[limit];
			for(i=0;i<limit;i++)
			{
				System.out.println("Enter array "+(i+1)+" element :");
				array[i]=sc.nextInt();
			}
			System.out.print("Select sorting method 1.Selection sort 2.Insertion sort 3.Bubble sort: ");
			int choice=sc.nextInt();
			if(choice==1)
			{
				Selection_sort obj1=new Selection_sort(array,array.length);
				obj1.sorting();
				int out[]=obj1.output();
				System.out.println("Sorted the below array using Selection sort method...");
				for(int j=0;j<out.length;j++)
					System.out.print(out[j]+" ");
			}
			else if(choice==2)
			{
				Insertion_sort obj2=new Insertion_sort(array,array.length);
				obj2.sorting();
				int out[]=obj2.output();
				System.out.println("Sorted the below array using Insertion sort method...");
				for(int j=0;j<out.length;j++)
					System.out.print(out[j]+" ");
			}
			else if(choice==3)
			{
				Bubble_sort obj3=new Bubble_sort(array,array.length);
				obj3.sorting();
				int out[]=obj3.output();
				System.out.println("Sorted the below array using Bubble sort method...");
				for(int j=0;j<out.length;j++)
					System.out.print(out[j]+" ");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid data bypassed :"+e);
			e.printStackTrace();
		}
	}
}