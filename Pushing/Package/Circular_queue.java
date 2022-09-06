package Package;
public class Circular_queue
{
	private int array[];
	public int rear=-1,front=-1;
	public Circular_queue(int length)
	{
		array=new int[length];
	}
	public synchronized void add(int element)
	{
		if(front==-1 && rear==-1)
		{
			rear++;front++;
			System.out.println("Adding element "+element+" into the circular queue..");
			waiting();
			array[rear]=element;
			System.out.println("Element has been added..");
		}
		else if(((rear==(array.length)-1) && front==0) || (front==(rear+1)))
		{
			System.out.println("Circular Queue is full can't be added more element..");
		}	
		else if(rear==(array.length)-1)
		{
			rear=0;
			System.out.println("Adding element "+element+" into the circular queue..");
			waiting();
			array[rear]=element;
			System.out.println("Element has been added..");
		}
		else
		{
			rear++;
			System.out.println("Adding element "+element+" into the circular queue..");
			waiting();
			array[rear]=element;
			System.out.println("Element has been added..");
		}
	}
	public synchronized void remove()
	{
		int get_ele;
		if(front==-1)
			System.out.println("Queue is empty please add elements to the Circular queue..");
		else if(front==(array.length)-1)
		{
			System.out.println("Removing element from the circular queue..");
			get_ele=array[front];
			waiting();
			System.out.println("Element "+get_ele+" has been removed..");
			front=0;
		}
		else if(front==rear)
		{
			System.out.println("Removing element from the circular queue..");
			get_ele=array[front];
			waiting();
			System.out.println("Element "+get_ele+" has been removed..");
			front=-1;rear=-1;
		}
		else
		{
			System.out.println("Removing element from the circular queue..");
			get_ele=array[front];
			waiting();
			System.out.println("Element "+get_ele+" has been removed..");
			front++;
		}
	}
	public void show()
	{
		if((front==-1 && rear==-1))
			System.out.print("No more elements to show..");
		else
		{
			System.out.println("Circular queue elements :");
			int i=front;
        		do 
			{
            			System.out.print(array[i]+" ");
           			 if(i==rear)
               				 break;
            			i=(i+1)%(array.length);

        		}while(i!=front);
		}
		System.out.println();
	}
	public void waiting()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Exception caught :"+e);
		}
	}
}