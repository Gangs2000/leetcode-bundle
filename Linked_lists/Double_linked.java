import package1.List_temp;
import java.util.LinkedList;
import java.util.Scanner;
public class Double_linked extends List_temp
{
	int length,add_count=0,remove_count=0,mul=1;
	int start=0,end=0,r;
	Scanner sc=new Scanner(System.in);
	public Double_linked(LinkedList<Integer> obj,int length)
	{
		super.obj=obj;
		obj=new LinkedList<Integer>();
		this.length=length;
	}
	public void add(int element)
	{
		System.out.println();
		if(add_count==length)
			System.out.println("Double linked list has been filled.. Can't be added no more elements..");
		else
		{
			System.out.println("Adding an element "+element+" into Double linked list..");
			waiting();
			obj.add(element);
			System.out.println("Element has been added..");
			add_count++;
		}
	}
	public void remove()
	{
		System.out.println();
		if(add_count==remove_count)
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
			System.out.println("No more elements available in double linked list..");
		else
		{
			for(int i:obj)
				System.out.print(i+"<->");
			System.out.println();System.out.println();
			System.out.print("Enter R value to print group of nodes in reverse order : ");
			r=sc.nextInt();
			if(r==1)	
			{
				System.out.println();
				System.out.println("Current list element..");
				for(int i:obj)
					System.out.print(i+"<->");
				System.out.println();	
			}
			else if(obj.size()<r)
				System.out.println("Can't do reverse operation since R value is higher than size..");
			else
			{
				if(obj.size()%r==0)
				{
					start=1;end=r;
					reverse_method(start,end,obj.size(),r);
					start=0;end=0;mul=1;
				}
				else
				{
					start=1;end=r;
					reverse_method(start,end,(obj.size()-(obj.size()%r)),r);
					if(obj.size()-(obj.size()-(obj.size()%r))>1)
					{
						start=0;end=0;mul=1;
						start=(obj.size()-(obj.size()%r))+1;
						end=obj.size();
						r=(end-start)+1;
						reverse_method(start,end,obj.size(),r);
					}
					start=0;end=0;mul=1;
				}
			}
		}
	}
	public void reverse_method(int start,int end,int size,int r)
	{
		int spare=(end==obj.size())?(obj.size()):(r);
		int temp1=0,temp2=0;
		for(int i=start;i<=end;)
		{
			end=spare*mul;
			temp1=start;temp2=end;
			for(int j=1;j<=r/2;j++)
			{
				int a=obj.get(temp1-1);int b=obj.get(temp2-1);
				a=a+b;
				b=a-b;
				a=a-b;
				obj.set(temp1-1,a);obj.set(temp2-1,b);
				temp1++;temp2--;
			}
			if(end!=size)
			{
				start=end+1;mul++;
				temp1=0;temp2=0;
			}
			else
				break;
		}
	}
	public void waiting()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Exception caught :"+e);
		}
	}
}