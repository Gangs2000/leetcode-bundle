import package1.List_temp;
class Circular_linked extends List_temp
{
	int rear=-1,front=-1,length;
	public Circular_linked(int length)
	{
		super.arr=arr;
		this.length=length;
		arr=new int[length];
	}
	public void add(int element)
	{
		System.out.println();
		if(front==-1 && rear==-1)
		{
			front++;rear++;
			System.out.println("Adding element "+element+" into the circular linked list..");
			waiting();
			arr[rear]=element;
			System.out.println("Element has been added..");
		}
		else if((rear==(length-1) && front==0)|| (front==(rear+1)))
			System.out.println("Circular Queue is full and Can't be added more elements..");
		else if(rear==(length-1))
		{
			System.out.println("Adding element "+element+" into the circular linked list..");
			waiting();
			rear=0;
			arr[rear]=element;
			System.out.println("Element has been added..");
		}
		else
		{
			System.out.println("Adding element "+element+" into the circular linked list..");
			waiting();
			rear++;
			arr[rear]=element;
			System.out.println("Element has been added..");
		}
	}
	public void remove()
	{
		System.out.println();
		if(front==-1)
			System.out.println("Circular list is empty.. Add more elements to the list..");
		else if(front==(length-1))
		{
			System.out.println("Removing element from the circular list..");
			waiting();
			System.out.println("Element "+arr[front]+" has been removed..");
			front=0;
		}
		else if(front==rear)
		{
			System.out.println("Removing element from the circular list..");
			waiting();
			System.out.println("Element "+arr[front]+" has been removed..");
			front=-1;rear=-1;
		}
		else
		{
			System.out.println("Removing element from the circular list..");
			waiting();
			System.out.println("Element "+arr[front]+" has been removed..");
			front++;	
		}
	}
	public void show()
	{
		if((front==-1 && rear==-1))
			System.out.print("No more elements to show..");
		else
		{
			System.out.println("Circular list elements :");
			int i=front;
        		do 
			{
            			System.out.print(arr[i]+"->");
           			 if(i==rear)
               				 break;
            			i=(i+1)%(length);

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