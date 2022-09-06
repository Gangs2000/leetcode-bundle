import package1.List_temp;
import java.util.LinkedList;
import java.util.Scanner;
class Main
{
	static List_temp obj;
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[])
	{
		int choice,length;
		try
		{
			System.out.println();
			System.out.print("Enter your choice to select data structure 1.Single Linked List 2.Doubly Linked List 3.Circular List : ");
			choice=sc.nextInt();
			System.out.println();
			System.out.print("Enter the length of the linked list : ");
			length=sc.nextInt();
			if(choice==1)
			{
				obj=new Single_linked(new LinkedList<Integer>(),length);
				Main m=new Main();
				m.task(obj);
			}
			else if(choice==2)
			{
				obj=new Double_linked(new LinkedList<Integer>(),length);
				Main m=new Main();
				m.task(obj);
			}
			else if(choice==3)
			{
				obj=new Circular_linked(length);
				Main m=new Main();
				m.task(obj);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught :"+e);
			e.printStackTrace();
		}
	}
	public void task(List_temp obj)
	{
		int oper;
		do
		{
			System.out.println();
			System.out.print("Enter an operation to perform on data structure 1.Add Element 2.Remove Element 3.Show List 4.Exit : ");
			oper=sc.nextInt();
			if(oper==1)
			{ 
				System.out.println();
				System.out.print("Enter an element to add into List : ");
				int element=sc.nextInt();
				obj.add(element);
			}
			else if(oper==2)
				obj.remove();
			else if(oper==3)
			{
				System.out.println();
				System.out.println("Current List elements..");
				obj.show();
			}
		}while(oper!=4);
	}
}