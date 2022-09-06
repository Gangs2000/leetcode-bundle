import java.util.*;
import Package1.binarySearch;
import Package1.jumpSearch;
import Package1.interpolationSearch;
import Package2.Selection_sort;
class Search
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int i,array[],element,length,choice;
		boolean flag;
		try
		{
			System.out.print("Enter the length of an array : ");
			length=sc.nextInt();
			array=new int[length];
			for(i=0;i<length;i++)
			{
				System.out.print("Enter an "+(i+1)+" array element : ");
				array[i]=sc.nextInt();
			}
			System.out.print("Enter the element to be searched :");
			element=sc.nextInt();
			Selection_sort sort=new Selection_sort(array,length);
			sort.sorting();
			int out[]=sort.output();
			System.out.println("Sorted array....");
			for(int j:out)
				System.out.print(j+" ");
			System.out.println();
			System.out.print("Select a method to search an element 1.Binary Search 2.Jump Search 3.Interpolation Search : ");
			choice=sc.nextInt();
			if(choice==1)
			{
				binarySearch obj=new binarySearch(out,length);
				flag=obj.binary_search(element);
				System.out.println();
				if(flag)
					System.out.println("Element found in the array...");
				else
					System.out.println("Element not found in the array...");
			}
			else if(choice==2)
			{
				jumpSearch obj=new jumpSearch(out,length);
				flag=obj.findElement(element);
				if(flag)
					System.out.println("Element found in the array...");
				else
					System.out.println("Element not found in the array...");
			}
			else if(choice==3)
			{
				interpolationSearch obj=new interpolationSearch(out,length);
				flag=obj.searching(0,(out.length)-1,element);
				if(flag)
					System.out.println("Element found in the array...");
				else
					System.out.println("Element not found in the array...");
			}
		}
		catch(InputMismatchException | ArithmeticException | ArrayIndexOutOfBoundsException e )
		{
			System.out.println("Invalid data : "+e);
		}
	}
}