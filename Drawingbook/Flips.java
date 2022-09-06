import java.util.Scanner;
class Flips
{
	int pages,visit,middle,numOfFlips=0;
	Flips(int pages,int visit)
	{
		this.pages=pages;
		this.visit=visit;
		middle=pages/2;
	}
	private int findTraversal()
	{
		if(middle<visit)
			numOfFlips=traverseBack(middle,visit);
		else if(pages==visit || visit==1)
			numOfFlips=0;
		else if(middle>=visit)
			numOfFlips=traverseFront(middle,visit);
		return numOfFlips;
	}
	private int traverseFront(int middle,int visit)
	{
		middle=(middle%2==1)?(middle):(middle+1);
		for(int i=1;i<=middle;)
		{
			if(i==1)
			{
				numOfFlips++;
				i=i+2;
			}
			else if(i==visit || (i-1)==visit)
				break;	
			else	
			{
				numOfFlips++;
				i=i+2;
			}
		}	
		return numOfFlips;
	}
	private int traverseBack(int middle,int visit)
	{
		int start=pages;
		if(start%2==1)
		{
			for(int i=start;i>=(middle+1);)
			{
				if(i==visit || i-1==visit)	
					break;
				else
				{
					numOfFlips++;
					i=i-2;
				}
			}
		}
		else
		{
			for(int i=start;i>=(middle+1);)
			{
				if(i==pages)
				{
					numOfFlips++;
					i=i-2;
				}
				else if(i==visit || (i+1)==visit)
					break;
				else
				{
					numOfFlips++;
					i=i-2;
				}
			}
		}
		return numOfFlips;
	}
	public static void main(String[] args)
	{
		Scanner sc;
		int numOfPages,toVisit;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter total number of pages in book : ");
			numOfPages=sc.nextInt();
			System.out.println("Enter the page you want to visit : ");
			toVisit=sc.nextInt();
			if(toVisit>numOfPages)
				throw new Exception("Invalid page number given..");
			else
				System.out.println("Minimum number of Flips : "+ new Flips(numOfPages,toVisit).findTraversal());
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred : "+e);
			e.printStackTrace();
		}
	}
}