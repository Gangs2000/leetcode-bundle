package Stack.Package;
public class Queue
{
	private int array[],ele,count=0;
	public Queue(int length)
	{
		array=new int[length];
	}
	public synchronized void add(int element)
	{
		if(count!=array.length)
		{
			System.out.println("Adding element "+element+" into the queue...");
			waiting();
			array[count]=element;
			count++;
			System.out.println("Element has been added to the queue");
		}
		else
			System.out.println("Queue is full to add more elements you need to remove elements..");
	}
	public synchronized void remove()
	{
		if(count<=0)
			System.out.println("No more elements in queue to remove...");
		else
		{
			System.out.println("Removing element from the queue...");	
			ele=array[0];
			for(int i=1;i<=(count-1);i++)
				array[i-1]=array[i];
			waiting();
			count--;
			System.out.println("Element "+ele+" has been removed from queue..");
		}
	}
	public void show()
	{
		if(count==0)
			System.out.println("No more elements in the Queue..");
		else
		{
			System.out.println("Queue elements :");
			for(int i=0;i<count;i++)
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