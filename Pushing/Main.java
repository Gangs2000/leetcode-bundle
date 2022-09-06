import Package.*;
import java.util.Scanner;
import java.util.InputMismatchException;
class Main
{
	int choice,element;
	static Queue queue;
	static Stack stack;
	static Circular_queue cir_que;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws InputMismatchException,ArrayIndexOutOfBoundsException
	{
		int i,length,oper;
		try
		{	
			System.out.print("Enter the length of an array : ");
			length=sc.nextInt();
			if(length<0)
				throw new Exception();
			System.out.println();
			System.out.print("Enter an operation to perform 1.Stack operation 2.Queue operation 3.Circular Queue operation : ");
			oper=sc.nextInt();
			System.out.println();
			if(oper==1)
			{
				stack=new Stack(length);
				Main call=new Main();
				call.tasks(oper);
			}	
			else if(oper==2)
			{
				queue=new Queue(length);
				Main call=new Main();
				call.tasks(oper);
			}
			else if(oper==3)
			{
				cir_que=new Circular_queue(length);
				Main call=new Main();
				call.tasks(oper);
			}
		}
		catch(InputMismatchException | ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Exception has been caught :"+e);
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Array element cannot be negative value :"+e);
		}
	}
	public void tasks(int oper)
	{
		do
		{
			System.out.print("Enter the choice to perform task 1. Add element 2. Remove element 3.Display element 4. Exit : ");
			choice=sc.nextInt();
			System.out.println();
			if(choice==1)
			{
				System.out.print("Enter an element : ");
				element=sc.nextInt();
				System.out.println();
				addElement add=new addElement(queue,stack,cir_que,element,oper);
				add.run();
			}
			else if(choice==2)
			{
				removeElement remove=new removeElement(queue,stack,cir_que,oper);
				remove.run();
			}
			else if(choice==3)
			{
				if(oper==1)
				{
					System.out.println("Current elements...");
					stack.show();
				}
				else if(oper==2)
				{
					System.out.println("Current elements...");
					queue.show();
				}
				else if(oper==3)
				{
					System.out.println("Current elements...");
					cir_que.show();
				}
			}	
			System.out.println();	
		}while(choice!=4);
	}
}
