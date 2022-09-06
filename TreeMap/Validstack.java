import java.util.Scanner;
import java.util.TreeMap;
class Validstack
{
	int push[],pop[],popPoint=0,top=-1;
	TreeMap<Integer,Integer> tm;
	boolean flag=true;
	Validstack(int push[],int pop[])
	{
		this.push=push;
		this.pop=pop;
		tm=new TreeMap<Integer,Integer>();
	}
	private boolean checkSequence()
	{
		while(true)
		{
			if(popPoint==pop.length)
				break;
			else
			{
				if(isContain(pop[popPoint]))
				{
					if(tm.lastKey()==pop[popPoint])
					{
						tm.remove(pop[popPoint]);
						popPoint++;
					}
					else
					{	
						flag=false;
						break;
					}
				}
				else
				{
					top++;
					tm.put(push[top],top);
				}
			}
		}
		return flag;
	}
	private boolean isContain(int key)
	{
		boolean answer=(tm.containsKey(key))?(true):(false);
		return answer;
	}
	public static void main(String[] args)
	{
		int pushed[],popped[],length;
		Scanner sc;
		try
		{
			sc=new Scanner (System.in);
			System.out.println("Enter the length of pushed and popped array : ");
			length=sc.nextInt();
			if(length>=0 && length<=1000)
			{
				pushed=new int[length];
				popped=new int[length];
				System.out.println("Elements assigning to Pushed array...");
				for(int i=0;i<length;i++)
				{
					System.out.print("Enter "+(i+1)+" element of pushed array : ");
					int element=sc.nextInt();
					if(Validstack.isValid(element))
						pushed[i]=element;
					else
						throw new Exception("Invalid push data..");
				}
				System.out.println("Elements assigning to Popped array...");
				for(int j=0;j<length;j++)
				{
					System.out.print("Enter "+(j+1)+" element of popped array : ");
					int element=sc.nextInt();
					if(Validstack.isValid(element))
						popped[j]=element;
					else
						throw new Exception("Invalid pop data..");
				}
				boolean output=new Validstack(pushed,popped).checkSequence();
				if(output)
					System.out.println("It is a Valid stack sequence..");
				else
					System.out.println("It is not a Valid stack sequence..");
			}
			else
				throw new Exception("Invalid length provided..");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured :"+e.getMessage());
			e.printStackTrace();
		}
	}
	public static boolean isValid(int val)
	{
		boolean flag=(val>=0 && val<=1000)?(true):(false);
		return flag;
	}
}