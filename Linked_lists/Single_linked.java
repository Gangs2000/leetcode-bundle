import package1.List_temp;
import java.util.LinkedList;
public class Single_linked extends List_temp
{
	int length,add_count=0,remove_count=0;
	public Single_linked(LinkedList<Integer> obj,int length)
	{
		super.obj=obj;
		obj=new LinkedList<Integer>();
		this.length=length;
	}
	public void add(int element)
	{
		System.out.println();
		if(add_count==length && add_count>obj.size())
			System.out.println("There is/are "+(add_count-obj.size())+" free holes available in list which can't be utilised since pointer is pointing at end of the list..");
		else if(add_count==length)
			System.out.println("Linked list queue has been filled.. Can't be added more element..");
		else
		{
			System.out.println("Adding an element "+element+" into Single linked list..");
			waiting();
			obj.add(element);
			System.out.println("Element has been added..");
			add_count++;
		}
	}
	public void remove()
	{
		System.out.println();
		if(remove_count==add_count)
		{
			System.out.println("Can't be removed elements from list since it is already empty..Re-Initializing list with the length..");
			add_count=0;remove_count=0;
		}
		else
		{
			System.out.println("Removing first element from linked list..");
			waiting();
			System.out.println("Element "+obj.remove()+" has been removed..");
			remove_count++;
		}
	}
	public void show()
	{
		if(obj.size()==0)
			System.out.print("No more elements available in list..");
		else
		{
			System.out.println("Single Linked list elements :");
			for(int i:obj)
				System.out.print(i+" -> ");
		}
		System.out.println();
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