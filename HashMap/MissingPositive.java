import java.util.HashMap;
import java.util.Scanner;
class MissingPositive
{
	HashMap<Integer,Integer> hm;
	int max,misPos=0;
	MissingPositive(int array[],int max)
	{
		hm=new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++)
			hm.put(i,array[i]);
		this.max=max;
	}
	private int missingPos()
	{
		for(int i=1;i<=(max+1);i++)
		{
			if(!isContain(i))
			{
				misPos=i;
				break;
			}
		}
		return misPos;
	}
	private boolean isContain(int val)
	{
		boolean flag=(hm.containsValue(val))?(true):false;
		return flag;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int array[],max=0;
		try
		{
			sc=new Scanner(System.in);	
			System.out.println("Enter the length of an array : ");
			int length=sc.nextInt();
			System.out.println();
			array=new int[length];
			for(int i=0;i<length;i++)
			{
				System.out.print("Enter "+(i+1)+" element of an array : ");
				int element=sc.nextInt();
				if(max<element)
					max=element;
				array[i]=element;
			}
			int ans=new MissingPositive(array,max).missingPos();
			System.out.println();
			System.out.println("Smallest missing positive value is "+ans);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught : "+e);
			e.printStackTrace();
		}
	}
}