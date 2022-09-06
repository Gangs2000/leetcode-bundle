package Package;
public class Stack
{
	private int array[],ele,count=-1;
	public Stack(int length)
	{
		array=new int[length];
	}
	public synchronized void add(int element)
	{
		if(count==(array.length)-1)
			System.out.println("Stack is full can't be added more element..");
		else
		{
			System.out.println("Adding element "+element+" into the stack..");
			count++;
			waiting();
			array[count]=element;
			System.out.println("Element has been added..");
		}
	}
	public synchronized void remove()
	{
		if(count==-1)
			System.out.println("Stack is empty please add elements to the stack..");
		else
		{
			System.out.println("Removing element from the stack..");
			ele=array[count];
			waiting();
			count--;
			System.out.println("Element "+ele+" has been removed..");	
		}
	}
	public void show()
	{
		if(count==-1)
			System.out.println("No more elements in the Stack..");
		else
		{
			System.out.println("Stack elements :");
			for(int i=0;i<=count;i++)
			{
				System.out.print(array[i]+" ");
			}	
			System.out.println();
		}
	}
	public void waiting()
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Exception caught :"+e);
		}
	}
}